package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 최대값과 최소값을 범위로 하고 모든 값을 대상으로 완전탐색을 진행한다.
public class MineCraft {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
				min = Math.min(min, map[i][j]);
			}
		}
		
		int cnt = Integer.MAX_VALUE;
		int height = 0;
		
		for(int i=min;i<=max;i++) {
			int temp_cnt = 0;
			int temp_b = B;
			
			for(int y=0;y<N;y++) {
				for(int x=0;x<M;x++) {
					if(map[y][x]<i) {
						temp_b -= i-map[y][x];
						temp_cnt += i-map[y][x];
					}
					else if(map[y][x]>i) {
						temp_b += map[y][x]-i;
						temp_cnt += (map[y][x]-i)*2;
					}
				}
			}
			if(temp_b<0)
				continue;
			if(cnt>=temp_cnt) {
				cnt = temp_cnt;
				height = i;
			}
		}
		bw.write(cnt+" "+height);
		bw.flush();
		bw.close();
		br.close();
	}
}
