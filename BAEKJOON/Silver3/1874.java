package com.ssafy;

import java.util.Scanner;

public class Stack {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] nums = new int[N];
		
		for(int i=0;i<N;i++)
			nums[i] = sc.nextInt();
		
		StringBuilder answer = new StringBuilder();
		int idx1 = 0;
		int idx2 = 0;
		int[] stack = new int[N];
		
		for(int i=1;i<N+1;i++) {
			stack[idx1++] = i;
			answer.append("+");
			while(true){
				if(idx1>0 && idx2 <N && stack[idx1-1]==nums[idx2]) {
					answer.append("-");
					idx2++;
					idx1--;
				}else
					break;
			}
		}		
		if(idx1!=0)
			System.out.println("NO");
		else {
			for(int i=0;i<answer.length();i++)
				System.out.println(answer.charAt(i));
		}
		sc.close();
	}
}
