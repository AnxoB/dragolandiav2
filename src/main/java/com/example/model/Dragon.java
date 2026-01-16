package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

//Anotacion JPA para definir la entidad
@Entity
@Table(name="Dragon")
public class Dragon {

    //Anotacion JPA para definir el id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private int intensidadFuego;
    private int resistencia;

    //Relacion JPA con bosque
    @OneToOne
    private Bosque bosque;

    //Constructor vacio para JPA
    public Dragon(){}
    
    /**
     * Constructor Dragon para crear
     * @param nombre
     * @param intensidadFuego
     * @param resistencia
     */
    public Dragon(String nombre, int intensidadFuego, int resistencia) {
        this.nombre = nombre;
        this.intensidadFuego = intensidadFuego;
        this.resistencia = resistencia;
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIntensidadFuego() {
        return intensidadFuego;
    }

    public void setIntensidadFuego(int intensidadFuego) {
        this.intensidadFuego = intensidadFuego;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    /**
     * Metodo que recibe un monstruo por parametro
     * A la vida del monstruo se le resta el daño del dragon
     * @param monstruo
     */
    public void exhalar(Monstruo monstruo){
        monstruo.setVida(monstruo.getVida()-getIntensidadFuego());
    }
}
