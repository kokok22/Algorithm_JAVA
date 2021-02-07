package com.ssafy;

import java.io.*;
import java.util.Stack;

public class BalancedWorld {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Stack<Character> stack = new Stack<>();
		
		while(true) {
			String s = br.readLine();
			if(s.charAt(0) == '.')
				break;
			String answer = "yes";
			
			for(int i=0;i<s.length();i++) {
				char c = s.charAt(i);
				if(c=='(' || c=='[')
					stack.push(c);
				else if(c == ')') {
					if(stack.isEmpty() || stack.pop()!='(') {
						answer = "no";
						break;
					}
				}else if(c== ']')
					if(stack.isEmpty() || stack.pop()!= '[') {
						answer = "no";
						break;
					}
			}
			if (!stack.isEmpty())
				answer = "no";
			
			bw.write(answer+"\n");
			stack.clear();
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
