package com.ssafy;

import java.util.Arrays;
import java.util.Scanner;

public class Flatten {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		for(int i=0;i<10;i++) {
			int dump = sc.nextInt();
			int[] box = new int[100];
			
			// 박스 채우기
			for(int j=0;j<100;j++)
				box[j] = sc.nextInt();
			
			for(int j=0;j<dump;j++) {
				Arrays.sort(box);
				box[0]++;
				box[99]--;
			}
			
			Arrays.sort(box);
			System.out.printf("#%d %d\n",i+1,box[99]-box[0]);
		}
		
		sc.close();
	}
}
