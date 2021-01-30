package com.ssafy;

import java.util.Scanner;

public class BinaryAddition {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		String num1 = sc.next();
		String num2 = sc.next();
		
		for(int i=0;i<num1.length();i++) {
			if(num1.charAt(i)=='1') {
				num1 = num1.substring(i);
				break;
			}
		}
		
		for(int i=0;i<num2.length();i++) {
			if(num2.charAt(i)=='1') {
				num2 = num2.substring(i);
				break;
			}
		}
		
		if(!num1.contains("1"))
			num1 = "0";
		if(!num2.contains("1"))
			num2 = "0";
		
		
		int size1 = num1.length();
		int size2 = num2.length();
		
		while(size1 != size2) {
			if(size1<size2) {
				num1 = "0"+num1;
				size1++;
			}
			else {
				num2 = "0"+num2;
				size2++;
			}
		}
		
		int cnt = 0;
		String answer = "";
		
		for(int i=0;i<size1;i++) {
			int a = Integer.parseInt(num1.substring(size1-i-1,size1-i));
			int b = Integer.parseInt(num2.substring(size2-i-1,size2-i));
			
			if(a+b+cnt>1) {
				answer = Integer.toString(a+b+cnt-2)+answer;
				cnt = 1;
			}
			else {
				answer = Integer.toString(a+b+cnt)+answer;
				cnt = 0;
			}
		}
		if(cnt==1)
			answer = "1"+answer;

		System.out.println(answer);
	}
}
