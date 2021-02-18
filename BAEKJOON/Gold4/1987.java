package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Alphabet {
	public static int[] dx = {0,0,-1,1};
	public static int[] dy = {-1,1,0,0};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[R][C];
		
		for(int y=0;y<R;y++) {
			String s = br.readLine();
			for(int x=0;x<C;x++)
				map[y][x] = s.charAt(x);
		}
		
		int cnt = dfs(map, new boolean[26], new boolean[R][C], 0, 0, 1);
		
		bw.write(cnt+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	private static int dfs(char[][] map, boolean[] chk, boolean[][] visit, int x, int y, int depth) {
		if(x<0 || x>=map[0].length || y<0 || y>=map.length || visit[y][x] || chk[map[y][x]-'A'])
			return depth-1;
		
		chk[map[y][x]-'A'] = true;
		visit[y][x] = true;
		
		int answer = 0;
		for(int i=0;i<4;i++)
			answer = Math.max(answer, dfs(map, chk, visit, x+dx[i], y+dy[i], depth+1));
		
		chk[map[y][x]-'A'] = false;
		visit[y][x] = false;
		
		return answer;
	}
}
