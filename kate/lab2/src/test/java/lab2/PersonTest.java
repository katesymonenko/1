package lab2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class PersonTest {

		@Test
    void shouldCompareTwoEqualPersonsWithoutReference() {
        Person person1 = new Person("Natalia", "Grushko", 15, "female");
        Person person2 = new Person("Natalia", "Grushko", 15, "female");

        boolean areEqual = person1.equals(person2);

        Assertions.assertTrue(areEqual);
    }

    @Test
    void shouldCompareTwoInequalPersons() {
    		Person person1 = new Person("Natalia", "Grushko", 15, "female");
        Person person2 = new Person("Natalia", "Grushko", 17, "female");

        boolean areEqual = person1.equals(person2);

        Assertions.assertFalse(areEqual);
    }

		@Test
    void shouldCorrectlyWorkWithHashSet () {
    		HashSet<Person> set = new HashSet<Person>();
    		Person person1 = new Person("Natalia", "Grushko", 15, "female");
        Person person2 = new Person("Natalia", "Grushko", 15, "female");

				set.add(person1);

        Assertions.assertTrue(set.contains(person2));
    }

    @Test
    void shouldSerializeToJSON() {
    	Person person = new Person("Natalia", "Grushko", 15, "female");
    	String expected = "{\"name\":\"Natalia\",\"surname\":\"Grushko\",\"gender\":\"female\",\"age\":15}";
    	String actual = Person.toJSON(person);

    	Assertions.assertEquals(actual, expected);
    }

    @Test
    void shouldDeserializeFromJSON() {
    	String json = "{\"name\":\"Natalia\",\"surname\":\"Grushko\",\"gender\":\"female\",\"age\":15}";
    	Person person = Person.fromJSON(json);

    	Assertions.assertEquals(person.getName(), "Natalia");
    	Assertions.assertEquals(person.getAge(), 15);
    }
}
