package com.ssafy;

import java.util.Scanner;

public class CreatePwd {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			int N = sc.nextInt();
			int[] nums = new int[8];
		
			for(int i=0;i<8;i++)
				nums[i] = sc.nextInt();
			
			int idx=0;
			int minus = 1;
			while(true) {
				nums[idx] -= minus;
				if(nums[idx]<=0) {
					nums[idx] = 0;
					idx = (idx+1)%8;
					break;
				}
				else {
					idx = (idx+1)%8;
					minus = minus%5+1;
				}
			}
			System.out.printf("#%d ",N);
			for(int i=0;i<8;i++)
				System.out.print(nums[(i+idx)%8]+" ");
			System.out.println();
		}
		sc.close();
	}
}
