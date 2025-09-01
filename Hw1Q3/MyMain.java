package Hw1Q3;

import java.util.Arrays;
import java.util.List;
import java.io.*;

class MyMain {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("./Hw1Q3/people.txt");

            System.out.println("Processing people... ");

            PersonList personList = new PersonList();
            personList.store(fileInputStream);

            System.out.println("Processed\n");
            personList.display(System.out);

            List<String> idsToSearch = Arrays.asList("1", "2", "63", "123");

            for (String id : idsToSearch) {
                int searchResultIndex = personList.find(id);
                System.out.println("Index of person id " + id + ": " + String.valueOf(searchResultIndex));
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.toString());
        }
    }
}