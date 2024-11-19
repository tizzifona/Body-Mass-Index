package projects.f5.massindex_java.view;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class BmiView {

    private Scanner scanner;
    private final PrintStream output;

    public BmiView(InputStream input, PrintStream output) {
        this.scanner = new Scanner(input);
        this.output = output;
    }

    public BmiView() {
        this(System.in, System.out);
    }

    public double askWeight() {
        output.println();
        output.println("Let's count your Body Mass Index!");
        output.println("---------------------------------\n");
        output.println("Enter your weight in kilograms:");
        return scanner.nextDouble();
    }

    public double askHeight() {
        output.println("Enter your height in meters:");
        return scanner.nextDouble();
    }

    public void showResults(double bmi, String classification) {
        output.println("\n---------------------------------");
        output.printf("Your BMI is: %.2f\n", bmi);
        output.println("That means, that you have " + classification);
        output.println();
    }
}
