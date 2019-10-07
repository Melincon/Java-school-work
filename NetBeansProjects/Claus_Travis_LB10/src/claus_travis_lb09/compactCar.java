/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claus_travis_lb09;

/**
 *
 * @author Travis
 */
public class compactCar extends vehicle{
    private int speed;
    
    public int getSpeed(){
        return this.speed;
    }
    public void setSpeed(int speed){
        this.speed = speed;
    }
    
    @Override
    public void accelerate(int speed){
        if(super.getIsDriveable())
        if(speed >= 2)
            this.speed += speed;
        else this.speed += 2;
        else System.out.println("This car is not drivable.");
    }
    @Override
    public void decelerate(int speed){
        if(super.getIsDriveable())
            if(this.speed <= speed)
                this.speed = 0;
            else this.speed -= speed;
        else System.out.println("This car is not driveable.");
    }
    @Override
    public String toString(){
        return String.format("%s  %s  %s%n", super.getMake(),
                super.getModel(),this.speed);
    }
    
    public compactCar(){
        this("compactMake","compactModel",true,0);
    }
    public compactCar(String make){
        this(make,"compactModel",true,0);
    }
    public compactCar(String make,String model){
        this(make,model,true,0);
    }
    public compactCar(String make,String model,boolean isDrivable){
        this(make,model,isDrivable,0);
    }
    public compactCar(String make,String model,boolean isDrivable,
            int speed){
        super(make,model,isDrivable);
        this.speed = speed;
    }
}
