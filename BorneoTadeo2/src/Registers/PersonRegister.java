package Registers;

public class PersonRegister {
    private Integer temperature;
    private String dni;

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public PersonRegister(Integer temperature, String dni) {
        this.temperature = temperature;
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "PersonRegister{" +
                "temperature=" + temperature +
                ", dni='" + dni + '\'' +
                '}';
    }
}
