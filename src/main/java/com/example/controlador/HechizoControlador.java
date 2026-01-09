package com.example.controlador;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.HibernateUtil;
import com.example.model.Dragon;
import com.example.model.Hechizo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class HechizoControlador {
    //Metodo para guardar el Hechizo
    public void guardarHechizo(Hechizo hechizo) {
        EntityTransaction tx = null;
        try(EntityManager em = HibernateUtil.getEntityManager()) {
            tx = em.getTransaction();
            tx.begin();
            em.persist(hechizo); // Guardar hechizo en la base de datos
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error guardarHechizo: " + e.getMessage());
        }
    }

    //Método para actualizar el hechizo
    public void actualizarBosque(Hechizo hechizo) {
        EntityTransaction tx = null;
        try(EntityManager em = HibernateUtil.getEntityManager()) {
            tx = em.getTransaction();
            tx.begin();
            em.merge(hechizo); //operacion que actualiza el hechizo
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error actualizarHechizo: " + e.getMessage());
        }
    }

    //Metodo para eliminar el bosque
    public void eliminarBosque(Hechizo hechizo) {
        EntityTransaction tx = null;
        try(EntityManager em = HibernateUtil.getEntityManager()) {
            tx = em.getTransaction();
            tx.begin();
            hechizo = em.merge(hechizo); // Asegurarse de que el hechizo está gestionado por el EntityManager
            em.remove(hechizo); // Eliminar el hechizo de la base de datos
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error eliminarHechizo: " + e.getMessage());
        }
    }
}
