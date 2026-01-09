package com.example.model;

import java.util.List;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Hechizo {

    //Id de hechizo
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    protected String nombre;

    //Relacion N:1 con Mago
    @ManyToOne
    @JoinColumn(name = "mago_id")
    private Mago mago;

    //Método para deinir el Mago (sin uso)
    public void setMago(Mago mago) {
        this.mago = mago;
    }

    //Metodo para sobreescribir a las clases de extender
    public abstract void aplicar(Monstruo monstruo);

    //Metodo para conseguir el nombre
    public String getNombre() {
        return nombre;
    }
}

