package spaceship;

public class Shuttle extends SpaceShip{
    
    //method overriding
    //stops engines
    public void stop(){} 
    public void couple(){}
    
    //constructors
    public Shuttle(){}
    public Shuttle (double mass,double capacity,double thrust,int engines){
        setMass(mass);
        setCapacity(capacity);
        setThrust(thrust);
        setEngines(engines);
    }


}
