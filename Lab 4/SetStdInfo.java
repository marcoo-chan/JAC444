// Name: Marco Chan 
// Seneca Student ID: 152215182
// Seneca email: mchan107@myseneca.ca
// Date of completion: 10/19/2020
//
// Workshop 4
// SetStdInfo.java

package lab4_students;

import java.io.FileOutputStream;  
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class SetStdInfo 
{
    public static final String OUTPUT_FILE = "students.txt";
    private Scanner scanner;
    private final ArrayList<Student> students;

    public static void main(String[] args) 
    {
    	try 
    	{
    		SetStdInfo reader = new SetStdInfo();
    		reader.addStudents();
    	} 
    	
    	catch (IOException e) 
    	{
    		System.out.println(e.getMessage());
    	}
    }
    
    public SetStdInfo() throws IOException 
    {
    	students = ReadStdInfo.loadStudents();
        scanner = new Scanner(System.in);
    }

    //Call info setters (id, firstname, lastname, courses) and write to output file
    //Write student data to output file via "ObjectOutputStream oos"
    public Student setStudentData() 
    {
        int id = readId();
        String firstName = readFirstName();
        String lastName = readLastName();
        ArrayList<String> courses = readCourses();
        
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(OUTPUT_FILE)))
		{
			oos.writeObject(students);
		} 
		
		catch (IOException e) 
		{
			
		}
        
        return new Student(id, firstName, lastName, courses);
    }

    public int readId() 
    {
        System.out.print("Enter the student ID: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public String readFirstName() 
    {
        System.out.print("Enter the student first name: ");
        return scanner.nextLine();
    }

    public String readLastName() 
    {
        System.out.print("Enter the student last name: ");
        return scanner.nextLine();
    }

    public String readCourse() 
    {
        System.out.print("Enter a course name or 0 to stop: ");
        return scanner.nextLine();
    }

    //Add courses to array list, stop if user enters '0'
    public ArrayList<String> readCourses() 
    {
        ArrayList<String> courses = new ArrayList<>();
        String course = readCourse();
        
        while (!course.equals("0")) 
        {
            courses.add(course);
            course = readCourse();
        }
        
        return courses;
    }
    
    //Add students to output file and also calls "addMoreStudents" to prompt user if there is a need to add more students
    //students.add(student) adds the created student object to the output file via (try ObjectOutputStream oss)
    public void addStudents() throws IOException 
    {
        Student student;
        boolean add = true;
        
        while (add == true) 
        {
            student = setStudentData();
            students.add(student);
            add = addMoreStudents();
        }
        
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(OUTPUT_FILE)))
		{
			oos.writeObject(students);
		} 
		
		catch (IOException e) 
		{
			
		}
    }
    
    private boolean addMoreStudents() 
    {
        char end;
        System.out.print("Would you like to add another student (Y/N)? ");
        
        try 
        {
            end = scanner.nextLine().charAt(0);
        } 
        
        catch (StringIndexOutOfBoundsException e) 
        {
            end = 'N';
        }
        
        return end == 'y' || end == 'Y';
    }
}
