// Name: Marco Chan
// Seneca Student ID: 152215182
// Seneca email: mchan107@myseneca.ca
// Date of completion: 10/11/2020
//
// Workshop 3
// Main.java

package lab2_shapes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main 
{
	public static void main(String[] args) throws NumberFormatException, invalidParallelogramException, invalidRadiusException, invalidTriangleException, FileNotFoundException, IOException 
	{
        String line;
        int lines = 0;
        Shape[] shapes = new Shape[100];
        
        System.out.println("------->JAC 444 Assignment 1<-------");
        System.out.println("------->Task 1 ... <-------");
        
        //Read shapes.txt, read each line until null
        try (BufferedReader br = new BufferedReader(new FileReader("shapes.txt")))
        {
        	while ((line = br.readLine()) != null) 
        	{
				
				//Identify the delimiter in the text file, in this case ","
				String[] tokens = line.split(",");

				//Token of length two expects shape name and radius(circle) or width(square)
				//Call square or circle constructor based on first token (tokens[0])
				//Throw exception to build square/circle if values are insufficient		
				if (tokens.length == 2) 
				{
					if (tokens[0].equals("Square"))
					{
						try 
						{
							shapes[lines] = new Square(Double.parseDouble(tokens[1]));
							lines++;
						}
					
						catch (invalidParallelogramException e) 
						{
							System.out.println("Invalid side!");
						}
					}
					
					else if (tokens[0].equals("Circle"))
					{
						try 
						{
							shapes[lines] = new Circle(Double.parseDouble(tokens[1]));
							lines++;
						}
						
						catch (invalidRadiusException e) 
						{
							System.out.println("Invalid radius!");
						}
					}
				}
				
				//Token of length three expects shape name, width and height(parallelogram/rectangle)
				//Call parallelogram/rectangle constructor based on first token (tokens[0])
				//Throw exception to build parallelogram/rectangle if values are insufficient
				if (tokens.length == 3)
				{
					if (tokens[0].equals("Parallelogram"))
					{
						try 
						{
							shapes[lines] = new Parallelogram(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
							lines++;
						}
						
						catch (invalidParallelogramException e) 
						{
							System.out.println("Invalid side!");
						}
					}
					
					else if (tokens[0].equals("Rectangle"))
					{
						try 
						{
							shapes[lines] = new Rectangle(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
							lines++;
						}
						
						catch (Exception e) 
						{
							System.out.println("Invalid side!");
						}
					}
				}
				
				//Token of length four expects shape name and the three dimensions of a triangle
				//Call triangle constructor if first token is "triangle"
				//Throw exception to build triangle if values are insufficient
				if (tokens.length == 4) 
				{
					if (tokens[0].equals("Triangle"))
					{
						try 
						{
							shapes[lines] = new Triangle(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
							lines++;
						}
						
						catch (invalidTriangleException e) 
						{
							System.out.println("Invalid side(s)!");
						}
					}
				}
			}
		} 
        
        //Catch statement to surround the try
        catch (IOException e) 
        {
			System.out.println(e.getMessage());
		}
		
        //Print Task 1 Output (# of shapes created, all shapes and their perimeters)
		System.out.println("\n" + lines + " shapes were created:");
		
		for (int i = 0; i < lines; i++) 
		{
			System.out.println(shapes[i] + "\n");
		}
		
		//Beginning of Task 2 
		System.out.println("------->Task 2 ... <-------");
		
		double minTriangle = Double.MAX_VALUE; //Maximum value a double can represent
		double maxCircle = 0;
		
		//Iterate through shapes array specifically for cirlces and triangles
		//Through a series of if statements, determine smallest triangle perimeter
		//Through a series of if statements, determine largest circle perimeter
		for (int i = 0; i < shapes.length; i++)
		{
			if (shapes[i] instanceof Circle)
			{
				double perimeter = shapes[i].getPerimeter();
				
				if (maxCircle < perimeter)
				{
					maxCircle = perimeter;
				}
			}
			
			else if (shapes[i] instanceof Triangle)
			{
				double perimeter = shapes[i].getPerimeter();
				
				if (minTriangle > perimeter)
				{
					minTriangle = perimeter;
				}
			}
		}
		
		//Iterate through shapes array specifically for cirlces and triangles
		//If shape is circle, check if largest perimeter (maxCircle)
		//If shape is triangle, check if smallest perimeter (minTriangle)
		//Set circle/triangle to null if smallest/largest perimeter (maxCircle/minTriangle)
		for (int i = 0; i < shapes.length; i++)
		{
			if (shapes[i] instanceof Circle)
			{
				if (shapes[i].getPerimeter() == maxCircle)
				{
					shapes[i] = null;
				}
			}
			
			if (shapes[i] instanceof Triangle)
			{
				if (shapes[i].getPerimeter() == minTriangle)
				{
					shapes[i] = null;
				}
			}
		}
		
		//Print all shapes except the shapes set to null 
		for (int i = 0; i < lines; i++) 
		{
			if (shapes[i] != null)
			{
				System.out.println(shapes[i] + "\n");
			}
		}
		
		//Beginning of Task 3
		System.out.println("------->Task 3 ... <-------");
		
		double totalParallelogramPerimeter = 0;
		double totalTrianglePerimeter = 0;
		
		//Lastly get total triangle/parallelogram perimeter by looping through shapes array and utilizing "instanceof"
		//Simultaneously using "instanceof", we filter out square, rectangle and circle
		//We must filter out square and rectangle as well because they inherit from parallelogram via "extends" 
		for (int i = 0; i < shapes.length; i++)
		{
			if (shapes[i] instanceof Parallelogram)
			{
				if (!(shapes[i] instanceof Square || shapes[i] instanceof Rectangle))
				{
					totalParallelogramPerimeter += shapes[i].getPerimeter();
				}
			}
			
			if (shapes[i] instanceof Triangle)
			{
				totalTrianglePerimeter += shapes[i].getPerimeter();
			}
		}
		
		//Print total perimeter of parallelogram and triangle (excluding square and rectangle)
		System.out.println("Total perimeter of Parallelogram is: " + totalParallelogramPerimeter);
		System.out.println("Total perimeter of Triangle is: " + totalTrianglePerimeter);
    }
}
