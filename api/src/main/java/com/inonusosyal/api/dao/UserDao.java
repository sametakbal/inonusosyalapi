package com.inonusosyal.api.dao;

import com.inonusosyal.api.entity.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserDao implements IUserDao{
    private EntityManager entityManager;

    @Autowired
    public UserDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> getAllUsers() {
        Session session = entityManager.unwrap(Session.class);
        List<User> users = session.createQuery("from User",User.class).getResultList();
        return users;
    }

    @Override
    public Optional<User> getUserById(UUID id) {
        Session session = entityManager.unwrap(Session.class);
        User user =  session.get(User.class,id);
        return Optional.ofNullable(user);
    }

    @Override
    public int saveUser(User user) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(user);
        return 0;
    }

    @Override
    public int removeUser(String id) {
        Session session = entityManager.unwrap(Session.class);
        User user =  session.get(User.class,id);
        session.delete(user);
        return 0;
    }
}
