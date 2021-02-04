package com.ssafy;

import java.util.Scanner;

public class PrinterQueue {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=0;t<T;t++) {
			int N = sc.nextInt();
			int sel = sc.nextInt();
			int[] queue = new int[N];
			
			for(int i=0;i<N;i++)
				queue[i] = sc.nextInt();
			
			int del = -1;
			int answer = 0;
			
			while(queue[sel]!=0) {
				int max = 0;
				int idx = 0;
				
				for(int i=0;i<N;i++) {
					int tmp = (i+del+1)%N;
					if(max < queue[tmp]) {
						max = queue[tmp];
						idx = tmp;
					}
				}
				del = idx;
				queue[del]=0;
				answer++;
			}
			System.out.println(answer);
		}
		sc.close();
	}
}
