package com.ssafy;

import java.util.Scanner;

public class SquareRoom {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=0;t<T;t++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++)
					map[i][j] = sc.nextInt();
			}
			
			int[] answer = {0,-1};
			
			for(int y=0;y<N;y++) {
				for(int x=0;x<N;x++) {
					int cnt = search(map,x,y);
					if(cnt> answer[1]) {
						answer[0] = map[y][x];
						answer[1] = cnt;
					}else if(cnt == answer[1] && map[y][x] < answer[0]) {
						answer[0] = map[y][x];
					}
				}
			}
			
			System.out.printf("#%d %d %d\n",t+1, answer[0], answer[1]);
			
		}
	}
	
	private static int search(int[][] map, int x, int y) {
		int max = 0;
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx>=0 && nx<map.length && ny>=0 && ny<map.length && map[y][x]+1 == map[ny][nx]){			
				int n = search(map, nx,ny);
				if(n>max)
					max = n;
			}
		}
		return 1+max; 
	}
}
