package com.company;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import static com.company.Main.Authorization;

public class User {
    private Integer id;
    private String name;
    private String password;
    protected String statement;
    protected Map<LocalDate,String> userHistory = new HashMap<LocalDate,String>();
    private DataBase dataBase;

    public User() {
    }

    public User(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public User(String name, String password, Map<LocalDate, String> userHistory) {
        this.name = name;
        this.password = password;
        this.userHistory = userHistory;
    }

    public User(String name, DataBase dataBase){
        this.name = name;
        this.dataBase = dataBase;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public boolean UserMenu(){

        Scanner in = new Scanner(System.in);

        System.out.println("=========Welcome user=========");
        System.out.print("1 - create account\n" +
                "2 - log in\n" +
                "3 - choose another role\n" +
                "Please enter a number: ");

        int mode = in.nextInt();

        if (mode == 1){
           var result = this.CreateAccount();

           if (result){
               this.Menu();
           }
        }
        else if(mode == 2){
            var result = LogIn();

            if(result){
                this.Menu();
            }
        }
        else if(mode == 3){
            Authorization();
        }
        else{
            System.out.print("Wrong number, try again");
            this.UserMenu();
        }
        return true;
    }

    private boolean CreateAccount(){
        Scanner in = new Scanner(System.in);

        System.out.print("Enter your name: ");
        this.name = in.next();

        System.out.print("Enter your password: ");
        this.password = in.next();

        System.out.println("Congratulations your account was successfully created");

        dataBase.AddUser(this);
        return true;
    }

    private boolean LogIn(){
        Scanner in = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = in.next();

        System.out.print("Enter your password: ");
        String password = in.next();

        if (name.compareTo(this.name) == 0 && password.compareTo(this.password) == 0){
            System.out.println("Congratulations you successfully logged in");
        }
        else{
            System.out.println("Wrong password or name. Try again");
            return false;
        }
        return true;
    }

    public boolean Menu() {
        Scanner in = new Scanner(System.in);

        System.out.printf("=========Welcome %s=========\n", this.getName());

        while (true) {
            System.out.print("1 - change account\n" +
                    "2 - search cars\n" +
                    "3 - filter cars\n" +
                    "4 - create statement\n" +
                    "5 - history of statements\n" +
                    "6 - come back to menu\n" +
                    "Please enter a number:");

            int choice = in.nextInt();
            switch (choice) {
                case 1 -> {
                    return true;
                }
                case 2 -> this.dataBase.SearchingBy();
                case 3 -> this.dataBase.Filtering();
                case 4 -> this.CreateStatement();
                case 5 -> this.HistoryOfStatements();
                case 6 -> Authorization();
                default -> {
                    System.out.println("You enter wrong number. Try again!");
                    this.Menu();
                }
            }
        }
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString(){
        return "Name: "+ this.getName();
    }

    public boolean CreateStatement(){
        Scanner in = new Scanner(System.in);
        LocalDate date = LocalDate.now();

        System.out.print("Please enter your statement: ");

        String statement = in.next();

        this.statement = statement;

        userHistory.put(date,statement);
        dataBase.addHistory(date,statement);

        return true;
    }

    private boolean HistoryOfStatements(){
        for(int i = 0; i < userHistory.size(); i++) {
            System.out.println(userHistory);
        }
        return true;
    }
}
