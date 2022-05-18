package ua.kharkov.kpi.jmt.repository;

import ua.kharkov.kpi.jmt.model.User;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Singleton
public class UserDAO {

    /**
     * <b>EntityManager</b> to get data
     */
    @PersistenceContext
    private EntityManager manager;

    /**
     * Method to persist user<br>
     * This method allows saving new user or saving edited user
     * @param user <b>User</b> to persist
     */
    public void persist(User user) {
        manager.persist(user);
    }

    public void merge(User user) {
        manager.merge(user);
    }

    /**
     * Method to remove user from database
     * @param user <b>User</b> to remove
     */
    public void remove(User user) {
        user = findUser(user);
        manager.remove(user);
    }

    /**
     * Method allows obtaining <b>User</b> entity
     * @param user - <b>User</b> to find
     * @return <b>User</b> from DataAccessObject
     */
    public User findUser(User user) {
        try {
            return manager.find(User.class, user.getUserId());
        } catch(NoResultException e) {
            return null;
        }
    }

    public User findUserById(int userId) {
        try {
            return manager.find(User.class, userId);
        } catch(NoResultException e) {
            return null;
        }
    }

    public User findUserByEmail(String email) {
        try {
            return (User) manager.createQuery("SELECT acc FROM account acc WHERE acc.email=:email")
                    .setParameter("email", email)
                    .getSingleResult();
        } catch(NoResultException e) {
            return null;
        }
    }

    public User findUserByUsername(String username) {
        try {
        return (User) manager.createQuery("SELECT acc FROM account acc WHERE acc.username=:username")
                .setParameter("username", username)
                .getSingleResult();
        } catch(NoResultException e) {
            return null;
        }
    }

    public long getUserCount() {
        try {
        return manager.createQuery("SELECT COUNT(acc) FROM account acc", Long.class).getSingleResult();
        } catch(NoResultException e) {
            return 0;
        }
    }

}
