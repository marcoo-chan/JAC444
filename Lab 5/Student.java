// Name: Marco Chan 
// Seneca Student ID: 152215182
// Seneca email: mchan107@myseneca.ca
// Date of completion: 11/01/2020
//
// Workshop 5
// Student.java

package application;

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
    	System.out.println(this);
    	//System.out.println("<--- Student Info --->");
    	//System.out.println("Student ID: " + stdID);
    	//System.out.println("Student First Name: " + firstName);
    	//System.out.println("Student Last Name: " + lastName);
    	//System.out.println("Courses: " + courses);
    }
    
    @Override
    public String toString() 
    {
        String str = "==================\n";
        str += "Student ID: " + stdID + "\n";
        str += "Student First Name: " + firstName + "\n";
        str += "Student Last Name: " + lastName + "\n";
        str += "Courses: " + courses + "\n\n";
        
        return str;
    }
}
