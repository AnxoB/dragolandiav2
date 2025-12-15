package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Monstruo")
public class Monstruo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private int vida;
    private int fuerza;

    @Enumerated (EnumType.STRING)
    private tipoMonstruo tipo;

    public Monstruo() {
    }

    public Monstruo(String nombre, int vida, int fuerza, tipoMonstruo tipo) {
        this.nombre = nombre;
        this.vida = vida;
        this.fuerza = fuerza;
        this.tipo = tipo;
    }

    public enum tipoMonstruo {
        OGRO,
        TROLL,
        ESPECTRO
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        if (vida < 0) {
            this.vida = 0;
        } else {
            this.vida = vida;
        }
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public tipoMonstruo getTipo() {
        return tipo;
    }

    public void setTipo(tipoMonstruo tipo) {
        this.tipo = tipo;
    }

    public void atacar(Mago mago) {
        mago.setVida(mago.getVida() - getFuerza());
    }
}
