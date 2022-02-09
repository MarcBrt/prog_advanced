package advancedjava;

import java.io.*;
import java.util.List;

public class ExerciceSerialization {
    public static void main(String[] arg) throws IOException, ClassNotFoundException {
        String fileName="personnes.bin";
        try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(fileName)))
        {
            out.writeObject(Person.getPersonsExamples());
        }
        try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(fileName)))
        {
            Object o=in.readObject();
            if (o instanceof List) {
                @SuppressWarnings("unchecked")
                List<Person> l=(List<Person>)o;
                System.out.println(l);
            }

        }

    }
}
