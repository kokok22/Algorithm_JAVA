package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Omok {
	public static int[] dx = {1, -1, 0, 0, 1, -1, -1, 1};
	public static int[] dy = {0, 0, 1, -1, -1, 1, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			char[][] map = new char[N][N];
			
			for(int i=0;i<N;i++) {
				String s = br.readLine();
				for(int j=0;j<N;j++) {
					map[i][j] = s.charAt(j);
				}
			}
			String answer = "NO";
			boolean flag = false;
			for(int y=0;y<N;y++) {
				for(int x=0;x<N;x++) {
					if(map[y][x] == 'o') {
						for(int i=0;i<7;i+=2) {
							int cnt = 0;
							cnt += search(map,x,y,i);
							cnt += search(map,x,y,i+1);
							if(cnt>=4) {
								flag = true;
								break;
							}
						}
					}
					if(flag)
						break;
				}
				if(flag) {
					answer = "YES";
					break;
				}
			}
			bw.write("#"+(t+1)+" "+answer+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
	
	private static int search(char[][] map, int x, int y, int idx) {
		int result = 0;
		
		int nx = x+dx[idx];
		int ny = y+dy[idx];
		
		while(nx>=0 && nx<map[0].length && ny>=0 && ny<map.length && map[ny][nx] == 'o') {
			result++;
			nx += dx[idx];
			ny += dy[idx];
		}

		return result;
	}
}
