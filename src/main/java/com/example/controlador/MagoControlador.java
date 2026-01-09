package com.example.controlador;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.HibernateUtil;
import com.example.model.Hechizo;
import com.example.model.Mago;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class MagoControlador {
    //Metodo para guardar el Mago
    public void guardarMago(Mago mago) {
        EntityTransaction tx = null;
        try(EntityManager em = HibernateUtil.getEntityManager()) {
            tx = em.getTransaction();
            tx.begin();
            em.persist(mago); // Guardar mago en la base de datos
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error guardarMago: " + e.getMessage());
        }
    }

    //Método para actualizar el Mago
    public void actualizarBosque(Mago mago) {
        EntityTransaction tx = null;
        try(EntityManager em = HibernateUtil.getEntityManager()) {
            tx = em.getTransaction();
            tx.begin();
            em.merge(mago); //operacion que actualiza el mago
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error actualizarMago: " + e.getMessage());
        }
    }

    //Metodo para eliminar el bosque
    public void eliminarBosque(Mago mago) {
        EntityTransaction tx = null;
        try(EntityManager em = HibernateUtil.getEntityManager()) {
            tx = em.getTransaction();
            tx.begin();
            mago = em.merge(mago); // Asegurarse de que el mago está gestionado por el EntityManager
            em.remove(mago); // Eliminar el mago de la base de datos
            tx.commit();
        } catch (Exception e) {
            System.out.println("Error eliminarMago: " + e.getMessage());
        }
    }
}
