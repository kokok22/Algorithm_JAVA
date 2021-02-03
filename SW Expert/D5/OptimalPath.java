package com.ssafy.day01;

import java.util.Scanner;

// 중복 o , 순열, 시작과 끝 고정
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=0;t<T;t++) {
			int N = sc.nextInt();
			int[][] spot = new int[N+2][N+2];
			
			for(int i=0;i<N+2;i++) {
				spot[0][i] = sc.nextInt();
				spot[1][i] = sc.nextInt();
			}
			
			int[] sel = new int[N+2];
			sel[0] = 0;
			
			int num = permutation(spot, 1, new boolean[N+2], new int[N+2]);
			
			System.out.printf("#%d %d\n",t+1,num);

		}
	}
	
	private static int permutation(int[][] spot, int k, boolean[] v, int[] sel) {
		if(k==sel.length-1) {
			sel[k] = 1;
			int d=0;
			int pre_x = spot[0][0];
			int pre_y = spot[1][0];
			
			for(int i=1;i<sel.length;i++) {
				int idx = sel[i];
				d += Math.abs(pre_x-spot[0][idx]) + Math.abs(pre_y-spot[1][idx]);
				pre_x = spot[0][idx];
				pre_y = spot[1][idx];
			}
			return d;
		}
		
		int min = 20000;
		for(int i=2;i<spot.length;i++) {
			if(!v[i]) {
				v[i]=true;
				sel[k] = i;
				int d = permutation(spot, k+1, v, sel);
				if(d<min)
					min = d;
				v[i]=false;
			}
		}
		return min;
	}
}
