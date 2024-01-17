package com.example.service;

public class MyUtil { // POJO(순수한, 평범한 자바 객체)
    public static int hap() {   // MyUtil.hap();
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        return sum;
    }
}
