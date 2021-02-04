package com.ssafy;

import java.util.Arrays;
import java.util.Scanner;

public class Statistics {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] nums = new int[N];
		
		for(int i=0;i<N;i++) {
			nums[i] = sc.nextInt();
		}
		
		Arrays.sort(nums);
		
		int range = nums[N-1]-nums[0];
		int median = nums[N/2];
		
		int[] temp = new int[N]; 
		
		double sum = nums[0];
		
		int idx=0;
		temp[idx++]=nums[0];
		int max = 1;
		int cnt = 1;
		int pre = nums[0];
		
		for(int i=1;i<N;i++) {
			sum += nums[i];
			
			if(pre==nums[i]) {
				cnt += 1;
			}
			else {
				pre = nums[i];
				cnt = 1;
			}
			if(cnt>max) {
				max = cnt;
				idx = 0;
				temp[idx++] = nums[i];
			}
			else if(cnt==max)
				temp[idx++] = nums[i];
		}
		
		int[] modes = Arrays.copyOf(temp, idx);
		Arrays.sort(modes);
		
		int mode = modes[0];
		
		if(idx>1)
			mode = modes[1];
			
		System.out.printf("%d\n",Math.round(sum/N));
		System.out.printf("%d\n",median);
		System.out.printf("%d\n",mode);
		System.out.printf("%d",range);
	}
}
