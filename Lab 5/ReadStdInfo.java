// Name: Marco Chan 
// Seneca Student ID: 152215182
// Seneca email: mchan107@myseneca.ca
// Date of completion: 11/01/2020
//
// Workshop 5
// ReadStdInfo.java

package application;

import java.io.*; 
import java.util.ArrayList;

public class ReadStdInfo implements AutoCloseable   
{
    public static final String INPUT_FILE = "students.txt";
    private ObjectInputStream ois;

    public static void main(String[] args) throws Exception 
    {
    	try (ReadStdInfo reader = new ReadStdInfo())
    	{
			ArrayList<Student> students = loadStudents();
			
			for (Student student : students) 
			{
				student.printAll();
				System.out.println();
			}
    	}
    	
    	catch (IOException e) 
    	{
            System.out.println(e.getMessage());
        }
	}

    public void StudentLoader() throws IOException 
    {
        ois = new ObjectInputStream(new FileInputStream(INPUT_FILE));
    }
    
    public static ArrayList<Student> loadStudents()
    {
		ArrayList<Student> student = new ArrayList<>();
		
		try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(INPUT_FILE)))
		{
			student = (ArrayList<Student>) is.readObject();
		}
		
		catch (IOException | ClassNotFoundException e) 
		{
			
		}
		
		return student;
	}

	@Override
	public void close() throws Exception 
	{
		
	}
}
