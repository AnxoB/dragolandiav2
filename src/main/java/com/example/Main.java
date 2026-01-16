package com.example;

import java.util.ArrayList;
import java.util.List;

import com.example.controlador.BosqueControlador;
import com.example.controlador.DragonControlador;
import com.example.controlador.HechizoControlador;
import com.example.controlador.MagoControlador;
import com.example.controlador.MonstruoControlador;
import com.example.interfaz.Interfaz;
import com.example.model.Batalla;
import com.example.model.BolaFuego;
import com.example.model.BolaNieve;
import com.example.model.Bosque;
import com.example.model.Dragon;
import com.example.model.Hechizo;
import com.example.model.Mago;
import com.example.model.Monstruo;
import com.example.model.Rayo;

//Usar EntityManager para la conexion

public class Main {

    public static void main(String[] args) {
        //Crear los controladores
        Interfaz interfaz = new Interfaz();
        MagoControlador magoCtrl = new MagoControlador();
        MonstruoControlador monstruoCtrl = new MonstruoControlador();
        BosqueControlador bosqueCtrl = new BosqueControlador();
        DragonControlador dragonCtrl = new DragonControlador();
        HechizoControlador hechizoCtrl = new HechizoControlador();

        // Crear mago2
        Mago mago1 = interfaz.crearMago();
        magoCtrl.guardarMago(mago1);
        Mago mago2 = interfaz.crearMago();
        magoCtrl.guardarMago(mago2);

        //Creamos los hechizos
        Hechizo bolaFuego = new BolaFuego();
        Hechizo rayo = new Rayo();
        Hechizo bolaNieve = new BolaNieve();
        
        // El mago aprende los hechizos
        mago1.aprenderHechizo(bolaFuego);
        mago1.aprenderHechizo(rayo);

        mago2.aprenderHechizo(bolaNieve);
        mago2.aprenderHechizo(rayo);

        //Guardamos los hechizos
        hechizoCtrl.guardarHechizo(bolaFuego);
        hechizoCtrl.guardarHechizo(rayo);
        hechizoCtrl.guardarHechizo(bolaNieve);
        
        List<Mago> magos = new ArrayList<>(); // Lista de magos
        List<Hechizo> hechizosJuego = new ArrayList<>(); // Lista de conjuros
    
        //Añadimos los magos creados a la lista de magos
        magos.add(mago1);
        magos.add(mago2);

        //Añadismos los hechizo creados a la lista de hechizos
        hechizosJuego.add(bolaFuego);
        hechizosJuego.add(rayo);
        hechizosJuego.add(bolaNieve);

        // Crear bosque y monstruos
        Bosque bosque = interfaz.crearBosque();

        //Guardamos el bosque
        bosqueCtrl.guardarBosque(bosque);


        //Crear monstruos y guardarlos
        Monstruo monstruo1 = interfaz.crearMonstruo();
        bosque.añadirMonstruo(monstruo1);
        monstruoCtrl.guardarMonstruo(monstruo1);
        Monstruo monstruo2 = interfaz.crearMonstruo();
        bosque.añadirMonstruo(monstruo2);
        monstruoCtrl.guardarMonstruo(monstruo2);
        Monstruo monstruo3 = interfaz.crearMonstruo();
        bosque.añadirMonstruo(monstruo3);
        monstruoCtrl.guardarMonstruo(monstruo3);

        List<Monstruo> monstruos = bosque.getListasMonstruos();
        Monstruo jefeMonstruo = monstruos.get(0); // Asignar el primer monstruo como jefe

        // Crear dragón
        Dragon dragon = interfaz.crearDragon();
        dragonCtrl.guardarDragon(dragon);

        //Actualizamos el bosque
        bosqueCtrl.actualizarBosque(bosque);

        // Iniciar la batalla
        Batalla batalla = new Batalla(magos, monstruos, dragon, jefeMonstruo);
        batalla.iniciarBatalla(bosque.getNombre(), hechizosJuego);
    }
}
