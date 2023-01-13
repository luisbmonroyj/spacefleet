package spaceship;

public class Satellite extends SpaceShip{
    //a Satellite is a non tripulated spacecraft
    //Satellites don't have engines
    public void stop(){} 
    
    public void couple(){} 
    
    //constructors
    public Satellite(){}
    public Satellite (double mass,double capacity,double thrust){
        setMass(mass);
        setCapacity(capacity);
        setThrust(thrust);
        setEngines(0);
    }


}
