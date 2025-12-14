package com.example.model;

import jakarta.persistence.Entity;

@Entity
public class Rayo extends Hechizo {

    public Rayo() {
        this.nombre = "Rayo";
    }

    @Override
    public void aplicar(Monstruo monstruo) {
        monstruo.setVida(monstruo.getVida() - 10);
    }
}

