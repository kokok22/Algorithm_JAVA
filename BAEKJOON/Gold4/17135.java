package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class CastleDefence {
	public static int[] dx = {-1,1,0};
	public static int[] dy = {0,0,-1};
	public static int D;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N+1][M];
		
		for(int y=0;y<N;y++) {
			st = new StringTokenizer(br.readLine());
			for(int x=0;x<M;x++)
				map[y][x] = Integer.parseInt(st.nextToken());
		}
		
		int kill = combination(map, new int[3], 0, 0 );
		
		bw.write(kill+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	private static int combination(int[][] map, int[] sel, int k, int idx) {
		if(k==sel.length) {
			// array 복사
			int[][] temp = new int[map.length][map[0].length];
			int all = 0;
			
			for(int y=0;y<map.length;y++) {
				temp[y] = map[y].clone();
				for(int x=0;x<map[0].length;x++) {
					if(temp[y][x] == 1)
						all++;
				}
			}
			
			// 궁수의 위치 배치
			for(int i=0;i<k;i++)
				temp[map.length-1][sel[i]] = 2;
			
			// 게임 진행 중
			int cnt = 0;
			while(check(temp)) {
				cnt+= bfs(temp, sel);
				move(temp);
			}
			
			return cnt;
		}
		
		int answer = 0;
		for(int i=idx;i<map[0].length;i++) {
			sel[k] = i;
			answer = Math.max(answer, combination(map, sel, k+1, i+1));
		}
		return answer;
	}
	
	// 제거할 적 위치 선정
	private static int bfs(int[][] map, int[] sel) {
		ArrayList<Integer> p = new ArrayList<Integer>();
		int answer = 0;
		
		for(int i:sel) {
			int ny = map.length-2;
			int nx = i;
			
			int cnt = 1;
			Queue<Node> queue = new LinkedList<Node>();
			queue.offer(new Node(map[ny][nx],nx,ny));
			int idx = -1;
			
			boolean[][] chk = new boolean[map.length][map[0].length];
			
			while(!queue.isEmpty()) {
				int size = queue.size();
				
				while(size-->0) {
					Node n = queue.poll();
					chk[n.y][n.x] = true;
					
					if(n.state == 1){
						if(idx==-1 || idx%map[0].length > n.x)
							idx = n.y*map[0].length+n.x;
						continue;
					}
					
					for(int j=0;j<3;j++) {
						ny = n.y+dy[j];
						nx = n.x+dx[j];
						
						if(nx>=0 && nx<map[0].length && ny>=0 && !chk[ny][nx])
							queue.offer(new Node(map[ny][nx], nx, ny));
					}
				}
				if(idx!=-1) {
					p.add(idx);
					break;
				}
				if(++cnt>D)
					break;
			}	
		}
		for(int i=0;i<p.size();i++) {
			int ny = p.get(i)/map[0].length;
			int nx = p.get(i)%map[0].length;
			
			if(map[ny][nx]==1) {
				answer++;
				map[ny][nx] = 0;
			}
		}
		
		return answer;
	}
	
	// 적들이 이동
	private static void move(int[][] map) {
		for(int y=map.length-3;y>=-1;y--) {
			for(int x=0;x<map[0].length;x++) {
				if(y==-1)
					map[y+1][x] = 0;
				else
					map[y+1][x] = map[y][x];
			}
		}
	}
	
	// 적이 하나도 없으면
	private static boolean check(int[][] map) {				
		for(int y=0;y<map.length-1;y++) {
			for(int x=0;x<map[0].length;x++) {
				if(map[y][x] == 1)
					return true;
			}
		}
		
		return false;
	}
	
}

class Node{
	int state;
	int x;
	int y;
	
	Node(int state, int x, int y){
		this.state = state;
		this.x = x;
		this.y = y;
	}
}
