//package naveespacial;
import java.io.Console;
import oraclewithjava.*;
/*
import spaceship.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
*/

public class Inventory {
    static Console console = System.console();
    static DBController controller = new DBController(false);
                
    public static void main(String[] args) {
        //Console console = System.console();
        
        /*
        Connection conn3 = null;
        try{
            Properties parameters = new Properties();
            parameters.put("user", oraclewithjava.Properties.DATABASE_USER);
            parameters.put("password", oraclewithjava.Properties.DATABASE_PASSWORD);
 
            //conn3 = DriverManager.getConnection(dbURL3, parameters);
            conn3 = DriverManager.getConnection(oraclewithjava.Properties.DATABASE_URL, parameters);
            if (conn3 != null) {
                System.out.println("Connected to database #3");
            }
 
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        } 
        */      
        
        /* 
        Shuttle saturnoV = new Shuttle();
        saturnoV.setCapacity(118000.0);
        saturnoV.setEngines(2);
        saturnoV.setThrust(3500000.0);
        saturnoV.setMass(2900000);
        String shuttleCSV = "'saturnoV',"+saturnoV.getCapacity()+","+saturnoV.getEngines()+","+saturnoV.getThrust()+","+saturnoV.getMass();
        System.out.println(shuttleCSV);        

        controller.insertValues("spacefleet.shuttle", "shuttle_name,capacity,engines,thrust,mass", shuttleCSV);
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
        */
        char option = 'A';
        while (option != 'X'){
            System.out.println("Enter a number according to your option:");
            System.out.println("1. Create a spaceship");    
            System.out.println("2. Consult a spaceship");    
            System.out.println("3. Find a spaceship");    
            System.out.println("X. Exit");    
            System.out.println("Please choose");
            option = console.readLine().toUpperCase().charAt(0);
            switch (option){
                case '1':
                    createShip();
                    break;
                case '2':
                    consultShip();
                    break;
                case '3':
                    findShip();
                    break;
                default:
                    break;
            }
        }
        
    }
    public static void createShip(){
        char create = 'A';
        while (create != 'X'){
            System.out.println("Enter a number according to your option:");
            System.out.println("1. Create a shuttle");    
            System.out.println("2. Create a Probe");    
            System.out.println("3. Create a tripulated spacecraft");    
            System.out.println("4. Create a satellite");    
            System.out.println("X. Return to previous menu");    
            System.out.println("Please choose");
            create = console.readLine().toUpperCase().charAt(0);
            switch (create){
                case '1':
                    create("spacefleet.shuttle", "shuttle_name,mass,capacity,engines,thrust");
                    break;
                case '2':
                    create("spacefleet.probe","probe_name,mass,capacity,engines,thrust");
                    break;
                case '3':
                    create("spacefleet.spacecraft","spacecraft_name,mass,capacity,engines,thrust");
                    break;
                case '4':
                    create("spacefleet.satellite","satellite_name,mass");
                    break;
                default:
                    break;
            }
        }
    }
    public static void create(String table, String columns){
        controller.conectar();
        //String columns = "shuttle_name,mass,capacity,engines,thrust";
        String[] inputs = columns.split(",");
        String values = "'";
        for (int i =0 ;i<inputs.length;i++){
            System.out.println("Enter "+inputs[i]+": ");
            values+=console.readLine();
            if (i == 0){
                values+="',";
            }
            else if (i != inputs.length-1){
                values+=",";
            }
        }
        /*
        Shuttle transbordador = new Shuttle();
        transbordador.setCapacity(118000.0);
        transbordador.setEngines(2);
        transbordador.setThrust(3500000.0);
        transbordador.setMass(2900000);
        String shuttleCSV = "'transbordador',"+transbordador.getCapacity()+","+transbordador.getEngines()+","+transbordador.getThrust()+","+transbordador.getMass();
        System.out.println(values);        
        */
        controller.insertValues(table, columns, values);
        controller.desconectar();
        
    }
    public static void consultShip(){
        char consult = 'A';
        while (consult != 'X'){
            System.out.println("Enter a number according to your option:");
            System.out.println("1. Consult a shuttle");    
            System.out.println("2. Consult a Probe");    
            System.out.println("3. Consult a tripulated spacecraft");    
            System.out.println("4. Consult a satellite");    
            System.out.println("X. Return to previous menu");    
            System.out.println("Please choose");
            consult = console.readLine().toUpperCase().charAt(0);
            switch (consult){
                case '1':
                    consult("shuttle","shuttle_name,mass,capacity,engines,thrust");//, "shuttle_name");
                    break;
                case '2':
                    consult("probe","probe_name,mass,capacity,engines,thrust");
                    break;
                case '3':
                    consult("spacecraft","spacecraft_name,mass,capacity,engines,thrust");
                    break;
                case '4':
                    consult("satellite","satellite_name,mass");
                    break;
                default:
                    break;
            }
        }
        controller.desconectar();   
    }
    public static void consult(String table,String columns){
        //String columns = "shuttle_name,mass,capacity,engines,thrust";
        System.out.println("Enter "+ table+ " name: ");
        String name = console.readLine();
        controller.conectar();
        String[] datos = controller.getSingleRow("spacefleet."+table, columns, table+"_name", name, null);
        String[] inputs = columns.split(",");
        for (int i =0 ;i<inputs.length;i++){
            System.out.println(inputs[i]+": "+datos[i]);
        }
    }

    public static void findShip(){
        char find = 'A';
        while (find != 'X'){
            System.out.println("Enter a number according to your option:");
            System.out.println("1. find a spacecraft by mass");    
            System.out.println("2. find a spacecraft by capacity");    
            System.out.println("3. find a spacecraft by number of engines");    
            System.out.println("4. find a spacecraft by thrust");    
            System.out.println("X. Return to previous menu");    
            System.out.println("Please choose");
            find = console.readLine().toUpperCase().charAt(0);
            switch (find){
                case '1':
                    find("shuttle,probe,spacecraft,satellite","mass");//, "shuttle_name");
                    break;
                case '2':
                    find("shuttle,probe,spacecraft","capacity");
                    break;
                case '3':
                    find("shuttle,probe,spacecraft","engines");
                    break;
                case '4':
                    find("shuttle,probe,spacecraft","thrust");
                    break;
                default:
                    break;
            }
        }
        controller.desconectar();
    }
    public static void find(String tables,String parameter){
        System.out.println("Enter search value for "+parameter+": ");
        String data = console.readLine();
        String[] multiple = tables.split(",");
        //int i=0;
        controller.conectar();
        for (int i=0;i<multiple.length;i++){
            String[] results = controller.getColumnValues("spacefleet."+multiple[i],multiple[i]+"_name","spacefleet."+multiple[i]+"."+parameter,data,null);
            for (int j=0;j<results.length;j++){
                System.out.println("("+multiple[i]+") "+results[j]);    
            }
        }
        controller.desconectar();
    }
}
