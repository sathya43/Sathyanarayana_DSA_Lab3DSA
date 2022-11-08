package com.grearlearning.assignment.BalncedParanthesis;

import java.util.*;
import java.io.*;

public class BalncedParanthesisProblem {
	
  public static boolean isBalanced(String inputString) {
	  // We can use the stack from Java collections
	  // Stack<Character> st = new Stack<Character>();
	   
	   StackImpl st1 = new StackImpl();
		  
	   int len = inputString.length();
	   
	   for(int i = 0;i<len;i++) {
          
		   if(inputString.charAt(i) == '{' || inputString.charAt(i) == '[' || inputString.charAt(i) == '(' ) {
			   st1.push(inputString.charAt(i));
		   }
		   else if(inputString.charAt(i) == '}' || inputString.charAt(i) == ']' || inputString.charAt(i) == ')'){
			       if( !st1.isEmpty()) {
				       char ch = st1.peek();
				             if( inputString.charAt(i) == '}' && ch == '{' ) {
					               st1.pop();
					               continue;
					         } else if( inputString.charAt(i) == ']' && ch == '[' ) {
						          st1.pop();
						          continue;
					         }else if( inputString.charAt(i) == ')' && ch == '(' ) {
							      st1.pop();
							      continue;
					          }else {
					        	  return false;
					          }
				   
			       }else {
				       return false;
			       }
		   }else {
			   return false;
		   }
	   }
 
	   return st1.isEmpty();
	  
  }
	
   public static void main(String[] args) {
	   String inputString = "";
	   
	   System.out.println("Enter the input to be validated");
	   
	   Scanner sc =  new Scanner(System.in);
	   inputString = sc.next();
	   
       boolean isBalanced;
       
       isBalanced = isBalanced(inputString);
       
       if(isBalanced) {
    	   System.out.println("The entered String has Balanced Brackets");
       }else {
    	   System.out.println("The entered Strings do not contain Balanced Brackets");
       }
   }

}
