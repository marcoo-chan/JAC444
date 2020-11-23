// Name: Marco Chan 
// Seneca Student ID: 152215182
// Seneca email: mchan107@myseneca.ca
// Date of completion: 11/16/2020
//
// Workshop 7
// Student.java

package lab7_students;

public class Student 
{
	private String firstName;
	private String lastName;
	private Double grade;
	private String department;
	
	//Constructor
	public Student(String firstName, String lastName, Double grade, String department)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.grade = grade;
		this.department = department;
	}
	
	//GETTERS
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public String getName()
	{
		return firstName + " " + lastName;
	}
	
	public Double getGrade()
	{
		return grade;
	}
	
	public String getDepartment()
	{
		return department;
	}
	
	//SETTERS
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public void setGrade(Double grade)
	{
		this.grade = grade;
	}
	
	public void setdepartment(String department)
	{
		this.department = department;
	}
	
	//toString method
	public String toString()
	{	
        return getFirstName() + "\t" + getLastName() +"\t" + String.format("%4.2f", getGrade()) +"\t" + getDepartment();
	}
	
	//equals method
	public boolean equals(Student obj)
	{
		if (obj == this)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
}
