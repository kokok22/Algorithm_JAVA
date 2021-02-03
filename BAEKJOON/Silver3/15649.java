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
		
		permutation(arr,new int[M], new boolean[N], 0);
		sc.close();
	}
	
	private static void permutation(int[] arr, int[] sel, boolean[] v, int k) {
		if(k==sel.length) {
			for(int i=0;i<sel.length;i++)
				System.out.print(sel[i]+" ");
			System.out.println();
			return;
		}
		
		for(int i=0;i<arr.length;i++) {
			if(!v[i]) {
				v[i]=true;
				sel[k]=arr[i];
				permutation(arr,sel,v,k+1);
				v[i]=false;
			}
		}
	}
}




