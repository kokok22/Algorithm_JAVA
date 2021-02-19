package com.ssafy.algorithm;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BreakingAndMovingWalls {
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		
		for(int y=0;y<N;y++) {
			String s = br.readLine();
			for(int x=0;x<M;x++)
				map[y][x] = Integer.parseInt(s.charAt(x)+"");
		}
		
		int cnt = bfs(map, new boolean[2][N][M]);
		
		bw.write(cnt+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	private static int bfs(int[][] map, boolean[][][] chk) {
		int cnt = 1;
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(new Node(0,0,0));
		chk[0][0][0] = true;
		
		while(!queue.isEmpty()) {
			int n = queue.size();
			
			while(n-->0) {
				Node nd = queue.poll();
				int x = nd.x;
				int y = nd.y;
				int state = nd.state;
				
				if(x==map[0].length-1 && y==map.length-1)
					return cnt;
				
				for(int i=0;i<4;i++) {
					int nx = x+dx[i];
					int ny = y+dy[i];
					
					if(nx>=0 && nx<map[0].length && ny>=0 && ny<map.length && !chk[state][ny][nx]) {
						if(map[ny][nx]==0) {
							chk[state][ny][nx] = true;
							queue.offer(new Node(nx, ny, state));
						}
						else if(map[ny][nx]==1 && state==0) {
							chk[1][ny][nx] = true;
							queue.offer(new Node(nx, ny, 1));
						}
						
					}
				}
				
			}
			cnt++;
		}
		return -1;
	}
}

class Node{
	int x;
	int y;
	int state;
	
	Node(int x, int y, int state){
		this.x = x;
		this.y = y;
		this.state = state;
	}
}
