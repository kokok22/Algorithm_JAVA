package com.ssafy;

import java.util.Scanner;

public class Othello {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		char[] color = {'B','V'};
		
		for(int t=0;t<T;t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			char[][] map = new char[N][N];
			
			for(int y=0;y<N;y++) {
				for(int x=0;x<N;x++) {
					map[y][x] = 'O';
				}
			}
			
			// 가운데 세팅
			map[N/2][N/2] = 'V';
			map[N/2][N/2-1] = 'B';
			map[N/2-1][N/2] = 'B';
			map[N/2-1][N/2-1] = 'V';
			
			for(int i=0;i<M;i++) {
				
				int y = sc.nextInt()-1;
				int x = sc.nextInt()-1;
				int c = sc.nextInt();
				
				map[y][x] = color[c-1];
				
				int cnt=1;
				while(true) {
					int chk = check(map,x-cnt,y-cnt,color[c%2]);
					if(chk==1)
						cnt++;
					else if(chk==0){
						for(int idx=1;idx<cnt;idx++)
							map[y-idx][x-idx] = color[c-1];
						cnt=1;
						break;
					}
					else {
						cnt=1;
						break;
					}
				}
				
				while(true) {
					int chk = check(map,x,y-cnt,color[c%2]);
					if(chk==1)
						cnt++;
					else if(chk==0) {
						for(int idx=1;idx<cnt;idx++)
							map[y-idx][x] = color[c-1];
						cnt=1;
						break;
					}
					else {
						cnt=1;
						break;
					}
				}
				
				while(true) {
					int chk = check(map,x+cnt,y-cnt,color[c%2]);
					if(chk == 1)
						cnt++;
					else if(chk==0){
						for(int idx=1;idx<cnt;idx++)
							map[y-idx][x+idx] = color[c-1];
						cnt=1;
						break;
					}
					else {
						cnt=1;
						break;
					}
				}
				
				while(true) {
					int chk = check(map,x-cnt,y,color[c%2]);
					if(chk==1)
						cnt++;
					else if(chk==0){
						for(int idx=1;idx<cnt;idx++)
							map[y][x-idx] = color[c-1];
						cnt=1;
						break;
					}
					else {
						cnt=1;
						break;
					}
				}
				
				while(true) {
					int chk = check(map,x+cnt,y,color[c%2]);
					if(chk==1)
						cnt++;
					else if(chk==0){
						for(int idx=1;idx<cnt;idx++)
							map[y][x+idx] = color[c-1];
						cnt=1;
						break;
					}
					else {
						cnt=1;
						break;
					}
				}
				
				while(true) {
					int chk = check(map,x+cnt,y+cnt,color[c%2]);
					if(chk==1)
						cnt++;
					else if(chk==0){
						for(int idx=1;idx<cnt;idx++)
							map[y+idx][x+idx] = color[c-1];
						cnt=1;
						break;
					}
					else {
						cnt=1;
						break;
					}
				}
				
				while(true) {
					int chk = check(map,x,y+cnt,color[c%2]);
					if(chk==1)
						cnt++;
					else if(chk==0){
						for(int idx=1;idx<cnt;idx++)
							map[y+idx][x] = color[c-1];
						cnt=1;
						break;
					}
					else {
						cnt=1;
						break;
					}
				}
				
				while(true) {
					int chk = check(map,x-cnt,y+cnt,color[c%2]);
					if(chk==1)
						cnt++;
					else if(chk==0){
						for(int idx=1;idx<cnt;idx++)
							map[y+idx][x-idx] = color[c-1];
						cnt=1;
						break;
					}
					else {
						cnt=1;
						break;
					}
				}
			}
			
			int b = 0;
			int w = 0;
			
			for(int y=0;y<N;y++) {
				for(int x=0;x<N;x++) {
					if(map[y][x]=='B')
						b +=1;
					else if(map[y][x]=='V')
						w +=1;
				}
			}
			
			System.out.printf("#%d %d %d\n",t+1,b,w);
		}	
	}
	
	
	public static int check(char[][] map, int x, int y, char color) {
		if(x<0 || y<0 || x>=map[1].length || y >=map[1].length) {
			return 2;
		}
		else {
			if(map[y][x] == color)
				return 1;
			else if(map[y][x] == 'O')
				return 2;
			return 0;
		}
		
	}
}
