package org.vetcontrol.document.service;

import org.vetcontrol.entity.Cargo;
import org.vetcontrol.entity.Department;
import org.vetcontrol.entity.DocumentCargo;
import org.vetcontrol.service.UserProfileBean;
import org.vetcontrol.util.DateUtil;
import org.vetcontrol.web.security.SecurityRoles;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author Anatoly A. Ivanov java@inheaven.ru
 *         Date: 12.01.2010 18:22:06
 */
@Stateless
@RolesAllowed({SecurityRoles.DOCUMENT_CREATE, SecurityRoles.DOCUMENT_EDIT, SecurityRoles.DOCUMENT_DEP_VIEW})
public class DocumentCargoBean {
    public static enum OrderBy{
        ID, MOVEMENT_TYPE, VECHICLE_TYPE, VECHICLE_DETAILS, CARGO_RECEIVER, CARGO_SENDER, CARGO_PRODUCER, CREATED
    }

    @PersistenceContext
    private EntityManager entityManager;

    @EJB(beanName = "UserProfileBean")
    private UserProfileBean userProfileBean;

    public DocumentCargo loadDocumentCargo(Long id){
        DocumentCargo documentCargo = entityManager.find(DocumentCargo.class, id);
        //load collection
        documentCargo.getCargos().size();
        return documentCargo;
    }

    public void save(DocumentCargo documentCargo){                       
        if (documentCargo.getId() != null){
            List<Cargo> dbCargos = entityManager
                    .createQuery("from Cargo dc where dc.documentCargo = :documentCargo", Cargo.class)
                    .setParameter("documentCargo", documentCargo)
                    .getResultList();

            for (Cargo db : dbCargos){
                boolean remove = true;

                for (Cargo ui : documentCargo.getCargos()){
                    if (db.getId().equals(ui.getId())){
                        remove = false;
                        break;
                    }
                }

                if (remove){
                    entityManager.remove(db);
                }
            }
            documentCargo.setUpdated(DateUtil.getCurrentDate());
            entityManager.merge(documentCargo);
        }else{
            documentCargo.setCreator(userProfileBean.getCurrentUser());
            documentCargo.setCreated(DateUtil.getCurrentDate());
            entityManager.persist(documentCargo);
        }
    }
      

    public Long getDocumentCargosSize(DocumentCargoFilter filter){
        Query query = entityManager.createQuery("select count(distinct dc) from DocumentCargo dc "
                + getJoin(filter, null)
                + getWhere(filter));
        setParameters(filter, query);
        
        return (Long)query.getSingleResult();
    }
                                                                      
    public List<DocumentCargo> getDocumentCargos(DocumentCargoFilter filter, int first, int count, OrderBy orderBy, boolean asc){
        String select = "select distinct dc from DocumentCargo dc " + getJoin(filter, orderBy);
        String where = getWhere(filter);

        String order = "";
        switch (orderBy){
            case ID:
                order += " order by dc.id";
                break;
            case MOVEMENT_TYPE:
                order += getOrderLocaleFilter("movementType");
                break;
            case VECHICLE_TYPE:
                order += getOrderLocaleFilter("vehicleType");
                break;
            case VECHICLE_DETAILS:
                order += " order by dc.vehicleDetails";
                break;
            case CARGO_SENDER:
                order += getOrderLocaleFilter("cargoSender");
                break;
            case CARGO_RECEIVER:
                order += getOrderLocaleFilter("cargoReceiver");
                break;
            case CARGO_PRODUCER:
                order += getOrderLocaleFilter("cargoProducer");
                break;
            case CREATED:
                order += " order by dc.created";
                break;
        }
        order += (asc ? " asc" : " desc");
       
        TypedQuery<DocumentCargo> query = entityManager.createQuery(select + where + order, DocumentCargo.class);
        setParameters(filter, query);

        return query.setFirstResult(first).setMaxResults(count).getResultList();
    }

    private String getOrderLocaleFilter(String entity){
        return " order by m_" + entity;
    }

    private String getSelectLocaleFilter(String entity){
        return " left join dc." + entity + ".namesMap as m_"+entity;
    }
    
    private String getJoin(DocumentCargoFilter filter, OrderBy orderBy){
        String join = " ";
        if (filter.getCargoSenderName() != null  || OrderBy.CARGO_SENDER.equals(orderBy)){
            join += getSelectLocaleFilter("cargoSender");
        }

        if (filter.getCargoReceiverName() != null || OrderBy.CARGO_RECEIVER.equals(orderBy)){
            join += getSelectLocaleFilter("cargoReceiver");
        }

        if (filter.getCargoProducerName() != null || OrderBy.CARGO_PRODUCER.equals(orderBy)){
            join += getSelectLocaleFilter("cargoProducer");
        }

        if (OrderBy.MOVEMENT_TYPE.equals(orderBy)){
            join += getSelectLocaleFilter ("movementType");
        }else if (OrderBy.VECHICLE_TYPE.equals(orderBy)){
            join += getSelectLocaleFilter ("vehicleType");
        }

        return join;
    }

    private String getWhere(DocumentCargoFilter filter){
        String  where = "";
        if (filter != null){
            where = " where 1+1=2";

            if (filter.getCreator() != null){
                where += " and dc.creator = :creator";
            }

            if (filter.getDepartment() != null){
                if (filter.isChildDepartments()){
                    where += " and (dc.creator.department = :department" +
                            " or dc.creator.department.parent = :department " +
                            " or exists(select 1 from Department d where d.parent = :department" +
                            " and d.id = dc.creator.department.parent.id))";
                }else{
                    where += " and dc.creator.department = :department";
                }
            }

            if (filter.getMovementType() != null){
                where += " and dc.movementType = :movementType";
            }

            if (filter.getVehicleType() != null){
                where += " and dc.vehicleType = :vehicleType";
            }

            if (filter.getVehicleDetails() != null){
                where += " and upper(dc.vehicleDetails) like :vehicleDetails";
            }

            if (filter.getCargoSenderName() != null){
                where += " and upper(m_cargoSender) like :cargoSenderName";
            }

            if (filter.getCargoReceiverName() != null){
                where += " and upper(m_cargoReceiver) like :cargoReceiverName";
            }

            if (filter.getCargoProducerName() != null){
                where += " and upper(m_cargoProducer) like :cargoProducerName";
            }

            if (filter.getDetentionDetails() != null){
                where += " and upper(dc.detentionDetails) like :detentionDetails";
            }

            if (filter.getDetails() != null){
                where += " and upper(dc.details) like :details";
            }

            if (filter.getCreated() != null){
                where += " and dc.created between :created and :created_end_day";
            }

            if (filter.getId() != null){
                where += " and dc.id = :id";
            }
        }

        return where;
    }

    private void setParameters(DocumentCargoFilter filter, Query query){
        if (filter != null){
            addParameter(query, "id", filter.getId());
            addParameter(query, "creator", filter.getCreator());
            addParameter(query, "department", filter.getDepartment());
            addParameter(query, "movementType", filter.getMovementType());
            addParameter(query, "vehicleType", filter.getVehicleType());
            addParameter(query, "vehicleDetails", filter.getVehicleDetails());
            addParameter(query, "cargoSenderName", filter.getCargoSenderName());
            addParameter(query, "cargoReceiverName", filter.getCargoReceiverName());
            addParameter(query, "cargoProducerName", filter.getCargoProducerName());
            addParameter(query, "detentionDetails", filter.getDetentionDetails());
            addParameter(query, "details", filter.getDetails());
            if (filter.getCreated() != null){
                query.setParameter("created", filter.getCreated());
                query.setParameter("created_end_day", DateUtil.getEndOfDay(filter.getCreated()));
            }
        }
    }

    private void addParameter(Query query, String parameter, Object object){
        if (object != null) query.setParameter(parameter, object);
    }

    private void addParameter(Query query, String parameter, String s){
        if (s != null) query.setParameter(parameter, "%" + s.toUpperCase() + "%");
    }

    public <T> List<T> getList(Class<T> _class){
        return entityManager.createQuery("from " + _class.getSimpleName(), _class).getResultList();
    }

    public List<Department> getChildDepartments(Department department){
        List<Department> list = entityManager.createQuery("select d from Department d where d.parent = :department " +
                "or d.parent.parent = :department", Department.class)
                .setParameter("department", department)
                .getResultList();

        list.add(0, department);

        return list;
    }

}