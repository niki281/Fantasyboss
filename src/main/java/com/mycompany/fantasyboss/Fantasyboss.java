
package com.mycompany.fantasyboss;

import java.util.Scanner;

public class Fantasyboss {

    public static void main(String[] args) {
        MercadoFichajes mercado = new MercadoFichajes();
        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenido al mercado de fichajes de la MLB");
        System.out.println("¿Cómo quieres que te llame?");
        String nom = sc.nextLine();
        System.out.println("Perfecto " + nom + ", Empecemos");

        mercado.rellenarDatos();

        boolean mlb = true;
        while (mlb) {
            System.out.println(nom + ", ¿Qué quieres hacer?");
            System.out.println("1-. Mostrar a los jugadores");
            System.out.println("2-. Fichar a jugador");
            System.out.println("3-. Ver jugadores por posición");
            System.out.println("s-. Salir");
            String leido = sc.nextLine();
            switch (leido) {
                case "1":
                    mercado.imprimirFichajes();
                    break;
                case "2":
                    mercado.imprimirFichajes();
                    System.out.println("Introduce el número del jugador a fichar: ");
                    int nleido = sc.nextInt();
                    sc.nextLine();
                    mercado.ficharJugador(nleido - 1);
                    break;
                case "3":
                    System.out.println("Introduce la posición que quieres ver: ");
                    String dispo = sc.nextLine();
                    mercado.imprimirPorPosicion(dispo);
                    break;
                case "s":
                    mlb = false;
                    break;
                default:
                    System.out.println("Entrada no válida. Inténtalo de nuevo.");
                    break;
            }
        }
    }
}
