package com.ssafy;

import java.util.Scanner;

public class Guard {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		int W = sc.nextInt();
		int H = sc.nextInt();
		
		int N = sc.nextInt();
		
		int[] pos = new int[N+1];
		int[] spot = new int[N+1];
		
		for(int i=0;i<N+1;i++) {
			pos[i] = sc.nextInt();
			spot[i] = sc.nextInt();
		}
		
		int sum = 0;
		
		for(int i=0;i<N;i++) {
			if(pos[i]==pos[N])
				sum += Math.abs(spot[i]-spot[N]);
			// 같은 방향(?)
			else if((pos[N]-1)/2==(pos[i]-1)/2) {
				// 가로
				if(pos[i]<=2) {
					sum += H;
					// 왼쪽
					if(spot[i]+spot[N]<W)
						sum += spot[i]+spot[N];
					// 오른쪽
					else
						sum += 2*W-spot[i]-spot[N];
				}
				// 세로
				else {
					sum += W;
					// 왼쪽
					if(spot[i]+spot[N]<H)
						sum += spot[i]+spot[N];
					// 오른쪽
					else
						sum += 2*H-spot[i]-spot[N];
				}
			}
			// 다른 방향
			else {
				// (1,3), (2,4) 
				if(Math.abs(pos[i]-pos[N])==2) {
					if(pos[i]%2==1)
						sum += spot[i]+spot[N];
					else
						sum += W+H-spot[i]-spot[N];
				}
				// (1,4), (2,3)
				else {
					if(pos[i]%2==0) {
						sum += spot[i];
						if(pos[N]>pos[i])
							sum += H-spot[N];
						else
							sum += W-spot[N];
					}
					else {
						sum += spot[N];
						if(pos[N]<pos[i])
							sum += H-spot[i];
						else
							sum += W-spot[i];
					}
				}
			}
		}
		System.out.println(sum);
	}
}

//	1
// 3 4
//	2
