package spaceship;

public class Shuttle extends SpaceShip{
    public String csv = "";
    //stops engines
    public void stop(){} 

    public void couple(){}
    
    //constructors
    public Shuttle(){}
    public Shuttle (String name, double mass,double capacity,double thrust,int engines){
        setName(name);
        setMass(mass);
        setCapacity(capacity);
        setThrust(thrust);
        setEngines(engines);
    }

}
