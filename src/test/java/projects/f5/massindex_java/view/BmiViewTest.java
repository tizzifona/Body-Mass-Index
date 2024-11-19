package projects.f5.massindex_java.view;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BmiViewTest {

    private ByteArrayOutputStream outputStream;
    private BmiView bmiView;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        PrintStream outputPrintStream = new PrintStream(outputStream);
        bmiView = new BmiView(new ByteArrayInputStream("".getBytes()), outputPrintStream);
    }

    @Test
    public void testAskWeight() {
        ByteArrayInputStream input = new ByteArrayInputStream("70.5\n".getBytes());
        bmiView = new BmiView(input, new PrintStream(outputStream));

        double weight = bmiView.askWeight();

        assertThat(weight, equalTo(70.5));
        String output = outputStream.toString();
        assertThat(output, containsString("Enter your weight in kilograms:"));
    }

    @Test
    public void testAskHeight() {
        ByteArrayInputStream input = new ByteArrayInputStream("1.75\n".getBytes());
        bmiView = new BmiView(input, new PrintStream(outputStream));

        double height = bmiView.askHeight();

        assertThat(height, equalTo(1.75));
        String output = outputStream.toString();
        assertThat(output, containsString("Enter your height in meters:"));
    }

    @Test
    public void testShowResults() {
        bmiView.showResults(22.09, "Normal weight");

        String output = outputStream.toString();
        assertThat(output, containsString("Your BMI is: 22.09"));
        assertThat(output, containsString("That means, that you have Normal weight"));
    }
}
