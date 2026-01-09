package com.example.interfaz;

import java.util.Scanner;

import com.example.model.Bosque;
import com.example.model.Dragon;
import com.example.model.Mago;
import com.example.model.Monstruo;

public class Interfaz {
    //Inicializamos el scanner
    private Scanner sc = new Scanner(System.in);

    //Funcion para crear el mago, introduciendo el nombre, vida y nivel magia por teclado
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
    //Funcion para crear el monstruo, introduciendo nombre, vida y fuerza por teclado
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

    //Funcion para crear bosque introduciendo nombre y peligro por teclado
    public Bosque crearBosque() {
        System.out.print("Nombre del bosque: ");
        String nombre = sc.nextLine();

        System.out.print("Nivel de peligro: ");
        int nivel = sc.nextInt();
        sc.nextLine();

        Bosque bosque = new Bosque(nombre, nivel);

        return bosque;
    }

    //Funcion crear Dragon introduciendo nombre, intensidad y resistencia por teclado
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

    //Esto permite no tener que andar inicializando scanner en otros sitios
    public Scanner getScanner() {
        return sc;
    }
}
