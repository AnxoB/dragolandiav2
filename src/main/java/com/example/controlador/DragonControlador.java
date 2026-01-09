package com.example.controlador;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.HibernateUtil;
import com.example.model.Bosque;
import com.example.model.Dragon;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class DragonControlador {
    //Metodo para guardar el dragon
    public void guardarDragon(Dragon dragon) {
        EntityTransaction tx = null;
        try(EntityManager em = HibernateUtil.getEntityManager()) {
            tx = em.getTransaction();
            tx.begin();
            em.persist(dragon); // Guardar dragon en la base de datos
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error guardarDragon: " + e.getMessage());
        }
    }

    //Método para actualizar el dragon
    public void actualizarBosque(Dragon dragon) {
        EntityTransaction tx = null;
        try(EntityManager em = HibernateUtil.getEntityManager()) {
            tx = em.getTransaction();
            tx.begin();
            em.merge(dragon); //operacion que actualiza el dragon
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error actualizarDragon: " + e.getMessage());
        }
    }

    //Metodo para eliminar el bosque
    public void eliminarBosque(Dragon dragon) {
        EntityTransaction tx = null;
        try(EntityManager em = HibernateUtil.getEntityManager()) {
            tx = em.getTransaction();
            tx.begin();
            dragon = em.merge(dragon); // Asegurarse de que el dragon está gestionado por el EntityManager
            em.remove(dragon); // Eliminar el dragon de la base de datos
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error eliminarDragon: " + e.getMessage());
        }
    }
}
