package com.ssafy;

import java.util.Arrays;
import java.util.Scanner;

public class FindNum {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] A = new int[N];
		
		for(int i=0;i<N;i++)
			A[i] = sc.nextInt();
		
		Arrays.sort(A);
		
		int M = sc.nextInt();
		
		for(int i=0;i<M;i++) {
			int num = sc.nextInt();
			int answer = 0;
			int start = 0;
			int end = N-1;
			
			while(start<=end) {
				int middle = (start+end)/2;
				if(A[middle]==num) {
					answer = 1;
					break;
				}else if(A[middle] < num)
					start = middle+1;
				else
					end = middle-1;
			}
			System.out.println(answer);
		}
	}
}
