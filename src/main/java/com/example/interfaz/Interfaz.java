package com.example.interfaz;

import java.util.Scanner;

import com.example.model.Bosque;
import com.example.model.Dragon;
import com.example.model.Mago;
import com.example.model.Monstruo;

public class Interfaz {
    private Scanner sc = new Scanner(System.in);

    public Mago crearMago() {
        System.out.print("Nombre del mago: ");
        String nombre = sc.nextLine();
        System.out.print("Vida del mago: ");
        int vida = sc.nextInt();
        sc.nextLine();
        System.out.print("Nivel de magia del mago: ");
        int magia = sc.nextInt();
        sc.nextLine();

        return new Mago(nombre, vida, magia);
    }

    public Monstruo crearMonstruo() {
        System.out.print("Nombre del monstruo: ");
        String nombre = sc.nextLine();

        System.out.print("Vida del monstruo: ");
        int vida = sc.nextInt();
        sc.nextLine();

        System.out.print("Fuerza del monstruo: ");
        int fuerza = sc.nextInt();
        sc.nextLine();

        System.out.println("Tipo del monstruo (ogro, troll o espectro): ");
        String tipoStr = sc.nextLine().toUpperCase();

        // Conversión al enum que está dentro de Monstruo
        Monstruo.tipoMonstruo tipo = Monstruo.tipoMonstruo.valueOf(tipoStr);

        return new Monstruo(nombre, vida, fuerza, tipo);
    }

    public Bosque crearBosque() {
        System.out.print("Nombre del bosque: ");
        String nombre = sc.nextLine();

        System.out.print("Nivel de peligro: ");
        int nivel = sc.nextInt();
        sc.nextLine();

        Bosque bosque = new Bosque(nombre, nivel);

        System.out.print("¿Cuántos monstruos jefe tendrá este bosque?: ");
        int cantidad = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < cantidad; i++) {
            System.out.println("\n--- Crear monstruo jefe #" + (i + 1) + " ---");
            Monstruo m = crearMonstruo();
            bosque.getMonstruosJefe().add(m);
        }

        return bosque;
    }

    public Dragon crearDragon(){
        System.out.print("Nombre del dragon: ");
        String nombre = sc.nextLine();

        System.out.print("Intensidad del fuego: ");
        int intensidad = sc.nextInt();
        sc.nextLine();

        System.out.print("Resistencia de la vida: ");
        int resistencia = sc.nextInt();
        sc.nextLine();

        return new Dragon(nombre, intensidad, resistencia);
    }

    public Scanner getScanner() {
        return sc;
    }

}
