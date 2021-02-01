package com.ssafy;

import java.util.Scanner;

public class Average {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] score = new int[N];
		
		double max = 0;
		for(int i=0;i<N;i++) {
			score[i] = sc.nextInt();
			if(score[i]>max)
				max = score[i];
		}
		
		double total = 0;
		for(int i=0;i<N;i++)
			total += score[i]/max*100;
		
		System.out.println(total/N);
	}
}
