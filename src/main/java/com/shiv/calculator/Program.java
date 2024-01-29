package com.shiv.calculator;

/**
 * The Program class implements an application that reads operations on fractions string from the standard input
 * and prints fractional result to the standard output.
 */

public class Program {
    private static Program instance = null;

    public static Program getInstance(){
        if(instance == null){
            instance = new Program();
        }
        return instance;
    }

    private Program(){
    }

    public void launch(){
        System.out.println("## Fractional Number Calculator ##");
    }

    public void exit(){

    }

}
