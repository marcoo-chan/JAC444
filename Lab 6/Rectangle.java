// Name: Marco Chan 
// Seneca Student ID: 152215182
// Seneca email: mchan107@myseneca.ca
// Date of completion: 11/09/2020
//
// Workshop 6
// Rectangle.java

package lab6_shapesArea;

public class Rectangle extends Parallelogram
{
	public getArea area;
	
	//Rectangle constructor takes in two doubles (width, height)
	//Both width and height must be greater than zero
	//Simultaneously, uses the parent constructor via "super()" 
	//Otherwise invalidParallelogramException throws an error
	public Rectangle (double width, double height) throws invalidParallelogramException 
	{
		super(width, height);
		
		area = () -> getWidth() * getHeight();
	}
	
	@Override
	public String toString()
	{
		return String.format("Rectangle {w=" + getWidth() + ", h=" + getHeight() + "} perimeter = %.5f, area (l * w) = %.5f" , getPerimeter(), area.getArea());
	}
}
