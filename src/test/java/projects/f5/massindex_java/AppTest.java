package projects.f5.massindex_java;

import org.junit.jupiter.api.Test;

import projects.f5.massindex_java.controller.BmiController;
import projects.f5.massindex_java.models.BmiModel;
import projects.f5.massindex_java.models.Person;
import projects.f5.massindex_java.view.BmiView;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    @Test
    public void testMain() {
        BmiView fakeView = new BmiView() {
            @Override
            public double askWeight() {
                return 70.0;
            }

            @Override
            public double askHeight() {
                return 1.75;
            }

            @Override
            public void showResults(double bmi, String classification) {
            }
        };

        Person person = new Person(70.0, 1.75);
        BmiModel model = new BmiModel(person);

        BmiController controller = new BmiController(fakeView, model);

        controller.run();

        double expectedBmi = 22.86;
        String expectedClassification = "Normal weight";

        double actualBmi = model.calculateBMI();
        String actualClassification = model.giveResultsBMI(actualBmi);

        assertEquals(expectedBmi, actualBmi, 0.01);
        assertEquals(expectedClassification, actualClassification);
    }

}
