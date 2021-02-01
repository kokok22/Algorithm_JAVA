package com.ssafy;

import java.util.Scanner;

public class Switch {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] sw = new int[N];
		
		for(int i=0;i<N;i++)
			sw[i] = sc.nextInt();
		
		int cnt = sc.nextInt();
		
		for(int i=0;i<cnt;i++) {
			int gender = sc.nextInt();
			int num = sc.nextInt();
			
			if(gender == 1) {
				for(int j=num-1;j<N;j+=num)
					sw[j] = (sw[j]+1)%2;
			}
			else {
				int start = num-2;
				int end = num;
				sw[num-1] = (sw[num-1]+1)%2;
				while(start>=0 && end<N) {
					if(sw[start]==sw[end]) {
						sw[start] = (sw[start]+1)%2;
						sw[end] = (sw[end]+1)%2;
						start--;
						end++;
					}
					else
						break;
				}
			}
		}
		for(int i=0;i<sw.length;i++) {
			System.out.print(sw[i]+" ");
			if((i+1)%20==0)
				System.out.println();
		}
	}
}
