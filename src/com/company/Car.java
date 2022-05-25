package com.company;

public class Car implements Comparable<Car>{
    protected static int mode = 0;

    private String name;
    private int power;
    private int cost;
    private boolean servicable;

    public Car(String name, int power, int cost, boolean servicable){
        this.name = name;
        this.power = power;
        this.cost = cost;
        this.servicable = servicable;
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

    public boolean getServicable(){
        return this.servicable;
    }

    protected void setName(String name){
        this.name = name;
    }

    public void setPower(int power){
        this.power = power;
    }

    public void setCost(int cost){
        this.cost = cost;
    }

    public void setServicable(boolean servicable){
        this.servicable = servicable;
    }

    @Override
    public String toString(){
        return "Name: "+ this.getName()+", "+
                "Power: "+ this.getPower()+", "+
                "Cost: "+ this.getCost()+", "+
                "Is it serviceable: "+this.getServicable();
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
            if(Boolean.TRUE.equals(this.getServicable())
                    && Boolean.TRUE.equals(anotherCar.getServicable())||
                    Boolean.FALSE.equals(this.getServicable()) &&
                            Boolean.FALSE.equals(anotherCar.getServicable())){
                return 0;
            }
            else if(Boolean.TRUE.equals(this.getServicable()) && Boolean.FALSE.equals(anotherCar.getServicable())){
                return 1;
            }
            else {
                return -1;
            }
        }
        return 0;
    }
}
