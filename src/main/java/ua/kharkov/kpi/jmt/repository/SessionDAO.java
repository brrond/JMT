package ua.kharkov.kpi.jmt.repository;

import ua.kharkov.kpi.jmt.model.Session;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Date;
import java.util.List;

@Singleton
public class SessionDAO {

    @PersistenceContext
    private EntityManager em;

    public void save(Session session) {
        em.persist(session);
    }

    public void remove(Session session) {
        em.remove(session);
    }

    public Session findSession(Session session) {
        return em.find(Session.class, session.getSessionId());
    }

    public Session findSessionById(Long sessionId) {
        return em.find(Session.class, sessionId);
    }

    public List<Session> findSessionsByUserId(Long userId) {
        return em.createQuery("SELECT ses FROM session ses WHERE ses.userId=:userId", Session.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    public List<Session> findSessionsByDate(Date date) {
        return em.createQuery("SELECT ses FROM session ses WHERE ses.date=:date", Session.class)
                .setParameter("date", date)
                .getResultList();
    }

}
