package com.ssafy.algorithm;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class CreateBridge {
	public static int label = 2;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		
		// map 생성
		for(int y=0;y<N;y++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int x=0;x<N;x++)
				map[y][x] = Integer.parseInt(st.nextToken());
		}
		
		// 섬 구분해주기, 각 섬별로 다른 라벨링을 해준다.
		for(int y=0;y<N;y++) {
			for(int x=0;x<N;x++) {
				if(map[y][x] == 1) {
					dfs(map,x,y);
					label++;
				}
			}
		}
		
		// 두 섬의 최단거리 탐색
		int answer = Integer.MAX_VALUE;
		boolean[][] visit = new boolean[N][N];
		
		for(int y=0;y<N;y++) {
			for(int x=0;x<N;x++) {
				if(map[y][x]!=0) {
					boolean flag = false;
					
					for(int i=0;i<4;i++) {
						int nx = x+dx[i];
						int ny = y+dy[i];
						if(nx>=0 && nx<map[0].length && ny>=0 && ny<map.length && map[ny][nx] == 0)
							flag = true;
					}
					
					if(flag)
						answer = Math.min(answer, bfs(map,x,y,map[y][x], visit));
				}
			}
		}
		bw.write(answer+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	private static int bfs(int[][]map, int x, int y, int value, boolean[][] visit) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(y*map[0].length+x);
		int cnt = 0;
		for(int i=0;i<visit.length;i++)
			Arrays.fill(visit[i], false);
		
		while(!queue.isEmpty()) {
			int n = queue.size();
			
			while(n-->0) {
				int idx = queue.poll();
				
				for(int i=0;i<4;i++) {
					int ny = idx/map[0].length+dy[i];
					int nx = idx%map[0].length+dx[i];
					
					if(nx>=0 && nx<map[0].length && ny>=0 && ny<map.length && map[ny][nx] != value && !visit[ny][nx]) {
						if(map[ny][nx]!=0)
							return cnt;
						queue.offer(ny*map[0].length+nx);
						visit[ny][nx] = true;
					}		
				}
			}
			cnt++;
		}
		return Integer.MAX_VALUE;
		
	}
	
	// 섬 구분해주기
	private static void dfs(int[][] map, int x, int y) {
		if(x<0 || x>map[0].length-1 || y<0 || y>map.length-1 || map[y][x]!=1)
			return;
		
		map[y][x] = label;
		
		for(int i=0;i<4;i++)
			dfs(map, x+dx[i], y+dy[i]);
	}
}