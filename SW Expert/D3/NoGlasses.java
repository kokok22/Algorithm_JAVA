package com.ssafy;

import java.util.Scanner;

public class NoGlasses {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		String g1 = "CEFGHIJKLMNSTUVWXYZ";
		String g2 = "ADOPQR";
		String g3 = "B";
		
		for(int t=0;t<T;t++) {
			String s1 = sc.next();
			String s2 = sc.next();
			String answer = "DIFF";
			
			if(s1.length() != s2.length()) {
				System.out.printf("#%d %s\n",t+1,answer);
				continue;
			}
			
			String ans1 = "";
			String ans2 = "";
			
			for(int i=0;i<s1.length();i++) {
				String c1 = s1.substring(i,i+1);
				String c2 = s2.substring(i,i+1);
				
				if(g1.contains(c1))
					ans1 += '1';
				else if(g2.contains(c1))
					ans1 += '2';
				else
					ans1 += '3';
				
				if(g1.contains(c2))
					ans2 += '1';
				else if(g2.contains(c2))
					ans2 += '2';
				else
					ans2 += '3';
			}
			
			if(ans1.equals(ans2))
				answer = "SAME";
			
			System.out.printf("#%d %s\n",t+1,answer);
		}
	}
}
