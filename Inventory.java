//package naveespacial;
import java.io.Console;
import oraclewithjava.*;
import spaceship.*;

public class Inventory {
    public static void main(String[] args) {
        Shuttle saturnoV = new Shuttle();
        saturnoV.setCapacity(118000.0);
        saturnoV.setEngines(2);
        saturnoV.setThrust(3500000.0);
        saturnoV.setMass(2900000);

        Shuttle energia = new Shuttle (2400000.0, 100000, 3060000, 3);

        Probe pioneerX = new Probe();
        pioneerX.setThrust(45.39);

        Probe marinerX = new Probe();
        marinerX.setMass(1093.0);
        marinerX.setThrust(65.79); 

        System.out.println("Capacidad SaturnoV: "+saturnoV.getCapacity()+" kg");
        System.out.println("Masa Energia: " +energia.getMass()+" kg");
        System.out.println("Empuje de PioneerX: "+pioneerX.getThrust()+" kg");
        System.out.println("masa de MarinerX: "+ marinerX.getMass()+" kg");
        //System.out.println("Introduzca una opcion");
        Console console = System.console();
        char option = 'A';
        while (option != 'X'){
            System.out.println("Escriba la opcion segun el numero:");
            System.out.println("1. Crear una nave");    
            System.out.println("2. Consultar nave");    
            System.out.println("3. Buscar nave");    
            System.out.println("X. Salir");    
            System.out.println("Introduzca una opcion");
            option = console.readLine().toUpperCase().charAt(0);
        }
    }
}
