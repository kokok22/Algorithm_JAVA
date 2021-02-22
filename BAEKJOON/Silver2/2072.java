package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Omok {
	public static int[] dx = {-1, 1, 0, 0, -1, 1, 1, -1};
	public static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[20][20];
		
		int answer = -1;
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			map[y][x] = i%2+1;		// 1이면 흑, 2이면 백
			
			if(i>=8) {
				if(check(map, y, x, map[y][x])) {
					answer = i+1;
					break;
				}
			}
		}
		bw.write(answer+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	private static boolean check(int[][] map, int y, int x, int pre) {
		for(int i=0;i<8;i+=2) {
			int cnt = 1;
			int ny = y+dy[i];
			int nx = x+dx[i];
			
			while(true) {
				if(ny>0 && nx>0 && nx<=19 && ny<=19 && map[ny][nx]==pre) {
					cnt++;
					nx += dx[i];
					ny += dy[i];
				}else
					break;
			}
			
			ny = y+dy[i+1];
			nx = x+dx[i+1];
			
			while(true) {
				if(ny>0 && nx>0 && nx<=19 && ny<=19 && map[ny][nx]==pre) {
					cnt++;
					nx += dx[i+1];
					ny += dy[i+1];
				}else
					break;
			}
			if(cnt==5)
				return true;
		}
		return false;
	}
}
