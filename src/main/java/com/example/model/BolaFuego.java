package com.example.model;

import jakarta.persistence.Entity;

//Esta clase extiende hechizo
@Entity
public class BolaFuego extends Hechizo {

    //Constructor que sobreescribe el nombre
    public BolaFuego() {
        this.nombre = "Bola de fuego";
    }

    //Sobreescribimos la fncion aplicar para personalizar el daño
    @Override
    public void aplicar(Monstruo monstruo) {
        monstruo.setVida(monstruo.getVida() - 5);
    }
}
