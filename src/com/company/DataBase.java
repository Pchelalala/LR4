package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import static com.company.LambdaDemo.FilterShips;

public class DataBase{
    private int indexOfCar = 0;
    protected static int modeD = 0;
    protected Map<LocalDate,String> allHistory = new HashMap<LocalDate,String>();

    private List<Car> baseOfCars;
    public List<Car> getBaseOfCars() {
        return baseOfCars;
    }
    public DataBase(){
        var cars = Arrays.asList(
                new Car("Mustang",150,100000,true),
                new Car("Toyota Supra",180,150000,true),
                new Car("BMW X5",140,120000,false),
                new Car("Porsche",190,1200000,true),
                new Car("Lexus", 160,4000000,true)
        );
        this.baseOfCars = new ArrayList<>(cars);

    }
    public void setBaseOfCars(List<Car> baseOfCars) {
        this.baseOfCars = baseOfCars;
    }

    public List<User> getBaseOfUsers() {
        return baseOfUsers;
    }

    public void setBaseOfUsers(List<User> baseOfUsers) {
        this.baseOfUsers = baseOfUsers;
    }

    protected List<User> baseOfUsers = new ArrayList<>();

    public void getListOfCars(){
        for(int i = 1; i<baseOfCars.size()+1;i++){
            System.out.print(i);
            System.out.println(") " + baseOfCars.get(i-1));
        }
        System.out.println();
    }

    public void EditInfo(){
        Scanner in = new Scanner(System.in);
        this.getListOfCars();
        System.out.print("Which car do you want edit? ");
        indexOfCar = in.nextInt();
        System.out.println();
        this.EditCarInfo(baseOfCars.get(indexOfCar-1));
    }

    private boolean EditCarInfo(Car c){
        Scanner in = new Scanner(System.in);

        System.out.print("What you want to modify?\n" +
                "1 - name\n" +
                "2 - power\n" +
                "3 - cost\n" +
                "4 - serviceable\n" +
                "5 - come back to menu" +
                "Please enter a number:");

        int operation = in.nextInt();

        switch (operation) {
            case 1 -> {
                System.out.print("Enter new name:");
                String newName = in.next();
                c.setName(newName);
            }
            case 2 -> {
                System.out.print("Enter new power:");
                int newPower = in.nextInt();
                c.setPower(newPower);
            }
            case 3 -> {
                System.out.print("Enter new cost:");
                int newCost = in.nextInt();
                c.setPower(newCost);
            }
            case 4 -> {
                System.out.print("Enter new serviceable:");
                boolean newService = in.nextBoolean();
                c.setServicable(newService);
            }
            case 5 -> {
                return true;
            }
            default -> {
                System.out.print("Wrong number, try again");
                this.EditCarInfo(baseOfCars.get(indexOfCar - 1));
            }
        }
       return true;
    }

    public boolean SortBy(){
        System.out.print("Choose mode for sorting:\n" +
                "1 - by name\n" +
                "2 - by power\n" +
                "3 - by cost\n" +
                "4 - by serviceable\n" +
                "5 - come back to menu\n" +
                "Enter a number:");
        Scanner in = new Scanner(System.in);

        modeD = in.nextInt();
        Car.mode = modeD;

        baseOfCars.sort(Comparator.comparing(Car::getName));

        for (Car c : baseOfCars) {
            System.out.println(c);
        }

        System.out.print("What next?\n" +
                "1 - sort by another parameter\n" +
                "2 - come back to main menu\n" +
                "Please enter a number:");

        int continueOper = in.nextInt();

        switch (continueOper) {
            case 1 -> this.SortBy();
            case 2 -> {
                return true;
            }
            default -> {
                System.out.print("Wrong number, try again");
                this.SortBy();
            }
        }
        return true;
    }

    protected boolean SearchingBy(){
        System.out.print("Choose mode for searching:\n" +
                "1 - by name\n" +
                "2 - by power\n" +
                "3 - by cost\n" +
                "4 - by serviceable\n" +
                "5 - come back to menu Authorization\n" +
                "Enter a number:");
        Scanner in = new Scanner(System.in);
        int param = in.nextInt();
        if (param == 5){
            return true;
        }
        else if(param>5 || param<1){
            System.out.println("Wrong password or name. Try again");
            return false;
        }
        System.out.println("Enter your value for search:");
        Object o = in.next();
        SearchByParam(param,o);
        return true;
    }

    protected void SearchByParam(int param, Object o){
        if (param == 1){
            for (Car c : baseOfCars){
                if(((String) o).compareTo(c.getName())==0)
                    System.out.println(c);
            }
        }
        if (param == 2){
            for (Car c : baseOfCars){
                if(Integer.parseInt((String)o)==c.getPower())
                    System.out.println(c);
            }
        }
        if (param == 3){
            for (Car c : baseOfCars){
                if(Integer.parseInt((String)o)==c.getCost())
                    System.out.println(c);
            }
        }
        if (param == 4){
            for (Car c : baseOfCars){
                if(Boolean.parseBoolean((String)o) == c.getServicable())
                    System.out.println(c);
            }
        }
        SearchingBy();
    }

    protected void Filtering(){
        System.out.println("What do you want filter?\n" +
                "1 - name\n" +
                "2 - power\n" +
                "3 - cost");
        Scanner in = new Scanner(System.in);
        int fmode = in.nextInt();
        if(fmode == 2 || fmode == 3) {
            System.out.print("Enter minvalue:");
            int minValue = in.nextInt();

            System.out.print("Enter maxvalue:");
            int maxValue = in.nextInt();

            if (fmode == 2){
                FilterShips(baseOfCars, (Car car) -> car.getPower() >= minValue &&
                        car.getPower() <= maxValue);
            }
            if (fmode == 3){
                FilterShips(baseOfCars, (Car s) -> s.getCost() >= minValue &&
                        s.getCost() <= maxValue);
            }
        }
        else if(fmode == 1){
            System.out.print("Enter a letter(s):");
            String strValue = in.next();
            FilterShips(baseOfCars, (Car s) -> s.getName().contains(strValue));
        }
    }

    protected void addHistory(LocalDate date, String statement){
        allHistory.put(date, statement);
    }

    protected void AddUser(User user){
        baseOfUsers.add(user);
    }

    public void getListOfClients(){
        for(User user: baseOfUsers){
            System.out.println(user);
        }
    }

    public boolean sortClients(){
        Scanner in = new Scanner(System.in);
        System.out.println("Reverse sort?(1 - yes/ 0 - no)");
        int reverse = in.nextInt();

        if(reverse == 1){
            baseOfUsers.sort(Comparator.comparing(User::getName).reversed());
        }
        else if(reverse == 0){
            baseOfUsers.sort(Comparator.comparing(User::getName));
        }

        for (var c : baseOfUsers) {
            System.out.println(c);
        }
        return true;
    }

    protected int SearchInStatement(){
        int generalCount = 0;
        int count = 0;
        for (Car c : baseOfCars){
            for (User u : baseOfUsers){
               for(Map.Entry<LocalDate, String> item : u.userHistory.entrySet()){
                    if(item.getValue().contains(c.getName())){
                        count++;
                    }
               }
               System.out.print(c.getName() + " wants " + count + '\n');
               generalCount+=count;
               count = 0;
            }
        }
        return generalCount;
    }

    protected boolean CountOfClientsStatement(){
        int count = 0;
        for(User user: baseOfUsers){
            count = user.userHistory.size();
            System.out.print("This client has " + count + " statement(s)\n");
        }
        return true;
    }

    protected boolean CountOfStatementInTime(){
        System.out.println('\n' + "Input date(y-m-d): ");
        Scanner in = new Scanner(System.in);
        String dateOrTime = in.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(dateOrTime, formatter);
        try {
            for (User u : baseOfUsers) {
                for (Map.Entry<LocalDate, String> item : u.userHistory.entrySet()) {
                    if (item.getKey().equals(localDate)) {
                        System.out.println(item.toString());
                    }
                }
            }
        }
        catch (IndexOutOfBoundsException e){
            System.out.println(e.toString());
        }
        return true;
    }
}
