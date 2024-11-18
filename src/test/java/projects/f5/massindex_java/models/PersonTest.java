package projects.f5.massindex_java.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

public class PersonTest {

    @Test
    public void testPersonGetters() {
        Person person = new Person(70.0, 1.55);

        assertThat(person.getWeight(), is(equalTo(70.0)));
        assertThat(person.getHeight(), is(equalTo(1.55)));
    }

    @Test
    public void testPersonSetters() {
        Person person = new Person(65.0, 1.70);

        person.setWeight(78.0);
        person.setHeight(1.65);

        assertThat(person.getWeight(), is(equalTo(78.0)));
        assertThat(person.getHeight(), is(equalTo(1.65)));

    }
}
