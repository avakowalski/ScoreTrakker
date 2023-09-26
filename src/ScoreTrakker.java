//Ava Kowalski 
//Eva Christianson
//Section C
//I, Ava Kowalski, certify that I participated equitably in the creation of assignment C10A, dated 09-26-23.
//I, Eva Christianson, certify that I participated equitably in the creation of this assignment C10A, dated 09-26-23.
// RESOURCES: Ava went to office hours with Kathleen Kelly to help move the code from my partners computer to mine, Calire Kintzley helped me structure my 
//process files function on line 58. TA Michael helped us debug our load filedata file method on line 22. 


import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class ScoreTrakker {
	//array that holds information about students 
    private ArrayList<Student> students;
    //added new array to hold files 
    private String[] files = {"scores.txt", "badscore.txt"," nofile.txt"};

  //Michael helped us debug this 
    private void loadDataFile(String fileName) throws FileNotFoundException {
		// !! Avas comment: The different way sadly had to be changed in part 2 
    		//students.clear();
    		FileReader reader = new FileReader(fileName);
			Scanner doesit = new Scanner(reader);
			students = new ArrayList<Student>();
			    while (doesit.hasNextLine()) {
			    	String name = doesit.nextLine();
		            String score = doesit.nextLine();
			    	//try to upload the users data from the file 
			    	try {
			    
		            	//extracting the integer value 
		                int score2 = Integer.valueOf(score);
		                Student student = new Student(name, score2);
		                students.add(student);

			            }
			    	//if its not a number then catch 
			        catch (NumberFormatException e) {
			        System.err.println("Incorrect format for " + name + " not a valid score: "+score);
			        }
			    }
			    doesit.close();
		}

    private void printInOrder() {
    	System.out.println("Student Score List:");
    	// refrenced https://www.youtube.com/watch?v=rH0winlka8A
    	// and https://www.geeksforgeeks.org/collections-in-java-2/
//        Collections.sort(students);
        Collections.sort(students);
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println();
    }
//Claire Kintzley heled me strutcure this function, because i was conceptually confused
    private void processFiles(){
    	for (String i: files) {
        	try {
        		loadDataFile(i);
        		printInOrder();
        		
        	} catch (FileNotFoundException e) {
        	System.out.println("Cannot open file:" +i);
        	System.out.println();
        	}
    	}
       
   }

	public static void main(String[] args){
        ScoreTrakker scoreTrakker = new ScoreTrakker();
        scoreTrakker.processFiles();
    }
}