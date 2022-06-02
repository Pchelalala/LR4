package com.company;

public class Car implements Comparable<Car>{
    protected static int mode = 0;

    private int id;
    private String name;
    private int power;
    private int cost;
    private boolean serviceable;

    public Car() {
    }

    public Car(String name, int power, int cost, boolean serviceable){
        this.name = name;
        this.power = power;
        this.cost = cost;
        this.serviceable = serviceable;
    }

    public String getName(){
        return this.name;
    }

    public int getPower(){
        return this.power;
    }

    public int getCost(){
        return this.cost;
    }

    public static int getMode() {
        return mode;
    }

    public static void setMode(int mode) {
        Car.mode = mode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isServiceable() {
        return serviceable;
    }

    public void setServiceable(boolean serviceable) {
        this.serviceable = serviceable;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPower(int power){
        this.power = power;
    }

    public void setCost(int cost){
        this.cost = cost;
    }

    

    @Override
    public String toString(){
        return "Name: "+ this.getName()+", "+
                "Power: "+ this.getPower()+", "+
                "Cost: "+ this.getCost()+", "+
                "Is it serviceable: "+this.isServiceable();
    }

    @Override
    public int compareTo(Car anotherCar) {
        int diff;
        if(mode == 1){
            return Integer.compare(this.getName().compareTo(anotherCar.getName()), 0);
        }
        if(mode == 2){
            diff = this.cost-anotherCar.cost;
            return diff;
        }
        else if(mode == 3){
            diff = this.power-anotherCar.power;
            return diff;
        }
        else if(mode == 4){
            if(Boolean.TRUE.equals(this.isServiceable())
                    && Boolean.TRUE.equals(anotherCar.isServiceable())||
                    Boolean.FALSE.equals(this.isServiceable()) &&
                            Boolean.FALSE.equals(anotherCar.isServiceable())){
                return 0;
            }
            else if(Boolean.TRUE.equals(this.isServiceable()) && Boolean.FALSE.equals(anotherCar.isServiceable())){
                return 1;
            }
            else {
                return -1;
            }
        }
        return 0;
    }
}
