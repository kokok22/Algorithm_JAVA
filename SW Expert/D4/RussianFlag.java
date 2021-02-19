package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class RussianFlag {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			char[][] map = new char[N][M];
			int[][] cnt = new int[N][3];
			
			for(int y=0;y<N;y++) {
				String s = br.readLine();
				for(int x=0;x<M;x++) {
					map[y][x] = s.charAt(x);
					
					if(map[y][x] == 'W')
						cnt[y][0] += 1;
					else if(map[y][x]=='B')
						cnt[y][1] += 1;
					else
						cnt[y][2] += 1;
				}
			}
			
			int answer = search(map, cnt);
			
			bw.write("#"+(t+1)+" "+answer+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
	
	private static int search(char[][] map, int[][] cnt) {
		int answer = Integer.MAX_VALUE;
		
		 for(int i=1;i<map.length-1;i++) {
			 for(int j=1;j<map.length-i;j++) {
				 int k=map.length-i-j;
				 int n = 0;
				 
				 for(int y=0;y<map.length;y++) {
					 if(y<i)
						 n += +cnt[y][1]+cnt[y][2];
					 else if(y<i+j)
						 n += +cnt[y][0]+cnt[y][2];
					 else
						 n += cnt[y][0]+cnt[y][1];
				 }
				 answer = Math.min(answer, n);
			 }
		 }
		return answer;
	}
}
