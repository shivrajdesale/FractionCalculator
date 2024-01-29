package com.shiv.calculator;

/**
 * The Main will call the Singleton instance of Program and launch it.
 * @author Shivraj Desale
 */
public class Application {
    public static void main(String[] args) {
        Program.getInstance().launch();
    }
}