package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Anotacion de JPA para declarar la entidad
@Entity
@Table(name = "Monstruo")
public class Monstruo {

    //Anotacion de JPA para declarar el id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private int vida;
    private int fuerza;

    @Enumerated (EnumType.STRING)
    private tipoMonstruo tipo;

    //Constructor vacio JPA
    public Monstruo() {
    }

    /**
     * Constructor de Monstruo para crear un monstruo
     * @param nombre
     * @param vida
     * @param fuerza
     * @param tipo
     */
    public Monstruo(String nombre, int vida, int fuerza, tipoMonstruo tipo) {
        this.nombre = nombre;
        this.vida = vida;
        this.fuerza = fuerza;
        this.tipo = tipo;
    }

    //Enum para el tipo de monstruo
    public enum tipoMonstruo {
        OGRO,
        TROLL,
        ESPECTRO
    };

    //Getters y Setters
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

    //Si la vida llegase a ser negativa se iguala a 0
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

    /**
     * Metodo para que el monstruo ataque al mago
     * A la vida del mago se le resta la fuerza
     * @param mago
     */
    public void atacar(Mago mago) {
        mago.setVida(mago.getVida() - getFuerza());
    }
}
