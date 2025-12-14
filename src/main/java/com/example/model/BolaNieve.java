package com.example.model;

import jakarta.persistence.Entity;

@Entity
public class BolaNieve extends Hechizo {

    public BolaNieve() {
        this.nombre = "Bola de nieve";
    }

    @Override
    public void aplicar(Monstruo monstruo) {
        monstruo.setVida(0);
    }
}

