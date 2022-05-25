package com.company;

import java.util.Vector;

public class LambdaDemo {
    public static void FilterShips(Car[] array, CheckUser tester){
        for (Car s: array){
            if (tester.test(s)){
                System.out.println(s);
            }
        }
    }
}
