package com.example.model;

import jakarta.persistence.Entity;

//Clase Rayo que extiende hechizo
@Entity
public class Rayo extends Hechizo {

    //Constructor que sobreescribe el nombre
    public Rayo() {
        this.nombre = "Rayo";
    }

    //Sobreescribimos la funcion aplicar para personalizar el daño
    @Override
    public void aplicar(Monstruo monstruo) {
        monstruo.setVida(monstruo.getVida() - 10);
    }
}

