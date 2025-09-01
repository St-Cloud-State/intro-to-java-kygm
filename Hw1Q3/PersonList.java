package Hw1Q3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;

public class PersonList {

    public PersonList() {
        People = new LinkedList<Person>();
    }

    public LinkedList<Person> People;

    public void store(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            String[] members = line.trim().split("\\s+"); // splits the line into the three members of Person
            if (members.length == 3) {
                String firstName = members[0];
                String lastName = members[1];
                String id = members[2];

                People.add(new Person(firstName, lastName, id));
            }
        }
    }

    public void display(OutputStream outputStream) {
        PrintWriter printWriter = new PrintWriter(outputStream);
        for (Person person : People) {
            printWriter.println(person.toString());
        }

        printWriter.flush();
    }

    public int find(String sid) {
        for (int index = 0; index < People.size(); index++) {
            String personindex = People.get(index).getId();
            if (personindex.equals(sid)) {
                return index;
            }
        }
        return -1;
    }

}
