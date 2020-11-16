// Name: Marco Chan 
// Seneca Student ID: 152215182
// Seneca email: mchan107@myseneca.ca
// Date of completion: 11/09/2020
//
// Workshop 6
// Parallelogram.java

package lab6_shapesArea;

public class Parallelogram implements Shape 
{
	private double width;
	private double height;
	
	//Parallelogram constructor takes in two doubles (width, height)
	//Both width and height must be greater than zero
	//Otherwise invalidParallelogramException throws an error
	public Parallelogram (double width, double height) throws invalidParallelogramException
	{
		if (width > 0 && height > 0)
		{
			setWidth(width);
			setHeight(height);
		}
		
		else
		{
			throw new invalidParallelogramException();
		}
	}
	
	public void setWidth (double width) throws invalidParallelogramException
	{
		if (width > 0)
		{
			this.width = width;
		}
		
		else
		{
			throw new invalidParallelogramException();
		}
	}
	
	public void setHeight (double height) throws invalidParallelogramException
	{
		if (height > 0)
		{
			this.height = height;
		}
		
		else
		{
			throw new invalidParallelogramException();
		}
	}
	
	public double getWidth()
	{
		return width;
	}
	
	public double getHeight()
	{
		return height;
	}
	
	@Override
	public double getPerimeter()
	{
		return 2 * (getHeight() + getWidth());
	}
	
	@Override
	public String toString()
	{
		return String.format("Parallelogram {w=" + getWidth() + ", h=" + getHeight() + "} perimeter = %.5f" , getPerimeter());
	}
}
