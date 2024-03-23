/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fantasyboss;

import java.io.*;
import java.util.List;

public class ArchivoManager {
    public static void guardarJugadores(String rutaArchivo, List<Jugador> jugadores) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            out.writeObject(jugadores);
            System.out.println("Datos guardados en el archivo: " + rutaArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar los datos en el archivo: " + e.getMessage());
        }
    }

    public static List<Jugador> cargarJugadores(String rutaArchivo) {
        List<Jugador> jugadores = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
            jugadores = (List<Jugador>) in.readObject();
            System.out.println("Datos cargados desde el archivo: " + rutaArchivo);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los datos desde el archivo: " + e.getMessage());
        }
        return jugadores;
    }
}