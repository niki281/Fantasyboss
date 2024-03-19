
package com.mycompany.fantasyboss;

/**
 *
 * @author nicke
 */



import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Fantasyboss {
    
     static File ficheroJugador= new File("jugadores.obj");
    static ArrayList<Jugador> jugadores=new ArrayList<>();

    public static void main(String[] args) {
        
        
         int opcion=0;
        
        
        if (!ficheroJugador.exists()) {
            fichas.añadirJugadoresArrayInicial();
            fichas.guardarJugadores();
        }
        
        leerArchivos();
        do {
            opcion=mostrarMenu();  
            switch (opcion) {
                case 1:
                    imprimirJugadores();
                    break;
                case 2:
                    añadirJugadores();
                    break;
                case 3:
                    guardar();
                    break;
            }
        } while (opcion!=3);
    } 

    private static void leerArchivos() {
        Jugador ju;
        if (ficheroJugador != null) {
            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ficheroJugador));
                ju = (Jugador) ois.readObject();
                jugadores.add(ju);
                while (ju != null) {
                    ju = (Jugador) ois.readObject();
                    jugadores.add(ju);
                }
                ois.close();
            } catch (EOFException e1) {
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private static void imprimirJugadores() {
        for (Jugador j: jugadores) {
            j.imprimir();
        }
    }

    private static int mostrarMenu() {
        int opcion; 
        Scanner sc= new Scanner (System.in);
        System.out.println("1-. Ver jugadores");
        System.out.println("2-. Agregar jugador");
        System.out.println("3-. Salir");
        opcion=sc.nextInt();
        sc.nextLine();
        return opcion;
    }

    private static void añadirJugadores() {
        String nombre;
        int precio;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce nombre: ");
        nombre=sc.nextLine();
        System.out.println("Introduce el precio: ");
        precio=sc.nextInt();
        sc.nextLine();
        Jugador j=new Jugador(nombre,precio);
        jugadores.add(j);
    }

    private static void guardar() {
        try (FileOutputStream ff = new FileOutputStream(ficheroJugador)) {
            ObjectOutputStream oos = new ObjectOutputStream(ff);
            for (Object ju : jugadores) {
                oos.writeObject(ju);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Fantasyboss.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Fantasyboss.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
        
        
    }

