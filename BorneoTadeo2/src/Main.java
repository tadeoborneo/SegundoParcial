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
        //CREACION DE 3 KITS CON ID ALEATORIO
        for (int i = 0; i < 3; i++) {
            sistema.getKits().add(new Kit());
        }
        //CREACION DE PERSONAS PARA REGISTRAR
        Person p1 = new Person("Juan", "Martin", 20, "San carlos", "46112406", "Herrero");
        Person p2 = new Person("Miguel", "Perez", 33, "Chauvin", "33700349", "Programador");
        Person p3 = new Person("Luis", "Funes", 19, "San jose", "44890222", "Pintor");

        try {//REGISTRO DE PERSONAS EN EL LINKEDHASHSET DE LA INSTANCIA "SISTEMA"
            sistema.personRegister(p1);
            sistema.personRegister(p2);
            sistema.personRegister(p3);
        } catch (OutOfTest e) {//MANEJO DE LA EXCEPCION SI NOS QUEDAMOS SIN KITS (NO VA A PASAR YA QUE ESTA HARDCODEADO)
            System.out.println(e.getMessage());
        }

        //CREACION DEL MAPA PEDIDO EN LA CONSIGNA
        Map<UUID, PersonRegister> personRegisterMap = sistema.testear();

        //CREACION DE OBJETOS RELACIONADOS A ARCHIVOS
        File file = new File("urgente.dat");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("urgente.dat"));
        ObjectMapper mapper = new ObjectMapper();
        JsonRegister jsonRegister = new JsonRegister();

        for (Map.Entry<UUID, PersonRegister> entry : personRegisterMap.entrySet()) {
            //RECORRE EL MAPA, SI LA PERSONA TIENE UNA TEMPERATURA DE 38 GRADOS O MAS, EL METODO AISLAR LANZA UNA AISLAREXCEPTION
            //Y ESCRIBLE LA INSTANCIA DE LA EXCEPCION EN UN ARCHIVO .DAT.
            try {
                sistema.aislar(entry.getValue());
                Person p = sistema.searchPersonByDni(entry.getValue().getDni());
                if (p != null)
                    jsonRegister.getSanos().add(p);//CARGA EL REGISTRO CON LAS PERSONAS SANAS PARA LUEGO PERSISTIRLAS EN UN JSON
            } catch (AislarException e) {
                oos.writeObject(e);
                //CARGA EL REGISTRO CON LOS DATOS DE LAS PERSONAS AISLADAS PARA LUEGO PERSISTIRLOS EN EL ARCHIVO JSON
                jsonRegister.getAislar().add(new AislarRegister(entry.getKey(), entry.getValue().getTemperature(), e.getNeighborhood()));
            }
        }
        //ESCRIBE LA INSTANCIA DEL OBJETO LLENADO ANTERIORMENTE EN UN ARCHIVO JSON
        mapper.writeValue(new File("Jsonregister.json"), jsonRegister);

    }
}