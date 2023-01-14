package spaceship;

public class Satellite extends SpaceShip{
    //a Satellite is a non tripulated spacecraft
    //Satellites don't have engines
    public void stop(){} 
    
    public void couple(){} 
    
    //constructors
    public Satellite(){}
    public Satellite (String name,double mass){//,double capacity,double thrust){
        setName(name);
        setMass(mass);
        //setCapacity(capacity);
        //setThrust(thrust);
        //setEngines(0);
    }
    @overriding
    public String toCSV() {
        String csv = "'"+this.getName()+"',"+this.getMass();
        return csv;
    }


}
