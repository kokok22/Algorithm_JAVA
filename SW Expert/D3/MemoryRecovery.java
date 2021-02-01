package com.ssafy;

import java.util.Scanner;

public class MemoryRecovery {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=0;t<T;t++) {
			String num = sc.next();
			
			int[] bits = new int[num.length()];
			
			int cnt = 0;
			
			for(int i=0;i<num.length();i++) {
				int n = Integer.parseInt(num.substring(i,i+1));
				
				if( n != bits[i]) {
					cnt++;
					for(int j=i;j<num.length();j++) {
						bits[j]=n;
					}
				}
			}
			
			System.out.printf("#%d %d\n",t+1,cnt);
		}
		
	}
}
