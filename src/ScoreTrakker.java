import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class ScoreTrakker {
    private ArrayList<Student> students;

    public ScoreTrakker() {
        students = new ArrayList<>();
    }

    private void loadDataFile(String fileName) {
    	// https://www.geeksforgeeks.org/java-io-bufferedreader-class-java/
    	// https://www.youtube.com/watch?v=waXvGUEjTTs
    	// https://www.youtube.com/watch?v=JaiCrtNMfEc
    	// I had free time this weekend so I wanted to try it a different way than it was taught in class :)
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String text;
            while ((text = reader.readLine()) != null) {
                String name = text;
                if ((text = reader.readLine()) != null) {
                    int score = Integer.parseInt(text);
                    Student student = new Student(name, score);
                    students.add(student);
                } else {
                    System.err.println("Error: Incomplete data for student '" + name + "'");
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    private void printInOrder() {
    	// refrenced https://www.youtube.com/watch?v=rH0winlka8A
    	// and https://www.geeksforgeeks.org/collections-in-java-2/
        Collections.sort(students);
        System.out.println("Student Score List");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void processFiles() {
        loadDataFile("scores.txt");
        printInOrder();
    }

    public static void main(String[] args) {
        ScoreTrakker scoreTrakker = new ScoreTrakker();
        scoreTrakker.processFiles();
    }
}