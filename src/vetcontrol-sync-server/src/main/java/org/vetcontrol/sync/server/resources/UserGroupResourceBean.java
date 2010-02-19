package org.vetcontrol.sync.server.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.vetcontrol.entity.Client;
import org.vetcontrol.entity.UserGroup;
import org.vetcontrol.service.ClientBean;
import org.vetcontrol.service.LogBean;
import org.vetcontrol.sync.SyncRequestEntity;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * @author Anatoly A. Ivanov java@inheaven.ru
 *         Date: 17.02.2010 14:46:24
 */
@Stateless
@Path("/usergroup")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserGroupResourceBean {
     private static final Logger log = LoggerFactory.getLogger(UserResourceBean.class);

    @PersistenceContext
    private EntityManager em;

    @EJB(beanName = "ClientBean")
    private ClientBean clientBean;

    @EJB(beanName = "LogBean")
    private LogBean logBean;

    @POST @Path("/list")    
    public GenericEntity<List<UserGroup>> getUserGroups(SyncRequestEntity requestEntity){
        Client client;
        try {
            client = clientBean.getClient(requestEntity.getSecureKey());
        } catch (Exception e) {
            log.error("Клиент не найден.", e);

            throw new WebApplicationException(Response.status(Response.Status.FORBIDDEN)
                    .entity("Клиент не найден.")
                    .type("text/plain;charset=UTF-8")
                    .build());
        }

        return new GenericEntity<List<UserGroup>>(em.createQuery("select ug from UserGroup ug, User u " +
                "where ug.login = u.login and u.department = :department and ug.updated >= :updated", UserGroup.class)
                .setParameter("department", client.getDepartment())
                .setParameter("updated", requestEntity.getUpdated())
                .getResultList()){};
    }
}