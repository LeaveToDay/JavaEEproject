package com.example.javaeeproject.repository.impl;

import com.example.javaeeproject.db.DBManager;
import com.example.javaeeproject.model.Users;
import com.example.javaeeproject.repository.UserRepository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public boolean addUser(Users user) {
        try {
            DBManager.getSession().beginTransaction();
            DBManager.getSession().save(user);
            DBManager.getSession().getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Users getUser(String email) {
        Users user = null;
        try {
            CriteriaBuilder builder = DBManager.getSession().getCriteriaBuilder();
            CriteriaQuery<Users> criteria = builder.createQuery(Users.class);
            Root<Users> root = criteria.from(Users.class);
            criteria.select(root).where(builder.equal(root.get("email"), email));
            List<Users> users = DBManager.getSession().createQuery(criteria).getResultList();

            if (users.size() > 0)
                user = users.get(0);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
