// Name: Marco Chan  
// Seneca Student ID: 152215182
// Seneca email: mchan107@myseneca.ca
// Date of completion: 11/23/2020
//
// Workshop 8
// StudentProcess.java

package lab7_students;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentProcess 
{
	public static void main(String[] args) throws Exception 
	{
		//Students array
        Student[] students = {
                new Student("Jack", "Smith", 50.0, "IT"),
                new Student("Aaron", "Johnson", 76.0, "IT"),
                new Student("Maaria", "White", 35.8, "Business"),
                new Student("John", "White", 47.0, "Media"),
                new Student("Laney", "White", 62.0, "IT"),
                new Student("Jack", "Jones", 32.9, "Business"),
                new Student("Wesley", "Jones", 42.89, "Media")};

        //Task 1
        System.out.println("Task 1:\n\nComplete Student list:");
        List<Student> studentList = Arrays.asList(students);
        studentList.forEach(System.out::println);
        
        //Task 2
        System.out.println("\nTask 2:\n\nStudents who got 50.0-100.0 sorted by grade:");
        
        studentList
	        .stream()
	        .filter(student -> student.getGrade() >= 50) //Filter student array to have grades >= 50
	        .sorted(Comparator.comparing(Student::getGrade)) //Sort student array based on grades >= 50 (highest to lowest)
	        .forEach(System.out::println);
        
        //Task 3
        System.out.println("\nTask 3:\n\nFirst Student who got 50.0-100.0:");
        
        studentList
        	.stream()
        	.filter(student -> student.getGrade() >= 50) //Filter student array to have grades >= 50
        	.findFirst() //Find first student in filtered list to have a grade >= 50
        	.ifPresent(System.out::println);
        
        //Task 4
        System.out.println("\nTask 4:\n\nStudents in ascending order by last name then first:");
        
        studentList
        	.stream()
        	.sorted(Comparator.comparing(Student::getFirstName)) //First, sort by first name
        	.sorted(Comparator.comparing(Student::getLastName)) //Secondly, sort by last name after sorting first name
        	.forEach(System.out::println);
        
        System.out.println("\nStudents in descending order by last name then first:");
        
        studentList
	    	.stream()
	    	.sorted(Comparator.comparing(Student::getFirstName).reversed()) //Firstly, sort by first name in reverse order
	    	.sorted(Comparator.comparing(Student::getLastName).reversed()) //Secondly, sort by last name in reverse order
	    	.forEach(System.out::println);
        
        //Task 5
        System.out.println("\nTask 5:\n\nUnique Student last names:");
        
        studentList
        	.stream()
        	.map(Student::getLastName)
        	.distinct()
        	.sorted()
        	.forEach(System.out::println);
        
        //Task 6
        System.out.println("\nTask 6:\n\nStudent names in order by last name then first name:");
        
        studentList
	        .stream()
	        .sorted(Comparator.comparing(Student::getFirstName))
	        .sorted(Comparator.comparing(Student::getLastName))
	        .map(Student::getName)
	        .forEach(System.out::println);
        
        //Task 7
        System.out.println("\nTask 7:\n\nStudents by department:");
        
        studentList
	        .stream()
	        .collect(Collectors.groupingBy(Student::getDepartment))
	        .forEach((student, list) -> {System.out.println(student);
	        list.forEach(department -> System.out.println("\t" + department));
	        });
        
        //Task 8
        System.out.println("\nTask 8:\n\nCount of Students by department:");
        
        studentList
        	.stream()
        	.collect(Collectors.groupingBy(Student::getDepartment))
        	.forEach((department, list) -> {System.out.println(String.format("%s has %d Student(s)", department, list.size()));
        	});
        
        //Task 9
        System.out.println("\nTask 9:\n");
        
        double sum = studentList
        	.stream()
        	.mapToDouble(student -> student.getGrade())
        	.sum();
        	System.out.println("Sum of Students' grades: " + sum);
        	
        //Task 10
        System.out.println("\nTask 10:\n");
        
        double avg = studentList
	        .stream()
	    	.mapToDouble(student -> student.getGrade())
	    	.average().getAsDouble();
	    	System.out.println("Average of Students' grades: " + String.format("%4.2f", avg));
	}
}
