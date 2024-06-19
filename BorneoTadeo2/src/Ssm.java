import Models.Kit;
import Models.Person;
import Exception.*;
import Registers.PersonRegister;

import java.util.*;

public class Ssm {
    List<Kit> kits;
    Set<Person> persons;

    public Ssm() {
        this.kits = new ArrayList<>();
        this.persons = new LinkedHashSet<>();
    }

    public List<Kit> getKits() {
        return kits;
    }

    public void setKits(List<Kit> kits) {
        this.kits = kits;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }

    public void personRegister(Person person) throws OutOfTest {
        if (this.getKits().size() > 0) {
            person.setKit(this.getKits().getFirst());
            this.getPersons().add(person);
            this.getKits().removeFirst();
        } else if (false)//NO HAY MAS TEST
            throw new OutOfTest("Without stock");
        else {//HAY MAS TEST
            for (int i = 0; i < 10; i++) {
                this.getKits().add(new Kit());
            }
            person.setKit(this.getKits().getFirst());
            this.getPersons().add(person);
        }
    }

    public Map<UUID, PersonRegister> testear() {
        Map<UUID, PersonRegister> personRegisterMap = new HashMap<>();
        for (Person p : this.getPersons()) {
            Integer temperature = (int) (36 + Math.random() * 4);
            personRegisterMap.put(p.getKit().getId(), new PersonRegister(temperature, p.getDni()));
        }
        return personRegisterMap;
    }

    public void aislar(PersonRegister personRegister) throws AislarException {
        if (personRegister.getTemperature() >= 38) {
            Person p = searchPersonByDni(personRegister.getDni());
            if(p != null)
                throw new AislarException("Risk person", p.getKit().getId(), p.getNeighborhood());
        }
    }

    public Person searchPersonByDni(String dni) {
        for (Person p : this.getPersons()) {
            if (p.getDni().equals(dni))
                return p;
        }
        return null;
    }
}
