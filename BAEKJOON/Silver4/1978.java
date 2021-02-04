package com.ssafy;

import java.util.Scanner;

public class CountPrime {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int max = 0;
		int[] nums = new int[N];
		
		for(int i=0;i<N;i++) {
			nums[i] = sc.nextInt();
			if(max<nums[i])
				max = nums[i];
		}
		
		int[] prime = new int[max+1];
		prime[2] = 2;
		
		for(int i=3;i<max+1;i+=2) {
			prime[i] = i;
		}
		
		for(int i=3;i<Math.sqrt(max)+1;i++) {
			if(prime[i]!= 0) {
				for(int j=i*2;j<max+1;j+=i)
					prime[j]=0;
			}
		}
		
		int cnt = 0;
		
		for(int num : nums) {
			if(prime[num]!=0)
				cnt++;
		}
		System.out.println(cnt);
		sc.close();
	}
}
