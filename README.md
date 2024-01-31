# FractionCalculator
Program to perform Arithmetic operations on complex Fractional Numbers

Pre-requisites
1. Java  #This project is created and tested with Oracle JDK 11.0.20
2. Gradle #This project is created, built and tested with Gradle 6.9.4

Steps to build
1. Clone this repo using git clone https://github.com/shivrajdesale/FractionCalculator.git
2. Go to project directory FractionCalculator
3. Run 'gradle clean build' to build project
4. Built jar will be available under build/libs directory in Project Directory with name FractionCalculator-{version}.jar
   i.e. FractionCalculator-1.0.0.jar

Steps to Run
1. Run command "java -jar FractionCalculator-1.0.0.jar"
2. Cosole will prompt for input
3. Enter input in the format "m o n" and hit Enter
   where m is fractional number - left operand. For example 5, 2/5, 2&2/5, -1/5 etc.
         o is operand. Acceptable operands are +, -, * and /
         n is fractional number - right operand. Similar to m
4. For each input, output will be printed with format "= result"
   where result is fractional number
5. To exit the program, type "exit" and hit Exnter



