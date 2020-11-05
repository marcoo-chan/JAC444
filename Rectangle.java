// Name: Marco Chan
// Seneca Student ID: 152215182
// Seneca email: mchan107@myseneca.ca
// Date of completion: 10/11/2020
//
// Workshop 3
// Rectangle.java

package lab2_shapes;

public class Rectangle extends Parallelogram
{

	//Rectangle constructor takes in two doubles (width, height)
	//Both width and height must be greater than zero
	//Simultaneously, uses the parent constructor via "super()" 
	//Otherwise invalidParallelogramException throws an error
	public Rectangle (double width, double height) throws invalidParallelogramException 
	{
		super(width, height);
	}
	
	@Override
	public String toString()
	{
		return String.format("Rectangle {w=" + getWidth() + ", h=" + getHeight() + "} perimeter = %.5f" , getPerimeter());
	}
}
