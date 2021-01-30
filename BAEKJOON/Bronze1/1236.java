package com.ssafy;

import java.util.Scanner;

public class ProtectingTheCastle {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		char[][] map = new char[N][M];
		
		int cnt1 = 0;
		for(int y=0;y<N;y++) {
			String line = sc.next();
			if(!line.contains("X"))
				cnt1++;
			for(int x=0;x<M;x++) {
				map[y][x] = line.charAt(x);
			}
		}
		
		int cnt2 = 0;
		for(int x=0;x<M;x++) {
			boolean flag = false;
			for(int y=0;y<N;y++) {
				if(map[y][x]=='X') {
					flag = true;
					break;
				}
			}
			if(!flag)
				cnt2++;
		}
		
		if(cnt1<cnt2)
			System.out.println(cnt2);
		else
			System.out.println(cnt1);
	}
}
