// Name: Marco Chan
// Seneca Student ID: 152215182
// Seneca email: mchan107@myseneca.ca
// Date of completion: 09/28/2020
//
// Workshop 1
// Stack.java

package lab1_palindrome;

public class Stack 
{
	//create array and index vital to stack
	private char[] arr;
	private int top;
	
	//default constructor
	public Stack(int size)
	{
		arr = new char[size];
		top = -1;
	}
	
	//return element at top of stack and remove 
	public char pop()
	{
		return arr[top--];
	}
	
	//push to array stack
	public void push(char n)
	{
		
		arr[++top] = n;
	}
	
	//verify if stack is empty
	public boolean isEmpty()
	{
		return top == -1;
	}
}
