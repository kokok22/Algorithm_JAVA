package com.ssafy;

import java.util.Scanner;

public class StudyingVocabulary {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		int max=0;
		char answer = '\0';
		String strs = sc.next().toUpperCase();
		int cnt;
		
		String temp = "";
		
		for(int i=0;i<strs.length();i++) {
			char c = strs.charAt(i);
			cnt=0;
			
			if(temp.contains(c+""))
				continue;
			else
				temp += c;
			
			for(int j=i;j<strs.length();j++) {
				if(c == strs.charAt(j))
					cnt++;
			}
			if(cnt>max) {
				answer = c;
				max = cnt;
			}
			else if(cnt==max)
				answer = '?';
		}
		
		System.out.println(answer);
	}
}
