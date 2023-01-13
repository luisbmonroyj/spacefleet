package spaceship;

public class SpaceCraft extends SpaceShip{
    //A spacecraft has tripulation
    //stops engines
    public void stop(){} 
    
    public void couple(){} 
    
    //constructors
    public SpaceCraft(){}
    public SpaceCraft (double mass,double capacity,double thrust,int engines){
        setMass(mass);
        setCapacity(capacity);
        setThrust(thrust);
        setEngines(engines);
    }


}
