package com.example.controlador;

import com.example.HibernateUtil;
import com.example.model.Bosque;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class BosqueControlador {

    public void guardarBosque(Bosque bosque) {
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            em = HibernateUtil.getEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.persist(bosque); // Guardar bosque en la base de datos
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error guardarBosque: " + e.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void actualizarBosque(Bosque bosque) {
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            em = HibernateUtil.getEntityManager();
            tx = em.getTransaction();
            tx.begin();
            em.merge(bosque); // Actualizar el bosque en la base de datos
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error actualizarBosque: " + e.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void eliminarBosque(Bosque bosque) {
        EntityManager em = null;
        EntityTransaction tx = null;
        try {
            em = HibernateUtil.getEntityManager();
            tx = em.getTransaction();
            tx.begin();
            bosque = em.merge(bosque); // Asegurarse de que el bosque está gestionado por el EntityManager
            em.remove(bosque); // Eliminar el bosque de la base de datos
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error eliminarBosque: " + e.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
