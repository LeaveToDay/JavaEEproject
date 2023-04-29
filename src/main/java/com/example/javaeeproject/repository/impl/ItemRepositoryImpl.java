package com.example.javaeeproject.repository.impl;

import com.example.javaeeproject.db.DBManager;
import com.example.javaeeproject.model.Items;
import com.example.javaeeproject.repository.ItemRepository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ItemRepositoryImpl implements ItemRepository {


    @Override
    public boolean addItem(Items item) {
        try {
            if (DBManager.getTransaction() == null || !DBManager.getTransaction().isActive())
                DBManager.setTransaction(DBManager.getSession().beginTransaction());
            DBManager.getSession().save(item);
            DBManager.getTransaction().commit();

            DBManager.getSession().evict(item);

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public ArrayList<Items> getItems() {
        List<Items> items = new ArrayList<>();
        try {
            CriteriaBuilder builder = DBManager.getSession().getCriteriaBuilder();
            CriteriaQuery<Items> criteria = builder.createQuery(Items.class);
            Root<Items> root = criteria.from(Items.class);
            criteria.select(root);
            items = DBManager.getSession().createQuery(criteria).getResultList();
        } catch (Exception e) {
            return new ArrayList<>(items);
        }
        return new ArrayList<>(items);
    }

    @Override
    public Items getItem(int id) {
        Items item = null;
        try {
           item = DBManager.getSession().get(Items.class, id);
        } catch (Exception e) {
            return item;
        }
        return item;
    }

    @Override
    public boolean saveItem(Items item) {
        try {
            if (DBManager.getTransaction() == null || !DBManager.getTransaction().isActive())
                DBManager.setTransaction(DBManager.getSession().beginTransaction());
            DBManager.getSession().update(item);
            DBManager.getTransaction().commit();

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteItem(Items item) {
        try {
            if (DBManager.getTransaction() == null || !DBManager.getTransaction().isActive())
                DBManager.setTransaction(DBManager.getSession().beginTransaction());
            DBManager.getSession().delete(item);
            DBManager.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
