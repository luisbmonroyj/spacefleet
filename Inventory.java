//package naveespacial;
import java.io.Console;
import oraclewithjava.*;

import spaceship.*;

public class Inventory {
    static Console console = System.console();
    static DBController controller = new DBController(false);
                
    public static void main(String[] args) {
        //main menu
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
        //menu 1. create a spaceship
        char create = 'A';
        while (create != 'X'){
            //this string has the most common names of columns/properties of the tables/class
            String columns = "name,mass,capacity,thrust,engines";
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
                    String[] values = createSpaceShip(columns);
                    //creating an object with the values the user entered in createSpaceShip
                    Shuttle shuttle = new Shuttle(values[0],Double.parseDouble(values[1]),Double.parseDouble(values[2]),Double.parseDouble(values[3]),Integer.parseInt(values[4]));
                    if (shuttle != null)//if the instance of shuttle is valid, store it in the DB
                        create("spacefleet.shuttle", columns,shuttle);
                    break;
                case '2': //the same process repeats 
                    values = createSpaceShip(columns);
                    Probe probe = new Probe(values[0],Double.parseDouble(values[1]),Double.parseDouble(values[2]),Double.parseDouble(values[3]),Integer.parseInt(values[4]));
                    if (probe != null)
                        create("spacefleet.probe",columns,probe);
                    break;
                case '3':
                    values = createSpaceShip(columns);
                    SpaceCraft craft = new SpaceCraft(values[0],Double.parseDouble(values[1]),Double.parseDouble(values[2]),Double.parseDouble(values[3]),Integer.parseInt(values[4]));
                    if (craft != null)
                        create("spacefleet.spacecraft",columns,craft);
                    break;
                case '4':
                    columns = "name,mass";//the amount of data for satellite changes, an update fo columns must be made
                    String satelliteValues[] = createSpaceShip(columns);
                    Satellite satellite = new Satellite(satelliteValues[0],Double.parseDouble(satelliteValues[1]));
                    if (satellite != null)
                        create("spacefleet.satellite",columns, satellite);
                    break;
                default:
                    break;
            }
        }
    }
    //createSpaceship takes a CSV columns, splits them, asks the user for data according to the type of spaceship
    //and returns a String[] with those data
    public static String[] createSpaceShip (String columns){
        String[] inputs = columns.split(",");
        String[] values =  new String[inputs.length];
        for (int i =0 ;i<inputs.length;i++){
            System.out.println("Enter "+inputs[i]+": ");
            values[i]=console.readLine();
        }
        return values;
    }
    public static void create(String table, String columns,SpaceShip machine){
        controller.conectar();
        String values = machine.toCSV();
        controller.insertValues(table, columns, values);//first DB method used, create a new registry
        controller.desconectar();//connects and disconnects for security reasons
    }
    public static void consultShip(){
        //In this option, the user must know the name of the spaceship to get all its information
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
                    consult("shuttle","name,mass,capacity,engines,thrust");
                    break;
                case '2':
                    consult("probe","name,mass,capacity,engines,thrust");
                    break;
                case '3':
                    consult("spacecraft","name,mass,capacity,engines,thrust");
                    break;
                case '4':
                    consult("satellite","name,mass");
                    break;
                default:
                    break;
            }
        }
        
    }
    public static void consult(String table,String columns){
        //this method queries the name of spaceship in the database, and returns all its properties
        System.out.println("Enter "+ table+ " name: ");
        String name = console.readLine();
        controller.conectar();
        //getSingleRow is used because there must be one registry, according to primary key constraints
        String[] datos = controller.getSingleRow("spacefleet."+table, columns, "name", name, null);
        String[] inputs = columns.split(",");
        if (datos[0] == null)//no data available and possible reasons
            System.out.println("No "+table+ " found. Check for correct spelling or uppercase letters");
        else 
            for (int i =0 ;i<inputs.length;i++){
                System.out.println(inputs[i]+": "+datos[i]);
            }
        controller.desconectar();   
    }

    public static void findShip(){
        //this option delivers every spaceship (shuttle, probe, spacecraft or satellite) that has a parameter equal to a value entered by user
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
                    find("shuttle,probe,spacecraft,satellite","mass");
                    break;
                case '2':
                    find("shuttle,probe,spacecraft","capacity");
                    //satellites don't have this parameter
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
        //this method finds every registry in the tables with the input parameter (satellites only have mass)
        System.out.println("Enter search value for "+parameter+": ");
        String data = console.readLine();
        String[] multiple = tables.split(",");
        controller.conectar();
        for (int i=0;i<multiple.length;i++){
            String[] results = controller.getColumnValues("spacefleet."+multiple[i],"name","spacefleet."+multiple[i]+"."+parameter,data,null);
            if (results.length  == 0) //no spaceships found
                System.out.println("No "+multiple[i]+" found with this criterium");
            else //one or more spaceships found
                System.out.println(results.length +" "+multiple[i]+ " found with this criterium:");
                for (int j=0;j<results.length;j++){
                    System.out.println("("+multiple[i]+") "+results[j]);    
                }
        }
        controller.desconectar();
    }
}
