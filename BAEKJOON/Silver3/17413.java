package com.ssafy;

import java.util.Scanner;

public class ReversedWord {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String strs = sc.nextLine();
		char[] stack = new char[strs.length()];
		int idx=0;
		boolean flag = false;
		String answer = "";
		
		for(int i=0;i<strs.length();i++) {
			char c = strs.charAt(i);
			
			if(flag) {
				answer+=c;
				if(c=='>')
					flag = false;
			}
			else{
				if(c==' ') {
					while(idx>0)
						answer += stack[--idx];
					answer += " ";
				}
				else if(c=='<') {
					while(idx>0)
						answer += stack[--idx];
					answer += c;
					flag = true;
				}
				else
					stack[idx++] = c;
			}
		}
		while(idx>0)
			answer += stack[--idx];
		
		System.out.println(answer);	
	}
}
