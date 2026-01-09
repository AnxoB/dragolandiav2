package com.example.model;

import jakarta.persistence.Entity;

//Clase que extiende hechizo
@Entity
public class BolaNieve extends Hechizo {

    //Constructor que sobreescribe el nombre
    public BolaNieve() {
        this.nombre = "Bola de nieve";
    }

    //Sobreescribimos la fncion aplicar para personalizar el daño
    @Override
    public void aplicar(Monstruo monstruo) {
        monstruo.setVida(0);
    }
}

