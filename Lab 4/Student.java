// Name: Marco Chan 
// Seneca Student ID: 152215182
// Seneca email: mchan107@myseneca.ca
// Date of completion: 10/19/2020
//
// Workshop 4
// Student.java

package lab4_students;

import java.io.Serializable; 
import java.util.ArrayList;
import java.util.Arrays;

public class Student implements Serializable 
{
	private int stdID;
    private String firstName;
    private String lastName;
    private ArrayList<String> courses;

    public Student (int id, String fName, String lName, ArrayList<String> courses) 
    {
    	this.stdID = id;
    	this.firstName = fName;
    	this.lastName = lName;
    	this.courses = new ArrayList<>(courses);
    }
    
    public int getStdID() 
    {
        return stdID;
    }

    public String getFirstName() 
    {
        return firstName;
    }

    public String getLastName() 
    {
        return lastName;
    }

    public ArrayList<String> getCourses() 
    {
		return courses;
	}
    
    public void setCourses(ArrayList<String> courses) 
    {
        this.courses = new ArrayList<>(courses);
    }
    
    public void addCourse(String course)
    {
    	courses.add(course);
    }
    
    public void printAll()
    {
    	System.out.println("<--- Student Info --->");
    	System.out.println("Student ID: " + stdID);
    	System.out.println("Student First Name: " + firstName);
    	System.out.println("Student Last Name: " + lastName);
    	System.out.println("Courses: " + courses);
    }
}
