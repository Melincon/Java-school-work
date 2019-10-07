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
public class sportCar extends vehicle implements interfacex {
    private int speed;
    @Override
    public void turnOn(){
        
    }
    @Override
    public void accelerate(int speed){
        if(speed > 0)
        this.speed += speed;
        else this.speed++;
        //throw new UnsupportedOperationException("");
    }
    @Override
    public void decelerate(int speed){
        if(speed > 0)
            this.speed -= speed;
        else this.speed--;
        //throw new UnsupportedOperationException("");
    }
    public sportCar(){
        this("Benz","190E");
    }
    public sportCar(String make,String model){
        super(make,model);
        this.speed = 0;
    }
}
