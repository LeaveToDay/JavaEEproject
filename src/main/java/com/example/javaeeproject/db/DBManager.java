package com.example.javaeeproject.db;

import com.example.javaeeproject.model.Items;
import com.example.javaeeproject.model.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBManager {
    private static Session session;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(Items.class);
            configuration.addAnnotatedClass(Users.class);

            SessionFactory sessionFactory
                    = configuration.buildSessionFactory();

            session = sessionFactory.openSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Session getSession() {
        return session;
    }
}
