package com.ssafy;

import java.util.Scanner;

public class CommandPrompt {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
	
		int N = sc.nextInt();
		String[] files = new String[N];
		
		for(int i=0;i<N;i++) {
			files[i] = sc.next();
		}
		
		String[] answer = new String[files[0].length()];
		
		for(int j=0;j<files[0].length();j++) {
			answer[j] = files[0].substring(j,j+1);
			for(int i=1;i<N;i++) {
				if(!files[i].substring(j,j+1).equals(answer[j])){
					answer[j] = "?";
					break;
				}
			}
		}
		
		for(String ans : answer)
			System.out.print(ans);
	}
}
