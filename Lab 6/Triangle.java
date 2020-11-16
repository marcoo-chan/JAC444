// Name: Marco Chan 
// Seneca Student ID: 152215182
// Seneca email: mchan107@myseneca.ca
// Date of completion: 11/09/2020
//
// Workshop 6
// Triangle.java

package lab6_shapesArea;

public class Triangle implements Shape 
{
	private double s1;
	private double s2;
	private double s3;
	
	//Triangle constructor takes in three doubles (s1, s2, s3)
	//All sides must be greater than zero and fulfill the foundations of a triangle
	//Otherwise invalidTriangleException throws an error
	public Triangle (double s1, double s2, double s3) throws invalidTriangleException
	{
		if (isValid(s1, s2, s3))
		{
			setS1(s1);
			setS2(s2);
			setS3(s3);
		}
		
		else
		{
			throw new invalidTriangleException();
		}
	}
	
	public boolean isValid (double s1, double s2, double s3)
	{	
		if (s1 > 0 && s2 > 0 && s3 > 0)
		{
			if ((s1 + s2) > s3 && (s1 + s3) > s2 && (s2 + s3) > s1)
			{
				return true;
			}
			
			else
			{
				return false;
			}
		}
		
		else
		{
			return false;
		}
	}
	
	public void setS1 (double s1) throws invalidTriangleException
	{
		if (s1 > 0)
		{
			this.s1 = s1;
		}
		
		else
		{
			throw new invalidTriangleException();
		}
	}
	
	public void setS2 (double s2) throws invalidTriangleException
	{
		if (s2 > 0)
		{
			this.s2 = s2;
		}
		
		else
		{
			throw new invalidTriangleException();
		}
	}
	
	public void setS3 (double s3) throws invalidTriangleException
	{
		if (s3 > 0)
		{
			this.s3 = s3;
		}
		
		else
		{
			throw new invalidTriangleException();
		}
	}
	
	public double getS1()
	{
		return s1;
	}
	
	public double getS2()
	{
		return s2;
	}
	
	public double getS3()
	{
		return s3;
	}
	
	@Override
	public double getPerimeter()
	{
		return getS1() + getS2() + getS3();
	}
	
	@Override
	public String toString()
	{
		return String.format("Triangle {s1=" + getS1() + ", s2=" + getS2() + ", s3=" + getS3() + "} perimeter = %.5f" , getPerimeter());
	}
}
