package com.example.model;

import jakarta.persistence.Entity;

@Entity
public class BolaFuego extends Hechizo {

    public BolaFuego() {
        this.nombre = "Bola de fuego";
    }

    @Override
    public void aplicar(Monstruo monstruo) {
        monstruo.setVida(monstruo.getVida() - 5);
    }
}
