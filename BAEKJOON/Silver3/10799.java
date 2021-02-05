package com.ssafy;

import java.util.Scanner;
import java.util.Stack;

public class IronBar {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=0;t<T;t++) {
			String strs = sc.next();
			Stack<Character> stack = new Stack<>();
			int answer = 0;
			char pre = '\0';
			
			for(int i=0;i<strs.length();i++) {
				char c = strs.charAt(i);
				if(pre=='(' && c==')') {
					stack.pop();
					answer += stack.size();
				}
				else if(c==')') {
					stack.pop();
					answer += 1;
				}
				else
					stack.push(c);
				pre = c;
			}
			System.out.printf("#%d %d\n",t+1,answer);
		}
	}
}
