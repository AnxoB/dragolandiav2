package com.example.controlador;

import com.example.HibernateUtil;
import com.example.model.Bosque;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class BosqueControlador {

    // Metodo para guardar el bosque
    public void guardarBosque(Bosque bosque) {
        EntityTransaction tx = null;
        try (EntityManager em = HibernateUtil.getEntityManager()) {
            tx = em.getTransaction();
            tx.begin();
            em.persist(bosque); // Guardar bosque en la base de datos
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error guardarBosque: " + e.getMessage());
        }
    }

    // Método para actualizar el bosque
    public void actualizarBosque(Bosque bosque) {
        EntityTransaction tx = null;
        try (EntityManager em = HibernateUtil.getEntityManager()) {
            tx = em.getTransaction();
            tx.begin();
            em.merge(bosque); // operacion que actualiza el bosque
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error actualizarBosque: " + e.getMessage());
        }
    }

    // Metodo para eliminar el bosque
    public void eliminarBosque(Bosque bosque) {
        EntityTransaction tx = null;
        try (EntityManager em = HibernateUtil.getEntityManager()) {
            tx = em.getTransaction();
            tx.begin();
            bosque = em.merge(bosque); // Asegurarse de que el bosque está gestionado por el EntityManager
            em.remove(bosque); // Eliminar el bosque de la base de datos
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error eliminarBosque: " + e.getMessage());
        }
    }

    // Metodo para consulta
    public Bosque consultarBosque(int id) {
        try (EntityManager em = HibernateUtil.getEntityManager()) {
            // Uso del método find con la clase Bosque y el id
            return em.find(Bosque.class, id);
        } catch (Exception e) {
            System.out.println("Error consultarBosquePorId: " + e.getMessage());
            return null;
        }
    }
}
