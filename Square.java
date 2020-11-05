// Name: Marco Chan
// Seneca Student ID: 152215182
// Seneca email: mchan107@myseneca.ca
// Date of completion: 10/11/2020
//
// Workshop 3
// Square.java

package lab2_shapes;

public class Square extends Rectangle
{

	//Square constructor takes in a double (width)
	//Width must be greater than zero
	//Simultaneously, uses the parent constructor via "super()" 
	//Otherwise invalidParallelogramException throws an error
	public Square (double width) throws invalidParallelogramException 
	{
		super(width, width);
	}
	
	@Override
	public String toString()
	{
		return String.format("Square {s=" + getWidth() + "} perimeter = %.5f" , getPerimeter());
	}
}
