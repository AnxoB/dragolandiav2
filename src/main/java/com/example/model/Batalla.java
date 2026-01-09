package com.example.model;

import com.example.controlador.BosqueControlador;
import com.example.controlador.DragonControlador;
import com.example.controlador.HechizoControlador;
import com.example.controlador.MagoControlador;
import com.example.controlador.MonstruoControlador;
import com.example.interfaz.Interfaz;

import java.util.Iterator;
import java.util.List;

public class Batalla {

    /*Tengo dudas de donde colocar esta clase (creo que la tengo mal en modelo) 
    y también mezclo lógica con salida por lo que habría que dividirla en la vista esa
    parte, pero lo agrupé en una sola porque necesito echarle mas tiempo a realizarla
    de la forma correcta
    */

    private List<Mago> magos;
    private List<Monstruo> monstruos;
    private Dragon dragon;
    private Monstruo jefeMonstruo;

    /**
     * Constructor de Batalla
     * @param magos
     * @param monstruos
     * @param dragon
     * @param jefeMonstruo
     */
    public Batalla(List<Mago> magos, List<Monstruo> monstruos, Dragon dragon, Monstruo jefeMonstruo) {
        this.magos = magos;
        this.monstruos = monstruos;
        this.dragon = dragon;
        this.jefeMonstruo = jefeMonstruo;
    }

    public void iniciarBatalla(String nombreBosque, List<Hechizo> hechizosJuego) {
        System.out.println("\n--- El juego comienza en el bosque " + nombreBosque + " ---\n");

        //Mientras la lista de monstruos\magos no estean vacias
        while (!monstruos.isEmpty() && !magos.isEmpty()) {
            System.out.println("Nueva ronda de batalla...");

            // Magos lanzan conjuros
            for (Mago mago : magos) {
                if (mago.getVida() <= 0) continue; // Saltar magos eliminados

                for (Hechizo hechizo : hechizosJuego) {
                    if (mago.conoceHechizo(hechizo)) {
                        // Actualizar monstruos si el conjuro es conocido
                        for (Iterator<Monstruo> it = monstruos.iterator(); it.hasNext();) {
                            Monstruo monstruo = it.next();
                            mago.lanzarHechizoMago(monstruo, hechizo);
                            if (monstruo.getVida() <= 0) {
                                System.out.println(monstruo.getNombre() + " eliminado.");
                                it.remove(); // Eliminar monstruos que mueran
                            }
                        }
                    } else {
                        // Reducir vida del mago si el hechizo no es conocido
                        mago.setVida(mago.getVida()-1);;
                        System.out.println(mago.getNombre() + " pierde 1 punto de vida por no conocer el hechizo.");
                    }
                }
                mostrarEstado(nombreBosque);
            }

            // Cada monstruo ataca a un mago
            for (Monstruo monstruo : monstruos) {
                if (magos.isEmpty()) break;

                Mago objetivo = magos.get(0); // Elegir el primer mago como objetivo
                monstruo.atacar(objetivo);
                System.out.println(monstruo.getNombre() + " ataca a " + objetivo.getNombre() + ".");
                if (objetivo.getVida() <= 0) {
                    System.out.println(objetivo.getNombre() + " eliminado.");
                    magos.remove(objetivo); // Eliminar magos que mueran
                }
                mostrarEstado(nombreBosque);
            }

            // Dragón ataca al monstruo jefe
            if (jefeMonstruo != null) {
                dragon.exhalar(jefeMonstruo);
                System.out.println(dragon.getNombre() + " ataca al jefe del bosque, " + jefeMonstruo.getNombre() + ".");
                if (jefeMonstruo.getVida() <= 0) {
                    System.out.println(jefeMonstruo.getNombre() + " ha sido derrotado. Asignando nuevo jefe...");
                    if (!monstruos.isEmpty()) {
                        jefeMonstruo = monstruos.get(0); // Asignar nuevo jefe
                        System.out.println("El nuevo jefe del bosque es " + jefeMonstruo.getNombre() + ".");
                    } else {
                        jefeMonstruo = null;
                        System.out.println("No hay más monstruos en el bosque.");
                    }
                }
            }

            // Mostrar el estado final después de la ronda
            mostrarEstado(nombreBosque);


            //Aqui imprimos mensaje para el final de la batalla
            System.out.println("\n--- La batalla ha terminado ---");
            if (monstruos.isEmpty()) {
                System.out.println("No quedan monstruos en el bosque. ¡Los magos ganan!");
            } else if (magos.isEmpty()) {
                System.out.println("No quedan magos. ¡Los monstruos dominan el bosque!");
            }
        }

    }

    //Funcion reutilizable para ir mostrando el estado de la batalla
    private void mostrarEstado(String nombreBosque) {
        System.out.println("\n--- Estado al final de la ronda ---");
        System.out.println("Bosque: " + nombreBosque);
        System.out.println("Jefe del bosque: " + (jefeMonstruo != null ? jefeMonstruo.getNombre() : "Ninguno"));
        System.out.println("\nMagos:");
        for (Mago mago : magos) {
            System.out.println("- " + mago.getNombre() + ": Vida = " + mago.getVida());
        }
        System.out.println("\nMonstruos:");
        for (Monstruo monstruo : monstruos) {
            System.out.println("- " + monstruo.getNombre() + ": Vida = " + monstruo.getVida());
        }
        System.out.println("\nDragón:");
        System.out.println("- " + dragon.getNombre() + ": Vida = " + dragon.getResistencia());
        System.out.println("\n--- Fin del estado ---\n");
    }
}
