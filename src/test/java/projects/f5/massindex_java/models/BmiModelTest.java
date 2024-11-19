package projects.f5.massindex_java.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BmiModelTest {

    private Person person;
    private BmiModel bmiModel;

    @BeforeEach
    public void setUp() {
        person = new Person(70.0, 1.78);
        bmiModel = new BmiModel(person);
    }

    @Test
    public void testCalculateBMI() {
        double bmi = bmiModel.calculateBMI();
        assertEquals(22.09, bmi, 0.01);
    }

    @Test
    public void testGiveResultsBMI() {
        double bmi = bmiModel.calculateBMI();
        String classification = bmiModel.giveResultsBMI(bmi);
        assertThat(classification, is(equalTo("Normal weight")));

    }

    @Test
    public void testBMICategories() {
        assertThat(new BmiModel(new Person(45.0, 1.80)).giveResultsBMI(13.89), equalTo("Severe thinness"));
        assertThat(new BmiModel(new Person(52.0, 1.80)).giveResultsBMI(16.05), equalTo("Moderate thinness"));
        assertThat(new BmiModel(new Person(57.0, 1.80)).giveResultsBMI(17.59), equalTo("Mild thinness"));
        assertThat(new BmiModel(new Person(70.0, 1.78)).giveResultsBMI(22.09), equalTo("Normal weight"));
        assertThat(new BmiModel(new Person(85.0, 1.80)).giveResultsBMI(26.23), equalTo("Overweight"));
        assertThat(new BmiModel(new Person(100.0, 1.80)).giveResultsBMI(30.86), equalTo("Mild obesity"));
        assertThat(new BmiModel(new Person(115.0, 1.80)).giveResultsBMI(35.49), equalTo("Moderate obesity"));
        assertThat(new BmiModel(new Person(130.0, 1.80)).giveResultsBMI(40.12), equalTo("Morbid Obesity"));
    }

}
