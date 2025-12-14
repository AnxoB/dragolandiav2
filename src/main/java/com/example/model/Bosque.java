package com.example.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Bosque")
public class Bosque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private int nivelPeligro;

    @OneToMany(targetEntity = Monstruo.class)
    private List<Monstruo> monstruosJefe = new ArrayList<>();

    public Bosque() {
    }

    public Bosque(String nombre, int nivelPeligro) {
        this.nombre = nombre;
        this.nivelPeligro = nivelPeligro;
        this.monstruosJefe = new ArrayList<>();
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

    public int getNivelPeligro() {
        return nivelPeligro;
    }

    public void setNivelPeligro(int nivelPeligro) {
        this.nivelPeligro = nivelPeligro;
    }

    public List<Monstruo> getMonstruosJefe() {
        return monstruosJefe;
    }

    public void setMonstruoJefe(List<Monstruo> monstruosJefe) {
        this.monstruosJefe = monstruosJefe;
    }

    public void mostrarJefe() {
        if (monstruosJefe == null || monstruosJefe.isEmpty()) {
            System.out.println("Este bosque no tiene monstruos jefe.");
            return;
        }

        System.out.println("Monstruos jefe del bosque " + nombre + ":");
        for (Monstruo m : monstruosJefe) {
            System.out.println("- " + m);
        }
    }

    public void añadirJefe(Monstruo monstruo) {
        monstruosJefe.add(monstruo);
    }

    public void eliminarJefe(Monstruo monstruo) {
        monstruosJefe.remove(monstruo);
    }

    @Override
    public String toString() {
        return "Bosque [id=" + id + ", nombre=" + nombre + ", nivelPeligro=" + nivelPeligro + ", monstruoJefe="
                + monstruosJefe + "]";
    }
}
