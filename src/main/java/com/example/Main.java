package com.example;

import com.example.controlador.BosqueControlador;
import com.example.controlador.DragonControlador;
import com.example.controlador.HechizoControlador;
import com.example.controlador.MagoControlador;
import com.example.controlador.MonstruoControlador;
import com.example.interfaz.Interfaz;
import com.example.model.BolaFuego;
import com.example.model.BolaNieve;
import com.example.model.Bosque;
import com.example.model.Dragon;
import com.example.model.Hechizo;
import com.example.model.Mago;
import com.example.model.Monstruo;
import com.example.model.Rayo;

public class Main {

    public static void main(String[] args) {
        Interfaz interfaz = new Interfaz();
        MagoControlador magoCtrl = new MagoControlador();
        MonstruoControlador monstruoCtrl = new MonstruoControlador();
        BosqueControlador bosqueCtrl = new BosqueControlador();
        DragonControlador dragonCtrl = new DragonControlador();
        HechizoControlador hechizoCtrl = new HechizoControlador();

        // Crear mago
        Mago mago = interfaz.crearMago();
        magoCtrl.guardarMago(mago);

        //Creamos los hechizos y los guardamos
        Hechizo bolaFuego = new BolaFuego();
        Hechizo rayo = new Rayo();
        Hechizo bolaNieve = new BolaNieve();
        


        // El mago aprende los hechizos
        mago.aprenderHechizo(bolaFuego);
        mago.aprenderHechizo(rayo);

        hechizoCtrl.guardarHechizo(bolaFuego);
        hechizoCtrl.guardarHechizo(rayo);
        hechizoCtrl.guardarHechizo(bolaNieve);
        // Crear bosque
        Bosque bosque = interfaz.crearBosque();

        // Guardar cada monstruo del bosque
        for (Monstruo m : bosque.getListasMonstruos()) {
            monstruoCtrl.guardarMonstruo(m);
        }

        // Crear Dragon
        Dragon dragon = interfaz.crearDragon();
        dragonCtrl.guardarDragon(dragon);

        // Guardar el bosque completo
        bosqueCtrl.guardarBosque(bosque);

        // Seleccionar el primer monstruo para la batalla
        if (bosque.getListasMonstruos().isEmpty()) {
            System.out.println("El bosque no tiene monstruos jefe. No hay batalla.");
            return;
        }

        Monstruo monstruo = bosque.getListasMonstruos().get(0);

        System.out.println("\n¡Comienza la batalla en el bosque " + bosque.getNombre() + "!\n");

        //Simular batalla
        while (mago.getVida() > 0 && monstruo.getVida() > 0) {
            mago.lanzarHechizoMago(monstruo, rayo);
            System.out.println("El mago lanza un hechizo. Vida del monstruo: " + monstruo.getVida());

            if (monstruo.getVida() <= 0)
                break;

            monstruo.atacar(mago);
            System.out.println("El monstruo ataca. Vida del mago: " + mago.getVida());
        }

        //Resultado final
        System.out.println("\nBatalla terminada.");
        if (mago.getVida() > 0) {
            System.out.println("El mago sobrevive y domina el bosque.");
        } else {
            System.out.println("El monstruo sobrevive y domina el bosque.");
        }
    }
}
