package com.ssafy;

import java.util.Scanner;

public class MovieDirector {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int num = 666;
		int cnt = 0;
		
		while(cnt<N) {
			if(Integer.toString(num++).contains("666"))
				cnt++;
		}
		System.out.println(num-1);
	}
}