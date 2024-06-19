package Models;

import java.util.Objects;

public class Person {
    private String name;
    private String surname;
    private Integer age;
    private String neighborhood;
    private String dni;
    private String occupation;
    private Kit kit;

    public Person(String name, String surname, Integer age, String neighborhood, String dni, String occupation) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.neighborhood = neighborhood;
        this.dni = dni;
        this.occupation = occupation;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Kit getKit() {
        return kit;
    }

    public void setKit(Kit kit) {
        this.kit = kit;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", neighborhood='" + neighborhood + '\'' +
                ", dni='" + dni + '\'' +
                ", occupation='" + occupation + '\'' +
                ", kit=" + kit +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return Objects.equals(dni, person.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dni);
    }
}
