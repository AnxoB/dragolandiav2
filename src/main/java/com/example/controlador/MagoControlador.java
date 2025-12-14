package com.example.controlador;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.model.Mago;

public class MagoControlador {
    public void guardarMago(Mago mago){
        Session session;
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory()){
            session=factory.openSession();
            Transaction tx = session.beginTransaction();
            session.persist(mago);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void actualizarBosque(Mago mago){
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
             Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(mago);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error actualizarBosque: " + e.getMessage());
        }
    }

    public void eliminarBosque(Mago mago){
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
             Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.remove(mago);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error eliminarBosque: " + e.getMessage());
        }
    }
}
