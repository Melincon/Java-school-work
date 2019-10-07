/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calsswork_march;

/**
 *
 * @author Travis
 */
public abstract class vehicle {
    private String make;
    private String model;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    
    public abstract void turnOn();
    
    public vehicle(){
        this("Acura","NSX");
    }
    public vehicle(String make, String model){
        this.make = make;
        this.model = model;
    }
}
