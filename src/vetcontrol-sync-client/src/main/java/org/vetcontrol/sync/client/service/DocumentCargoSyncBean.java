package org.vetcontrol.sync.client.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.vetcontrol.entity.*;
import org.vetcontrol.hibernate.util.EntityPersisterUtil;
import org.vetcontrol.service.ClientBean;
import org.vetcontrol.sync.SyncCargo;
import org.vetcontrol.sync.SyncDocumentCargo;
import org.vetcontrol.sync.SyncVehicle;
import org.vetcontrol.sync.client.service.exception.DBOperationException;
import org.vetcontrol.sync.client.service.exception.NetworkConnectionException;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import java.util.List;

import static org.vetcontrol.sync.client.service.ClientFactory.createJSONClient;

/**
 * @author Anatoly A. Ivanov java@inheaven.ru
 *         Date: 04.03.2010 14:11:26
 */
@Singleton(name = "DocumentCargoSyncBean")
@TransactionManagement(TransactionManagementType.BEAN)
public class DocumentCargoSyncBean extends SyncInfo {
    private static final Logger log = LoggerFactory.getLogger(DocumentCargoSyncBean.class);

    private static final int NETWORK_BATCH = 100;
    private static final int DB_BATCH_SIZE = 50;

    @EJB(beanName = "ClientBean")
    private ClientBean clientBean;

    @PersistenceContext
    private EntityManager em;

    @Resource
    private UserTransaction ut;

    public void process() {        
        processDocumentCargo();
        processVehicle();
        processCargo();
    }

    private void processDocumentCargo() {
        String secureKey = clientBean.getCurrentSecureKey();

        log.debug("\n==================== Synchronizing: DocumentCargo ============================");

        start(new SyncEvent(0, DocumentCargo.class));

        int count = em.createQuery("select count(dc) from DocumentCargo dc where dc.syncStatus = :syncStatus", Long.class).
                setParameter("syncStatus", Synchronized.SyncStatus.NOT_SYNCHRONIZED).
                getSingleResult().intValue();


        boolean isNotSynchronizedExist = count > 0;
        int i = 0;
        while (isNotSynchronizedExist) {
            List<DocumentCargo> documents = em.createQuery("select dc from DocumentCargo dc where dc.syncStatus = :syncStatus order by dc.updated",
                    DocumentCargo.class).
                    setParameter("syncStatus", Synchronized.SyncStatus.NOT_SYNCHRONIZED).
                    setFirstResult(0).
                    setMaxResults(NETWORK_BATCH).
                    getResultList();
            if (documents != null && !documents.isEmpty()) {
                try {
                    ut.begin();

                    int index = 0;

                    for (DocumentCargo dc : documents) {
                        dc.setSyncStatus(Synchronized.SyncStatus.SYNCHRONIZED);

                        EntityPersisterUtil.update(em, dc);

                        if (index++ % DB_BATCH_SIZE == 0){
                            EntityPersisterUtil.executeBatch(em);
                        }
                    }

                    EntityPersisterUtil.executeBatch(em);

                    ut.commit();
                } catch (Exception e) {
                    try {
                        ut.rollback();
                    } catch (Exception rollbackExc) {
                        log.error("Couldn't to rollback transaction.", rollbackExc);
                    }
                    throw new DBOperationException("DB operation exception.", e, DocumentCargo.class, Log.EVENT.SYNC);
                }

                try {
                    createJSONClient("/document/document_cargo").put(new SyncDocumentCargo(secureKey, null, documents));
                    sync(new SyncEvent(count, i * NETWORK_BATCH, DocumentCargo.class));
                } catch (Exception e) {
                    StringBuilder query = new StringBuilder("update DocumentCargo dc set dc.syncStatus = :newSyncStatus"
                            + " where dc.id in (");
                    for (int j = 0; j < documents.size(); j++) {
                        query.append(documents.get(j).getId());
                        if (j < documents.size() - 1) {
                            query.append(", ");
                        }
                    }
                    query.append(")");

                    try {
                        ut.begin();
                        em.createQuery(query.toString()).
                                setParameter("newSyncStatus", Synchronized.SyncStatus.NOT_SYNCHRONIZED).
                                executeUpdate();
                        ut.commit();
                    } catch (Exception updateExc) {
                        log.error("Couldn't to recover documents state.", updateExc);
                        try {
                            ut.rollback();
                        } catch (Exception rollbackExc) {
                            log.error("Couldn't to rollback transaction.", rollbackExc);
                        }
                    }
                    throw new NetworkConnectionException("Network connection exception.", e, DocumentCargo.class, Log.EVENT.SYNC);
                }
                i++;
            } else {
                isNotSynchronizedExist = false;
            }
        }

        complete(new SyncEvent(count, DocumentCargo.class));
        log.debug("++++++++++++++++++++ Synchronizing Complete: DocumentCargo +++++++++++++++++++\n");
    }

    private void processCargo() {
        String secureKey = clientBean.getCurrentSecureKey();

        log.debug("\n==================== Synchronizing: Cargo ============================");

        start(new SyncEvent(0, Cargo.class));

        int count = em.createQuery("select count(c) from Cargo c where c.syncStatus = :syncStatus", Long.class).
                setParameter("syncStatus", Synchronized.SyncStatus.NOT_SYNCHRONIZED).
                getSingleResult().intValue();

        boolean isNotSynchronizedExist = count > 0;
        int i = 0;
        while (isNotSynchronizedExist) {
            List<Cargo> cargos = em.createQuery("select c from Cargo c where c.syncStatus = :syncStatus order by c.updated", Cargo.class).
                    setParameter("syncStatus", Synchronized.SyncStatus.NOT_SYNCHRONIZED).
                    setFirstResult(0).
                    setMaxResults(NETWORK_BATCH).
                    getResultList();
            if (cargos != null && !cargos.isEmpty()) {
                try {
                    ut.begin();

                    int index = 0;

                    for (Cargo c : cargos) {
                        c.setSyncStatus(Synchronized.SyncStatus.SYNCHRONIZED);

                        EntityPersisterUtil.update(em, c);

                        if (index++ % DB_BATCH_SIZE == 0){
                            EntityPersisterUtil.executeBatch(em);
                        }
                    }

                    EntityPersisterUtil.executeBatch(em);

                    ut.commit();
                } catch (Exception e) {
                    try {
                        ut.rollback();
                    } catch (Exception rollbackExc) {
                        log.error("Couldn't to rollback transaction.", rollbackExc);
                    }
                    throw new DBOperationException("DB operation exception.", e, Cargo.class, Log.EVENT.SYNC);
                }

                try {
                    createJSONClient("/document/cargo").put(new SyncCargo(secureKey, null, cargos));
                    sync(new SyncEvent(count, i * NETWORK_BATCH, Cargo.class));
                } catch (Exception e) {
                    StringBuilder query = new StringBuilder("update Cargo c set c.syncStatus = :newSyncStatus"
                            + " where c.id in (");
                    for (int j = 0; j < cargos.size(); j++) {
                        query.append(cargos.get(j).getId());
                        if (j < cargos.size() - 1) {
                            query.append(", ");
                        }
                    }
                    query.append(")");

                    try {
                        ut.begin();
                        em.createQuery(query.toString()).
                                setParameter("newSyncStatus", Synchronized.SyncStatus.NOT_SYNCHRONIZED).
                                executeUpdate();
                        ut.commit();
                    } catch (Exception updateExc) {
                        log.error("Couldn't to recover cargos state.", updateExc);
                        try {
                            ut.rollback();
                        } catch (Exception rollbackExc) {
                            log.error("Couldn't to rollback transaction.", rollbackExc);
                        }
                    }
                    throw new NetworkConnectionException("Network connection exception.", e, Cargo.class, Log.EVENT.SYNC);
                }
                i++;
            } else {
                isNotSynchronizedExist = false;
            }
        }

        complete(new SyncEvent(count, Cargo.class));
        log.debug("++++++++++++++++++++ Synchronizing Complete: Cargo +++++++++++++++++++\n");
    }

    private void processVehicle() {
        String secureKey = clientBean.getCurrentSecureKey();

        log.debug("\n==================== Synchronizing: Vehicle ============================");

        start(new SyncEvent(0, Vehicle.class));

        int count = em.createQuery("select count(v) from Vehicle v where v.syncStatus = :syncStatus", Long.class).
                setParameter("syncStatus", Synchronized.SyncStatus.NOT_SYNCHRONIZED).
                getSingleResult().intValue();

        boolean isNotSynchronizedExist = count > 0;
        int i = 0;
        while (isNotSynchronizedExist) {
            List<Vehicle> vehicles = em.createQuery("select v from Vehicle v where v.syncStatus = :syncStatus order by v.updated", Vehicle.class).
                    setParameter("syncStatus", Synchronized.SyncStatus.NOT_SYNCHRONIZED).
                    setFirstResult(0).
                    setMaxResults(NETWORK_BATCH).
                    getResultList();
            if (vehicles != null && !vehicles.isEmpty()) {
                try {
                    ut.begin();

                    int index = 0;

                    for (Vehicle v : vehicles) {
                        v.setSyncStatus(Synchronized.SyncStatus.SYNCHRONIZED);

                        EntityPersisterUtil.update(em, v);

                        if (index++ % DB_BATCH_SIZE == 0){
                            EntityPersisterUtil.executeBatch(em);
                        }
                    }

                    EntityPersisterUtil.executeBatch(em);

                    ut.commit();
                } catch (Exception e) {
                    try {
                        ut.rollback();
                    } catch (Exception rollbackExc) {
                        log.error("Couldn't to rollback transaction.", rollbackExc);
                    }
                    throw new DBOperationException("DB operation exception.", e, Vehicle.class, Log.EVENT.SYNC);
                }

                try {
                    createJSONClient("/document/vehicle").put(new SyncVehicle(secureKey, null, vehicles));
                    sync(new SyncEvent(count, i * NETWORK_BATCH, Vehicle.class));
                } catch (Exception e) {
                    StringBuilder query = new StringBuilder("update Vehicle v set v.syncStatus = :newSyncStatus"
                            + " where v.id in (");
                    for (int j = 0; j < vehicles.size(); j++) {
                        query.append(vehicles.get(j).getId());
                        if (j < vehicles.size() - 1) {
                            query.append(", ");
                        }
                    }
                    query.append(")");

                    try {
                        ut.begin();
                        em.createQuery(query.toString()).
                                setParameter("newSyncStatus", Synchronized.SyncStatus.NOT_SYNCHRONIZED).
                                executeUpdate();
                        ut.commit();
                    } catch (Exception updateExc) {
                        log.error("Couldn't to recover vehicle state.", updateExc);
                        try {
                            ut.rollback();
                        } catch (Exception rollbackExc) {
                            log.error("Couldn't to rollback transaction.", rollbackExc);
                        }
                    }
                    throw new NetworkConnectionException("Network connection exception.", e, Vehicle.class, Log.EVENT.SYNC);
                }
                i++;
            } else {
                isNotSynchronizedExist = false;
            }
        }

        complete(new SyncEvent(count, Vehicle.class));
        log.debug("++++++++++++++++++++ Synchronizing Complete: Vehicle +++++++++++++++++++\n");
    }
}
