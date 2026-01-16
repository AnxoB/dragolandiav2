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

//Anotacion JPA para definir la entidad
@Entity
@Table(name = "Bosque")
public class Bosque {

    //Definimos el id de la clase
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private int nivelPeligro;

    //Relacion 1:1 con dragon, añade la columna dragon_id a esta clase
    @OneToOne
    @JoinColumn(name = "dragon_id")
    private Dragon dragon;

    //Relación 1:1 con monstruoJefe
    @OneToOne
    private Monstruo monstruoJefe;

    //Relación 1:N con monstruos
    @OneToMany(targetEntity = Monstruo.class)
    private List<Monstruo> listaMonstruos = new ArrayList<>();

    public Bosque() {
    }

    /**
     * Constructor bosque para crear
     * @param nombre
     * @param nivelPeligro
     */
    public Bosque(String nombre, int nivelPeligro) {
        this.nombre = nombre;
        this.nivelPeligro = nivelPeligro;
        this.listaMonstruos = new ArrayList<>();
    }
               
    //Getters y Setters
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

    //Método para mostrar los monstruos
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

    /**
     * Metodo para añadir el monstruo
     * @param monstruo
     */
    public void añadirMonstruo(Monstruo monstruo) {
        listaMonstruos.add(monstruo);
    }

    /**
     * Metodo para eliminar el monstruo
     * @param monstruo
     */
    public void eliminarMonstruo(Monstruo monstruo) {
        listaMonstruos.remove(monstruo);
    }

    @Override
    public String toString() {
        return "Bosque [id=" + id + ", nombre=" + nombre + ", nivelPeligro=" + nivelPeligro + ", monstruoJefe="
                + listaMonstruos + "]";
    }
}
