package com.ssafy;

import java.util.Scanner;

public class Prime {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		int[] check = new int[N+1];
		for(int i=3;i<N+1;i+=2)
			check[i] = i;
		check[2] = 2;
		
		for(int i=3;i<Math.sqrt(N)+1;i+=2) {
			if(check[i]!=0) {
				for(int j=i*2;j<N+1;j+=i) {
					check[j]=0;
				}
			}
		}
		for(int i=M;i<N+1;i++) {
			if(check[i]!=0)
				System.out.println(i);
		}
		sc.close();
	}
}
