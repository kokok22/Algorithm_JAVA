package com.ssafy;

import java.util.Scanner;

public class Palindrome {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		String num = sc.next();
		
		while(Integer.parseInt(num)!=0) {
			int start = 0;
			int end = num.length()-1;
			String answer = "yes";
			
			while(start<end) {
				if(num.charAt(start)!=num.charAt(end)) {
					answer = "no";
					break;
				}
				start++;
				end--;
			}
			System.out.println(answer);
			num = sc.next();
		}
	}
}
