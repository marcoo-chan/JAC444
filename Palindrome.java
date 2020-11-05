// Name: Marco Chan
// Seneca Student ID: 152215182
// Seneca email: mchan107@myseneca.ca
// Date of completion: 09/28/2020
//
// Workshop 1
// Palindrome.java

package lab1_palindrome;

public class Palindrome 
{
	//verify is palindrome
	public static boolean isPalindrome(String str) 
	{
		//create new stack to hold strings
		int length = str.length();
		Stack stack = new Stack(length);
					
		//fill the stack with inputted strings, using a loop, we push each letter into the stack
		for (int i = 0; i < length; i++) 
		{
			stack.push(str.charAt(i));
		}
					
		// Compare input with pop, this way we don't need to reverse the array
		for (int i = 0; i < length; i++) 
		{
			if (str.charAt(i) != stack.pop()) 
			{
				return false;		
			}		
		}
		
		return true;
    }
	
	public static void main(String[] args) 
	{
		//loop through each argument to test for palindrome
		for (int i = 0; i < args.length; i++) 
		{
			//convert all strings to lowercase to cover case sensitive scenarios
            String str = args[i];
            String input = args[i].toLowerCase();
            
            if (isPalindrome(input)) 
            {
                System.out.println(str + " is a palindrome");
            } 
            
            else 
            {
                System.out.println(str + " is not a palindrome");
            }
        }
	}

}
