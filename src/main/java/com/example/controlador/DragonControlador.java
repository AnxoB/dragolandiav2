package com.example.controlador;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.model.Dragon;

public class DragonControlador {
    public void guardarDragon(Dragon dragon){
        Session session = null;
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory()){
            session=factory.openSession();
            Transaction tx = session.beginTransaction();
            session.persist(dragon);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void actualizarDragon(Dragon dragon){
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory()){
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            session.merge(dragon);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void eliminarDragon(Dragon dragon){
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory()){
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            session.remove(dragon);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
