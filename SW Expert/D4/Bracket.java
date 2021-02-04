package com.ssafy;

import java.util.Stack;
import java.util.Scanner;

public class Bracket {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int t=0;t<10;t++) {
			int N = sc.nextInt();
			String strs = sc.next();
			Stack<Character> stack = new Stack<>();
			
			String in = "{[(<";
			String out = "}])>";
			
			for(int i=0;i<N;i++) {
				char c = strs.charAt(i);
				
				if(out.contains(c+"") && !stack.empty() &&
				stack.peek()==in.charAt(out.indexOf(c+"")))
					stack.pop();
				else
					stack.push(c);
			}
			if(stack.empty())
				System.out.printf("#%d %d\n",t+1,1);
			else
				System.out.printf("#%d %d\n",t+1,0);
		}
		
	}
}
