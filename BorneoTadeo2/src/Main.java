import Models.Kit;
import Models.Person;
import Exception.*;
import Registers.AislarRegister;
import Registers.JsonRegister;
import Registers.PersonRegister;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.Map;
import java.util.UUID;

public class Main {
    public static void main(String[] args) throws IOException {
        Ssm sistema = new Ssm();

        for (int i = 0; i < 3; i++) {
            sistema.getKits().add(new Kit());
        }
        Person p1 = new Person("Juan", "Martin", 20, "San carlos", "46112406", "Herrero");
        Person p2 = new Person("Miguel", "Perez", 33, "Chauvin", "33700349", "Programador");
        Person p3 = new Person("Luis", "Funes", 19, "San jose", "44890222", "Pintor");

        try {
            sistema.personRegister(p1);
            sistema.personRegister(p2);
            sistema.personRegister(p3);
        } catch (OutOfTest e) {
            System.out.println(e.getMessage());
        }

        Map<UUID, PersonRegister> personRegisterMap = sistema.testear();
        File file = new File("urgente.dat");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("urgente.dat"));
        ObjectMapper mapper = new ObjectMapper();
        JsonRegister jsonRegister = new JsonRegister();

        for (Map.Entry<UUID, PersonRegister> entry : personRegisterMap.entrySet()) {
            try {
                sistema.aislar(entry.getValue());
                Person p = sistema.searchPersonByDni(entry.getValue().getDni());

                if (p != null)
                    jsonRegister.getSanos().add(p);
            } catch (AislarException e) {
                oos.writeObject(e);
                jsonRegister.getAislar().add(new AislarRegister(entry.getKey(),entry.getValue().getTemperature(),e.getNeighborhood()));
            }
        }
        mapper.writeValue(new File("Jsonregister.json"),jsonRegister);

    }
}