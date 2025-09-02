
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.io.*;

class MyMain {
    public static void main(String[] args) {
        LinkedList<Person> people = new LinkedList<Person>();

        try {
            FileInputStream fileInputStream = new FileInputStream("./people.txt");

            System.out.println("Processing people... ");

            store(fileInputStream, people);

            System.out.println("Processed\n");
            display(System.out, people);

            List<String> idsToSearch = Arrays.asList("1", "2", "63", "123");
            for (String id : idsToSearch) {
                System.out.println("Searching for person id: " + id + "...");

                int searchResultIndex = find(id, people);
                System.out.println("Index of person id " + id + ": " + String.valueOf(searchResultIndex));
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.toString());
        }
    }

    public static void store(InputStream inputStream, LinkedList<Person> people) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            String[] members = line.trim().split("\\s+"); // splits the line into the three members of Person
            if (members.length == 3) {
                String firstName = members[0];
                String lastName = members[1];
                String id = members[2];

                people.add(new Person(firstName, lastName, id));
            }
        }
    }

    public static void display(OutputStream outputStream, LinkedList<Person> people) {
        PrintWriter printWriter = new PrintWriter(outputStream);
        for (Person person : people) {
            printWriter.println(person.toString());
        }

        printWriter.flush();
    }

    public static int find(String sid, LinkedList<Person> people) {
        for (int index = 0; index < people.size(); index++) {
            String personindex = people.get(index).getId();
            if (personindex.equals(sid)) {
                return index;
            }
        }
        return -1;
    }
}