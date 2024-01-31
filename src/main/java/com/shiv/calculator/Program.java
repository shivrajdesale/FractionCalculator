package com.shiv.calculator;

import com.shiv.calculator.exception.InvalidInputException;
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
        FractionalCalculator calculator = new FractionalCalculator(new FractionalExpressionInterpreter());
        try (Scanner scanner = new Scanner(System.in)){
            do {
                System.out.print("\n? ");
                String input = scanner.nextLine().trim();
                if (input.equalsIgnoreCase("exit")) {
                    continueProgram = false;
                } else {
                    try {
                        Optional<FractionalNumber> output = calculator.calculate(input);
                        output.ifPresent(fractionalNumber -> System.out.println("= " + fractionalNumber));
                    } catch (InvalidInputException ie){
                        System.out.println("= " + ie.getMessage());
                    }

                }

            } while (continueProgram);
        }catch (Exception e){
           System.out.println("= Error while executing code " + e.getMessage());
        } finally {
           this.exit();
        }
    }

    public void exit(){
        System.out.println("= Exiting Program");
        System.exit(0);
    }

}
