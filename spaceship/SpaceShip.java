package spaceship;

public abstract class SpaceShip implements Movement{
    //properties variables
    double masa;
    double capacidad;
    double empuje;
    int motores;

    //position variables
    //in km
    double xLocation;
    double yLocation;
    double zLocation;
    //in radians
    double xRotation;
    double yRotation;
    double zRotation;

    //setters
    //mass must be in kilograms
    public void setMass (double mass){
        masa = mass;
    }
    //capacity must be in kilograms
    public void setCapacity (double capacity){
        capacidad = capacity;
    }
    //thrust must be in kilograms
    public void setThrust (double thrust){
        empuje = thrust;
    }
    //engines must be integer
    public void setEngines (int engines){
        motores = engines;
    }
    //getters
    public double getMass (){
        return masa;
    }
    public double getCapacity (){
        return capacidad;
    }
    public double getThrust (){
        return empuje;
    }
    public int getEngines (){
        return motores;
    }
    
    //marks the relative movement in X,Y,Z coordinates, in km
    public void move(double x, double y, double z){    
        xLocation += x;
        yLocation += y;
        zLocation += z;
    }
    //rotates n radians along X, Y or Z axis
    public void rotate(double twist, char axis){
            switch (axis){
            case 'X':
                xRotation+=twist;
                break;
            case 'Y':
                yRotation+=twist;
                break;
            case 'Z':
                zRotation+=twist;
                break;
        }
    }

    /*
    abstract public void setMass (double masa);
    //masa must be in kilograms
    abstract public void setCapacity (double capacidad);
    //capacidad must be in kilograms
    abstract public void setThrust (double empuje);
    //empuje must be in kilograms
    abstract public void setEngines (int motores);
    //motores must be integer
    abstract double getMass ();
    abstract double getCapacity ();
    abstract double getThrust ();
    abstract int getEngines ();
    */
}