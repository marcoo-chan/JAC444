// Name: Marco Chan 
// Seneca Student ID: 152215182
// Seneca email: mchan107@myseneca.ca
// Date of completion: 11/09/2020
//
// Workshop 6
// Square.java

package lab6_shapesArea;

public class Square extends Rectangle
{
	public getArea area;
	
	//Square constructor takes in a double (width)
	//Width must be greater than zero
	//Simultaneously, uses the parent constructor via "super()" 
	//Otherwise invalidParallelogramException throws an error
	public Square (double width) throws invalidParallelogramException 
	{
		super(width, width);
		
		area = () -> getWidth() * getWidth();
	}
	
	@Override
	public String toString()
	{
		return String.format("Square {s=" + getWidth() + "} perimeter = %.5f, area (l * w) = %.5f" , getPerimeter(), area.getArea());
	}
}
