package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class RotateArray1 {
	public static int[] dx = {0, 1, 0, -1};
	public static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<R;i++) {
			for(int s=0;s<Math.min(N,M)/2;s++) {
				swap(map, s);
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++)
				bw.write(map[i][j]+" ");
			bw.write("\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
	
	private static void swap(int[][] map, int line) {
		int x = line;
		int y = line;
		int idx = 0;
		
		while(true) {
			int nx = x + dx[idx];
			int ny = y + dy[idx];
			
			if(!(nx>=line && nx<map[0].length-line && ny>=line && ny<map.length-line)) {
				nx = x + dx[++idx];
				ny = y + dy[idx];
			}
			int temp = map[ny][nx];
			map[ny][nx] = map[line][line];
			map[line][line] = temp;
			
			x = nx;
			y = ny;
			
			if(x==line && y==line)
				break;
		}
	}
}
