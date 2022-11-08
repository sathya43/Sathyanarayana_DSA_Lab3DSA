package com.grearlearning.assignment.BalncedParanthesis;

public class StackImpl {
	static final int Size_of_Stack = 1000;
	
	int top;
	char[] arr = new char[Size_of_Stack];
	
	StackImpl() {
		this.top = -1;
	}
	
	boolean push(char x) {
		if( top >= (Size_of_Stack - 1) ) {
			System.out.println("Stack Overflow");
			return false;
		}else {
			arr[++top] = x;
			return true;
		}
	}
	
	char pop() {
		if(top < 0) {
			System.out.println("Stack underflow");
			return '\0';
		}else {
			char x = arr[top--];
			return x;
		}
	}
	
	char peek() {
		return arr[top];
	}
	
	boolean isEmpty() {
		if( top < 0) {
			return true;
		}else {
			return false;
		}
	}

}
