package org.vetcontrol.logging.service;

import org.vetcontrol.entity.Log;
import org.vetcontrol.logging.util.DisplayUserUtil;
import org.vetcontrol.util.DateUtil;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author Anatoly A. Ivanov java@inheaven.ru
 *         Date: 27.01.2010 10:57:57
 */
@Stateless
public class LogListBean {

    public static enum OrderBy {

        ID, DATE, LOGIN, CONTROLLER_CLASS, MODEL_CLASS, MODULE, EVENT, STATUS, DESCRIPTION, CLIENT
    }
    @PersistenceContext
    private EntityManager entityManager;

    public Long getLogsCount(LogFilter filter) {
        String select = "select count(l) from Log l" + getWhere(filter);

        TypedQuery<Long> query = entityManager.createQuery(select, Long.class);
        addParameters(filter, query);

        return query.getSingleResult();
    }

    public List<Log> getLogs(LogFilter filter, int first, int count, OrderBy orderBy, boolean asc) {
        String select = "select l from Log l" + getWhere(filter);
        String dir = asc ? "asc" : "desc";

        switch (orderBy) {
            case ID:
                select += " order by l.id " + dir;
                break;
            case DATE:
                select += " order by l.date " + dir;
                break;
            case LOGIN:
                select += " order by l.user.login " + dir;
                break;
            case CONTROLLER_CLASS:
                select += " order by l.controllerClass " + dir;
                break;
            case MODEL_CLASS:
                select += " order by l.modelClass " + dir;
                break;
            case MODULE:
                select += " order by l.module " + dir;
                break;
            case EVENT:
                select += " order by l.event " + dir;
                break;
            case STATUS:
                select += " order by l.status " + dir;
                break;
            case DESCRIPTION:
                select += " order by l.description " + dir;
                break;
            case CLIENT:
                select += " order by l.client.id " + dir;
                break;
        }

        TypedQuery<Log> query = entityManager.createQuery(select, Log.class).setFirstResult(first).setMaxResults(count);

        addParameters(filter, query);

        return query.getResultList();
    }

    private String getWhere(LogFilter filter) {
        String where = " where 1+1=2";

        if (filter != null) {
            if (filter.getId() != null) {
                where += " and l.id like :id";
            }
            if (filter.getDate() != null) {
                where += " and l.date between :date_s and :date_e";
            }
            if (filter.getLogin() != null) {
                if (filter.getLogin().equalsIgnoreCase(DisplayUserUtil.SYSTEM_USER_LOGIN)) {
                    where += " and l.user is null";
                } else {
                    where += " and l.user.login like :login";
                }
            }
            if (filter.getControllerClass() != null) {
                where += " and upper(l.controllerClass) like :controllerClass";
            }
            if (filter.getModelClass() != null) {
                where += " and upper(l.modelClass) like :modelClass";
            }
            if (filter.getModule() != null) {
                where += " and l.module = :module";
            }
            if (filter.getEvent() != null) {
                where += " and l.event = :event";
            }
            if (filter.getStatus() != null) {
                where += " and l.status = :status";
            }
            if (filter.getDescription() != null) {
                where += " and upper(l.description) like :description";
            }
            if (filter.getClient() != null) {
                where += " and l.client.id = :client";
            }
        }

        return where;
    }

    private void addParameters(LogFilter filter, Query query) {
        if (filter != null) {
            if (filter.getId() != null) {
                query.setParameter("id", filter.getId());
            }
            if (filter.getDate() != null) {
                query.setParameter("date_s", filter.getDate());
                query.setParameter("date_e", DateUtil.getEndOfDay(filter.getDate()));
            }
            if (filter.getLogin() != null) {
                if (!filter.getLogin().equalsIgnoreCase(DisplayUserUtil.SYSTEM_USER_LOGIN)) {
                    query.setParameter("login", "%" + filter.getLogin() + "%");
                }
            }
            if (filter.getControllerClass() != null) {
                query.setParameter("controllerClass", "%" + filter.getControllerClass() + "%");
            }
            if (filter.getModelClass() != null) {
                query.setParameter("modelClass", "%" + filter.getModelClass() + "%");
            }
            if (filter.getModule() != null) {
                query.setParameter("module", filter.getModule());
            }
            if (filter.getEvent() != null) {
                query.setParameter("event", filter.getEvent());
            }
            if (filter.getStatus() != null) {
                query.setParameter("status", filter.getStatus());
            }
            if (filter.getDescription() != null) {
                query.setParameter("description", "%" + filter.getDescription() + "%");
            }
            if (filter.getClient() != null) {
                Long clientId = -1L;
                try {
                    clientId = Long.valueOf(filter.getClient());
                } catch (NumberFormatException e) {
                }
                query.setParameter("client", clientId);
            }
        }
    }

    public List<String> getControllerClasses() {
        return entityManager.createQuery("select distinct l.controllerClass from Log l where l.controllerClass is not null",
                String.class).getResultList();
    }

    public List<String> getModelClasses() {
        return entityManager.createQuery("select distinct l.modelClass from Log l where l.modelClass is not null",
                String.class).getResultList();
    }
}
