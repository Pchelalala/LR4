package com.company;

import java.util.List;

public class LambdaDemo {
    public static void FilterShips(List<Car> array, CheckUser tester){
        for (Car s: array){
            if (tester.test(s)){
                System.out.println(s);
            }
        }
    }
}
