/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fantasyboss;

import java.util.ArrayList;
import java.util.List;

public class MercadoFichajes {
    public List<Jugador> jugadoresDisponibles;
    public int presupuesto;

    public MercadoFichajes() {
        this.jugadoresDisponibles = new ArrayList<>();
        this.presupuesto = 40_000_000; // Presupuesto inicial
    }

    public void rellenarDatos() {
    jugadoresDisponibles.add(new Jugador("Shohei Ohtani", "P", 8000000));
    jugadoresDisponibles.add(new Jugador("Ronald Acuña", "RF", 4000000));
    jugadoresDisponibles.add(new Jugador("José Altuve", "2B", 3000000));
    jugadoresDisponibles.add(new Jugador("Alex Bregman", "3B", 5000000));
    jugadoresDisponibles.add(new Jugador("Bryce Harper", "RF", 7000000));
    jugadoresDisponibles.add(new Jugador("Yordan Álvarez", "LF", 7000000));
    jugadoresDisponibles.add(new Jugador("Pablo Sandoval", "3B", 4000000));
    jugadoresDisponibles.add(new Jugador("Bryan Abreu", "LR", 2000000));
    jugadoresDisponibles.add(new Jugador("José Alvarado", "P", 3000000));
    jugadoresDisponibles.add(new Jugador("Nick Castellanos", "RF", 2000000));
    jugadoresDisponibles.add(new Jugador("Jean Segura", "2B", 7000000));
    jugadoresDisponibles.add(new Jugador("Ranger Suárez", "LF", 2000000));
    jugadoresDisponibles.add(new Jugador("Héctor Neris", "Relevista", 8000000));
    jugadoresDisponibles.add(new Jugador("Hunter Brown", "Relevista", 7000000));
    jugadoresDisponibles.add(new Jugador("Yuli Gurriell", "1B", 6000000));
    
}

    public void imprimirFichajes() {
        for (int i = 0; i < jugadoresDisponibles.size(); i++) {
            Jugador jugador = jugadoresDisponibles.get(i);
            System.out.println((i + 1) + " - " + jugador.getPosicion() + " - " +
                    jugador.getNombre() + " : " + jugador.getPrecio());
        }
        System.out.println("Presupuesto restante: " + presupuesto);
    }

    public void ficharJugador(int indice) {
        if (indice >= 0 && indice < jugadoresDisponibles.size()) {
            Jugador jugadorFichado = jugadoresDisponibles.remove(indice);
            int precioJugador = jugadorFichado.getPrecio();
            if (precioJugador <= presupuesto) {
                presupuesto -= precioJugador;
                System.out.println("Has fichado a " + jugadorFichado.getNombre() + " por " + precioJugador + " millones.");
            } else {
                System.out.println("No tienes suficiente presupuesto para fichar a este jugador.");
            }
        } else {
            System.out.println("Índice de jugador no válido.");
        }
    }

    public void imprimirPorPosicion(String posicion) {
        System.out.println(posicion + " DISPONIBLES:");
        for (int i = 0; i < jugadoresDisponibles.size(); i++) {
            Jugador jugador = jugadoresDisponibles.get(i);
            if (jugador.getPosicion().equals(posicion)) {
                System.out.println((i + 1) + " - " + jugador.getNombre() + " : " + jugador.getPrecio());
            }
        }
    }
}