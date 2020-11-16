// Name: Marco Chan 
// Seneca Student ID: 152215182
// Seneca email: mchan107@myseneca.ca
// Date of completion: 11/09/2020
//
// Workshop 6
// Circle.java

package lab6_shapesArea;
import java.lang.Math;

public class Circle implements Shape
{
	private double radius;
	public getArea area;
	
	//Parallelogram constructor takes in a double (radius)
	//Radius must be greater than zero
	//Otherwise invalidRadiusException throws an error
	public Circle (double radius) throws invalidRadiusException
	{
		if (radius > 0)
		{
			setRadius(radius);
		}
		
		else
		{
			throw new invalidRadiusException();
		}
		
        area = () -> this.radius * this.radius * Math.PI;
	}
	
	public void setRadius (double radius) throws invalidRadiusException
	{
		if (radius > 0)
		{
			this.radius = radius;
		}
		
		else
		{
			throw new invalidRadiusException();
		}
	}
	
	public double getRadius()
	{
		return radius;
	}
	
	@Override
	public double getPerimeter()
	{
		return 2 * Math.PI * getRadius();
	}
	
	@Override
	public String toString()
	{
		return String.format("Circle {r=" + getRadius() + "} perimeter = %.5f, area (r^2 * pi) = %.5f" , getPerimeter(), area.getArea());
	}
}
