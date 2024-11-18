package projects.f5.massindex_java.view;

import java.util.Scanner;

public class BmiView {

    private Scanner scanner = new Scanner(System.in);

    public double askWeight() {
        System.out.println();
        System.out.println("Let's count your Body Mass Index!");
        System.out.println("---------------------------------\n");
        System.out.println("Enter your weight in kilograms:");
        return scanner.nextDouble();
    }

    public double askHeight() {

        System.out.println("Enter your height in meters:");
        return scanner.nextDouble();
    }

    public void showResults(double bmi, String clasification) {
        System.out.println("\n---------------------------------");
        System.out.printf("Your BMI is: %.2f\n", bmi);
        System.out.println("That means, that you have " + clasification);
        System.out.println();
    }
}
