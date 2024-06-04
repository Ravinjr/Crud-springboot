package com.coding.LearnSpring;

import org.springframework.stereotype.Component;

@Component
public class CalculatorService {
    public int calculateSum(int a, int b){
        return a +b;
    }
}
