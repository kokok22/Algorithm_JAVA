package com.ssafy.algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class MakingColoredPaper {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		
		for(int y=0;y<N;y++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int x=0;x<N;x++)
				map[y][x] = Integer.parseInt(st.nextToken());
		}
				
		int[] answer = new int[2];
		
		answer =  bfs(map, 0, N, 0, N);
		
		bw.write(answer[0]+"\n");
		bw.write(answer[1]+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	private static int[] bfs(int[][] map, int x1, int x2, int y1, int y2) {
		int[] answer = new int[2];
		
		int num = check(map, x1, x2, y1, y2);
		
		if(num!=-1)
			answer[num] += 1;
		else {			
			int[] temp1 = bfs(map, x1, (x1+x2)/2, y1, (y1+y2)/2);
			int[] temp2 = bfs(map, (x1+x2)/2, x2, y1, (y1+y2)/2);
			int[] temp3 = bfs(map, x1, (x1+x2)/2, (y1+y2)/2, y2);
			int[] temp4 = bfs(map, (x1+x2)/2, x2, (y1+y2)/2, y2);
			
			answer[0] += temp1[0] + temp2[0] + temp3[0] + temp4[0];
			answer[1] += temp1[1] + temp2[1] + temp3[1] + temp4[1];
		}
		
		return answer;
	}
	
	private static int check(int[][] map, int x1, int x2, int y1, int y2) {
		int pre = map[y1][x1];
		
		for(int y=y1;y<y2;y++) {
			for(int x=x1;x<x2;x++) {
				if(pre!=map[y][x])
					return -1;
			}
		}
		return pre;
	}
}
