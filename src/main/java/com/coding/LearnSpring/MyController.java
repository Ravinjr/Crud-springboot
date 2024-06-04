package com.coding.LearnSpring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {

    //@Autowired
    private final CalculatorService calculatorService;
    //This is the Auto wiring(Method injection other than field injection)
    public MyController(CalculatorService calculatorService){
        this.calculatorService=calculatorService;
    }
    @RequestMapping(value = {"/home"} , method={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
    public String home(){
        return "Hello world";
    }

    @PutMapping(value = "/test")
    public String home2(){
        return "Hello 2";
    }

    @GetMapping("/sum")
    public int sum(@RequestParam("a")int a,@RequestParam("b")int b){
        return calculatorService.calculateSum(a, b);
    }

}
