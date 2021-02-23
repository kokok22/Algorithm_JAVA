import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato {
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Node[][] map = new Node[M][N];
		
		int start = -1;
		
		for(int y=0;y<M;y++) {
			st = new StringTokenizer(br.readLine());
			
			for(int x=0;x<N;x++) {
				map[y][x] = new Node(Integer.parseInt(st.nextToken()),0);
				if(start==-1 && map[y][x].state==1)
					start = y*map[0].length+x;
			}
		}
		
		int cnt = -1;
		if(start!=-1)
			cnt = bfs(map, start, new boolean[M][N]);
		bw.write(cnt+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	private static int bfs(Node[][] map, int start, boolean[][] chk) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		chk[start/map[0].length][start%map[0].length] = true;
		
		while(!queue.isEmpty()) {
			int n = queue.size();
			
			while(n-->0) {
				int idx = queue.poll();
				int y = idx/map[0].length;
				int x = idx%map[0].length;
				
				for(int i=0;i<4;i++) {
					int ny = y+dy[i];
					int nx = x+dx[i];
					
					if(nx>=0 && nx<map[0].length && ny>=0 && ny<map.length) {
						
						if(map[ny][nx].state==0) {
							map[ny][nx].day = map[y][x].day +1;
							map[ny][nx].state = 1;
							queue.offer(ny*map[0].length+nx);
							chk[ny][nx] = true;
							
						}
						
						else if(map[ny][nx].state==1 &&
								(map[ny][nx].day == 0 || map[ny][nx].day > map[y][x].day+1)) {
							if(map[ny][nx].day!=0)
								map[ny][nx].day = map[y][x].day+1;
							else if(chk[ny][nx])
								continue;
							queue.offer(ny*map[0].length+nx);
							chk[ny][nx] = true;
						}	
					}
				}
			}
		}
		return check(map);
	}
	
	private static int check(Node[][] map) {
		int day = 0;
		
		for(int y=0;y<map.length;y++) {
			for(int x=0;x<map[0].length;x++) {
				if(map[y][x].state==0)
					return -1;
				day = Math.max(day, map[y][x].day);
			}
		}
		return day;
	}
}

class Node{
	int state;
	int day;
	
	Node(int state, int day){
		this.state = state;
		this.day = day;
	}
}
