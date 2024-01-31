package com.shiv.calculator;

import com.shiv.calculator.interpreter.FractionalExpressionInterpreter;
import com.shiv.calculator.model.FractionalNumber;
import com.shiv.calculator.service.FractionalCalculator;

import java.util.Optional;
import java.util.Scanner;

/**
 * The Program class implements an application that reads operations on fractions string from the standard input
 * and prints fractional result to the standard output.
 * @author Shivraj Desale
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
        boolean continueProgram = true;
        try (Scanner scanner = new Scanner(System.in)){
            do {
                System.out.print("\n? ");
                String input = scanner.nextLine().trim();
                if (input.equalsIgnoreCase("exit")) {
                    continueProgram = false;
                } else {
                    Optional<FractionalNumber> output = new FractionalCalculator(
                            new FractionalExpressionInterpreter()).calculate(input);
                    if(output.isPresent()){
                        System.out.println("= " + output.get());
                    }else{
                        System.out.println("= Invalid Input");
                    }
                }

            } while (continueProgram);
        }catch (Exception e){
           System.out.println("= Invalid Input");
        } finally {
           this.exit();
        }




    }

    public void exit(){
        System.out.println("= Exiting Program");
        System.exit(0);
    }

}
