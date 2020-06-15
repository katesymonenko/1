package lab2;

import com.google.gson.Gson;

public class Person {
		private final String name;
    private final String surname;
    private final String gender;
    private final int age;

    public Person(String name, String surname, int age, String gender) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
    }

    public String getName () {
    	return this.name;
    }

    public String getSurname () {
    	return this.surname;
    }

    public String getGender () {
    	return this.gender;
    }

    public int getAge () {
    	return this.age;
    }

    @Override
    public final boolean equals(Object objToCompare) {
        if(this == objToCompare) {
        	return true;
        }

        if(!(objToCompare instanceof Person)) {
        	return false;
        }

        // Мы должны сказать компилятору, что мы работаем с инстансом класса Person
        // Нам нужно проверить, что геттеры полей будут возвращать одинаковые значения
        Person personToCompare = (Person) objToCompare;

        return this.getName().contentEquals(personToCompare.getName())
    		&& this.getSurname().contentEquals(personToCompare.getSurname())
    		&& this.getAge() == personToCompare.getAge()
    		&& this.getGender().contentEquals(personToCompare.getGender());
    }

		@Override
	  public final int hashCode() {
				return Objects.hash(
						this.name,
						this.surname,
						this.age,
						this.gender
				);
	  }

    public static Person fromJSON(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Person.class);
    }

    public static String toJSON(Person person) {
        Gson gson = new Gson();
        return gson.toJson(person);
    }
}
