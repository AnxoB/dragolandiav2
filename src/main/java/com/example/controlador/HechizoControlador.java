package com.example.controlador;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.model.Hechizo;

public class HechizoControlador {
    public void guardarHechizo(Hechizo hechizo){
        Session session = null;
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory()){
            session=factory.openSession();
            Transaction tx = session.beginTransaction();
            session.persist(hechizo);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void actualizarHechizo(Hechizo hechizo){
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory()){
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            session.merge(hechizo);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void eliminarHechizo(Hechizo hechizo){
        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory()){
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            session.remove(hechizo);
            tx.commit();;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
