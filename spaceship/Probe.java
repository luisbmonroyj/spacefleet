package spaceship;

public class Probe extends SpaceShip{
    //a probe is a non tripulated spacecraft
    //stops engines
    public void stop(){} 
    //probes don't couple with other spacecrafts
    public void couple(){} 
    
    //constructors
    public Probe(){}
    public Probe (String name, double mass,double capacity,double thrust,int engines){
        setName(name);
        setMass(mass);
        setCapacity(capacity);
        setThrust(thrust);
        setEngines(engines);
    }


}
