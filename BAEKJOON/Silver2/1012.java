package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class OrganicCabbage {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N][M];
			
			for(int i=0;i<K;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				map[y][x] = 1;
			}
			
			int cnt = 0;
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[i][j]==1) {
						dfs(map,j,i);
						cnt++;
					}
				}
			}
			bw.write(cnt+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
	
	private static void dfs(int[][] map, int x, int y) {
		if(x<0 || y<0 || y>=map.length || x>= map[0].length || map[y][x]==0)
			return;
		else
			map[y][x] = 0;
		
		dfs(map,x+1,y);
		dfs(map,x,y+1);
		dfs(map,x-1,y);
		dfs(map,x,y-1);
	}
}
