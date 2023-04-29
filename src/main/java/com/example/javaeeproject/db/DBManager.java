package com.example.javaeeproject.db;

import com.example.javaeeproject.model.Items;
import com.example.javaeeproject.model.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//todo listener mb to end session?
public class DBManager {
    private static Session session;
    private static Transaction transaction;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(Items.class);
            configuration.addAnnotatedClass(Users.class);

            SessionFactory sessionFactory
                    = configuration.buildSessionFactory();

            session = sessionFactory.openSession();
            transaction = session.getTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Session getSession() {
        return session;
    }

    public static Transaction getTransaction() {
        return transaction;
    }

    public static void setTransaction(Transaction newTransaction) {
        transaction = newTransaction;
    }
}
