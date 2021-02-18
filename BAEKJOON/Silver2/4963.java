package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class NumberOfIsland {
	public static int[] dx = {-1,0,1,-1,1,-1,0,1};
	public static int[] dy = {-1,-1,-1,0,0,1,1,1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			if(w==0 && h==0)
				break;
			
			int[][] map = new int[h][w];
			
			for(int y=0;y<h;y++) {
				st = new StringTokenizer(br.readLine());
				for(int x=0;x<w;x++)
					map[y][x] = Integer.parseInt(st.nextToken());
			}
			
			int answer = 0;
			
			for(int y=0;y<h;y++) {
				for(int x=0;x<w;x++) {
					if(map[y][x]==1) {
						dfs(map,y,x);
						answer++;
					}
				}
			}
			bw.write(answer+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
	
	private static void dfs(int[][] map, int y, int x) {
		if(x<0 || x>map[0].length-1 || y<0 || y>map.length-1 || map[y][x]==0)
			return;
		
		map[y][x] = 0;
		
		for(int i=0;i<8;i++)
			dfs(map,y+dy[i],x+dx[i]);
		
	}
}
