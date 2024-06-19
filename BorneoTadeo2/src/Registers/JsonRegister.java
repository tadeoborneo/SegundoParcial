package Registers;

import Models.Person;

import java.util.ArrayList;
import java.util.List;

public class JsonRegister {
    private List<Person> sanos;
    private List<AislarRegister> aislar;

    public List<Person> getSanos() {
        return sanos;
    }

    public void setSanos(List<Person> sanos) {
        this.sanos = sanos;
    }

    public List<AislarRegister> getAislar() {
        return aislar;
    }

    public void setAislar(List<AislarRegister> aislar) {
        this.aislar = aislar;
    }

    public JsonRegister() {
        this.sanos = new ArrayList<>();
        this.aislar = new ArrayList<>();
    }
}
