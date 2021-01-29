package com.ssafy;

import java.util.Scanner;

public class HarvestingCrops {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=0;t<T;t++) {
			int N = sc.nextInt();
			
			int[][]map = new int[N][N];
			for(int y=0;y<N;y++) {
				String line = sc.next();
				for(int x=0;x<N;x++) {
					map[y][x] = Integer.parseInt(line.substring(x,x+1));
				}
			}
			int center = N/2;
			int answer = 0;
			
			for(int y=0;y<N/2;y++) {
				for(int x=N/2-y;x<N/2+y+1;x++) {
					answer += map[y][x];
					answer += map[N-y-1][x];
				}
			}
			for(int x=0;x<N;x++) {
				answer += map[N/2][x];
			}
			
			System.out.printf("#%d %d\n",t+1,answer);
		}
	}
}

