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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Bosque")
public class Bosque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private int nivelPeligro;

    @OneToOne
    private Monstruo monstruoJefe;

    @OneToMany(targetEntity = Monstruo.class)
    private List<Monstruo> listaMonstruos = new ArrayList<>();

    public Bosque() {
    }

    public Bosque(String nombre, int nivelPeligro) {
        this.nombre = nombre;
        this.nivelPeligro = nivelPeligro;
        this.listaMonstruos = new ArrayList<>();
    }
                        
    public Monstruo getMonstruoJefe() {
        return monstruoJefe;
    }

    public void setMonstruoJefe(Monstruo monstruoJefe) {
        this.monstruoJefe = monstruoJefe;
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

    public List<Monstruo> getListasMonstruos() {
        return listaMonstruos;
    }

    public void setMonstruoJefe(List<Monstruo> listaMonstruos) {
        this.listaMonstruos = listaMonstruos;
    }

    public void mostrarMonstruo() {
        if (listaMonstruos == null || listaMonstruos.isEmpty()) {
            System.out.println("Este bosque no tiene ningún monstruo.");
            return;
        }

        System.out.println("Monstruos del bosque " + nombre + ":");
        for (Monstruo m : listaMonstruos) {
            System.out.println("- " + m);
        }
    }

    public void añadirMonstruo(Monstruo monstruo) {
        listaMonstruos.add(monstruo);
    }

    public void eliminarMonstruo(Monstruo monstruo) {
        listaMonstruos.remove(monstruo);
    }

    @Override
    public String toString() {
        return "Bosque [id=" + id + ", nombre=" + nombre + ", nivelPeligro=" + nivelPeligro + ", monstruoJefe="
                + listaMonstruos + "]";
    }
}
