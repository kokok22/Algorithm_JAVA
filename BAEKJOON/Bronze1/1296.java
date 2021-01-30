package com.ssafy;

import java.util.Scanner;

public class Date {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		String name = sc.next();	
		int N = sc.nextInt();
		
		int l1 = check(name, 'L');
		int o1 = check(name, 'O');
		int v1 = check(name, 'V');
		int e1 = check(name, 'E');
		
		int max = -1;
		String answer = "";
		
		for(int i=0;i<N;i++) {
			String name2 = sc.next();
			
			int l = check(name2, 'L') + l1;
			int o = check(name2, 'O') + o1;
			int v = check(name2, 'V') + v1;
			int e = check(name2, 'E') + e1;
			
			int score = ((l+o)*(l+v)*(l+e)*(o+v)*(o+e)*(v+e))%100;
			
			if(max<score) {
				answer = name2;
				max = score;
			}
			else if(max==score) {
				if(answer.compareTo(name2)>0) {
					answer = name2;
				}
			}
		}
		System.out.println(answer);
	}
	
	public static int check(String name, char c) {
		int cnt=0;
		
		for(int i=0;i<name.length();i++) {
			if(name.charAt(i)==c)
				cnt++;
		}
		return cnt;
	}
}
