package Stacks;


import com.sun.deploy.uitoolkit.impl.fx.AppletStageManager;

import java.util.Scanner;
import java.util.Stack;

/* STACK CHALLENGE IS TO CHECK IF A STRING IS A PALINDROME
   BY USING A STACK.
 */
public class PalindromeStackApp {
    public static void main(String[] args) {
        Stack stack = new Stack<String>();
        System.out.println("Enter a string and I will check if it's a palindrome."
                            + " All spaces and punctuation will be ignored.");

        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

        for(int i = 0; i < string.length(); i++)
        {
            if(string.charAt(i) == ' ' || string.charAt(i) == ',' || string.charAt(i) == '"' || string.charAt(i) == '\'')
                continue;
            else
                stack.push(string.toLowerCase().charAt(i));
        }
        for(Object s : stack)
        {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println("Is this a palindrome? THE ANSWER IS " + palindrome_or_not(stack));
    }

    public static boolean palindrome_or_not(Stack stack)
    {
        int size = stack.size();
        /* get 1/2 of stack as string for easy comparison */
        StringBuilder sb = new StringBuilder(size/2);

        /* append 1/2 of stack to string builder */
        for(int i = 0; i < size/2; i++)
        {
            sb.append(stack.pop());
        }

        /* compare sb in reverse to stack.pop() to see if palindrome */
        for(int i = size/2 - 1; i >= 0; i--)
        {
            char sbChar = sb.charAt(i);
            char stackChar = (Character)stack.pop();
            /* if these are not equal, this is not a palindrome */
            if(sbChar != stackChar)
                return false;
        }
        /* if it made it this far, it's a palindrome */
        return true;
    }
}
