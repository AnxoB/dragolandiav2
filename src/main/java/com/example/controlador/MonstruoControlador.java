package com.example.controlador;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.example.HibernateUtil;
import com.example.model.Dragon;
import com.example.model.Mago;
import com.example.model.Monstruo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class MonstruoControlador {
    /**
     * Metodo para guardar un monstruo
     * @param monstruo
     */
    public void guardarMonstruo(Monstruo monstruo) {
        EntityTransaction tx = null;
        try(EntityManager em = HibernateUtil.getEntityManager()) {
            tx = em.getTransaction();
            tx.begin();
            em.persist(monstruo); // Guardar monstruo en la base de datos
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error guardarMonstruo: " + e.getMessage());
        }
    }

    /**
     * Metodo para actualizar un monstruo
     * @param monstruo
     */
    public void actualizarBosque(Monstruo monstruo) {
        EntityTransaction tx = null;
        try(EntityManager em = HibernateUtil.getEntityManager()) {
            tx = em.getTransaction();
            tx.begin();
            em.merge(monstruo); //operacion que actualiza el monstruo
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error actualizarMonstruo: " + e.getMessage());
        }
    }

    /**
     * Metodo para eliminar el bosque
     * @param monstruo
     */
    public void eliminarBosque(Monstruo monstruo) {
        EntityTransaction tx = null;
        try(EntityManager em = HibernateUtil.getEntityManager()) {
            tx = em.getTransaction();
            tx.begin();
            monstruo = em.merge(monstruo); // Asegurarse de que el monstruo está gestionado por el EntityManager
            em.remove(monstruo); // Eliminar el monstruo de la base de datos
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error eliminarMonstruo: " + e.getMessage());
        }
    }

    /**
     * Metodo para consultar el monstruo por id
     * @param id
     * @return
     */
    public Monstruo consultarMonstruo(int id) {
        try (EntityManager em = HibernateUtil.getEntityManager()) {
            // Uso del método find con la clase Dragon y el id
            return em.find(Monstruo.class, id);
        } catch (Exception e) {
            System.out.println("Error consultarMonstruo: " + e.getMessage());
            return null;
        }
    }
}
