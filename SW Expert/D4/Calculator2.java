package com.ssafy;

import java.util.Scanner;
import java.util.Stack;

public class Calculator2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int t=0;t<10;t++) {
			int N =sc.nextInt();
			String op = sc.next();
			
			Stack<Character> opStack = new Stack<Character>();
			
			StringBuilder ops = new StringBuilder();
			
			for(int i=0;i<N;i++) {
				char c = op.charAt(i);
				if('0'<= c && c<='9')
					ops.append(c);
				else {
					if(c == '+') {
						while(!opStack.empty())
							ops.append(opStack.pop());
						opStack.push(c);
					}
					else if(c == '*') {
						while(!opStack.empty() && opStack.peek()!='+')
							ops.append(opStack.pop());
						opStack.push(c);
					}
				}
			}
			while(!opStack.empty())
				ops.append(opStack.pop());
			
			Stack<Integer> intStack = new Stack<>();
			int a, b;
			
			for(int i=0;i<N;i++) {
				char c = ops.charAt(i);
				if('0'<= c && c<='9')
					intStack.push(c-'0');
				else if(c =='+') {
					a = intStack.pop();
					b = intStack.pop();
					
					intStack.push(a+b);
				}
				else if(c == '*') {
					a = intStack.pop();
					b = intStack.pop();
					
					intStack.push(a*b);
				}
			}
			
			System.out.printf("#%d %d\n",t+1,intStack.pop());
		}
		sc.close();
	}
}
