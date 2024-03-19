
package com.mycompany.fantasyboss;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nicke
 */
public class fichas {
    
    static File ficheroJugador = new File("jugadores.obj");
    static ArrayList<Jugador> jugadores=new ArrayList<>();
    
    static void añadirJugadoresArrayInicial() {
        String[] nombres = {"Shohei Ohtani", "Ronald Acuña", "José Altuve", "Alex Bregman", 
            "Bryce Harper", "Lewandowski", "Pablo sandoval", "Yordan Álvarez", "Juan Soto", "Ranger "
            , "Suárez", "Jean Segura", "Nick Castellanos", "Bryan Abreu", "Ranger Suárez", 
            "Héctor Neris", "Hunter Brown", "Blake Taylor", "David Robertson", "Martín Maldonado", 
            "Fernando Tatís Jr"};
        
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            int precio = 10 + random.nextInt(400); 
            jugadores.add(new Jugador(nombres[i], precio));
        }
    }
    
    static void guardarJugadores() {
    try (FileOutputStream ff = new FileOutputStream(ficheroJugador, true)) {
        ObjectOutputStream oos= new ObjectOutputStream(ff);
        for (Object jug : jugadores) {
            oos.writeObject(jug); 
        }
    } catch (FileNotFoundException ex) {
        Logger.getLogger(Fantasyboss.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(Fantasyboss.class.getName()).log(Level.SEVERE, null, ex);
    }
    }}
