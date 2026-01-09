package com.example.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Mago")
public class Mago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private int vida;
    private int nivelMagia;

    @OneToMany(mappedBy = "mago", cascade = CascadeType.ALL)
    private List<Hechizo> hechizos = new ArrayList<>();

    public Mago() {
    }

    public Mago(String nombre, int vida, int nivelMagia) {
        this.nombre = nombre;
        this.vida = vida;
        this.nivelMagia = nivelMagia;
        this.hechizos = new ArrayList<>();
    }

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

    public int getNivelMagia() {
        return nivelMagia;
    }

    public void setNivelMagia(int nivelMagia) {
        if (nivelMagia < 0) {
            this.nivelMagia = 0;
        } else {
            this.nivelMagia = nivelMagia;
        }
    }

    public void lanzarHechizo(Monstruo monstruo) {
        monstruo.setVida(monstruo.getVida() - getNivelMagia());
    }

    public void lanzarHechizoMago(Monstruo monstruo, Hechizo hechizo) {
        if (hechizos.contains(hechizo)) {
            hechizo.aplicar(monstruo);
        } else {
            setVida(getVida() - 1);
        }
    }

    public boolean conoceHechizo(Hechizo hechizo){
        boolean contiene = false;
        if (hechizos.contains(hechizo)) {
            contiene=true;
        }
        return contiene;
    }

    public void aprenderHechizo(Hechizo hechizo) {
        hechizos.add(hechizo);
        hechizo.setMago(this);
    }

    @Override
    public String toString() {
        return "Mago [id=" + id + ", nombre=" + nombre + ", vida=" + vida + ", nivelMagia=" + nivelMagia + "]";
    }

}
