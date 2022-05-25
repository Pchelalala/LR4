package com.company;

import java.util.Scanner;

import static com.company.Main.Authorization;

public class Admin {
    //private String password = "111";
    DataBase dataBase;

    public Admin(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public void Menu() {
        boolean result;
        do {
            result = EnterToAccount();
        } while (!result);

        Scanner in = new Scanner(System.in);

        System.out.println("=========Welcome administrator=========");

        while (true) {
            System.out.print("0 - exit\n" +
                    "1 - edit technical info\n" +
                    "2 - list of all cars\n" +
                    "3 - list of clients\n" +
                    "4 - sort list of clients\n" +
                    "5 - sort list of cars\n" +
                    "6 - report about statement of car\n" +
                    "7 - report about client`s statement\n" +
                    "8 - count of statements in certain period of time\n" +
                    "9 - change role\n" +
                    "Please enter a number:");
            int choice = in.nextInt();

            switch (choice) {
                case 0:
                    return;
                case 1:
                    dataBase.EditInfo();
                case 2:
                    dataBase.getListOfCars();
                    break;
                case 3:
                    dataBase.getListOfClients();
                    break;
                case 4:
                    dataBase.sortClients();
                    break;
                case 5:
                    dataBase.SortBy();
                    break;
                case 6:
                    dataBase.SearchInStatement();
                    break;
                case 7:
                    dataBase.CountOfClientsStatement();
                    break;
                case 8:
                    dataBase.CountOfStatementInTime();
                    break;
                case 9:
                    Authorization();
                    break;
                default:
                    System.out.println("You enter wrong number. Try again!");
            }
        }

    }

    public boolean EnterToAccount(){
        Scanner in = new Scanner(System.in);

        System.out.print("Please enter your password:");

        byte password = in.nextByte();

        if(password != 111){
            System.out.println("Your password was wrong try again");
            return false;
        }
        return true;
    }
}
