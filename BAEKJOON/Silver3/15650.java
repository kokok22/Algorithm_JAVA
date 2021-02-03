package com.ssafy.day01;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] arr = new int[N];
		
		for(int i=0;i<N;i++)
			arr[i] = i+1;
		
		combination(arr,new int[M],0,0);
		sc.close();
	}
	
	private static void combination(int[] arr, int[] sel, int k, int idx) {
		if(k==sel.length) {
			for(int i=0;i<sel.length;i++)
				System.out.print(sel[i]+" ");
			System.out.println();
			return;
		}
		
		for(int i=idx;i<arr.length;i++) {
			sel[k] = arr[i];
			combination(arr,sel,k+1,i+1);
		}
	}
}




