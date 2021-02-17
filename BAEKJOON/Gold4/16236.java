package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BabyShark {
	public static int[] dx = {0,-1,1,0};
	public static int[] dy = {-1,0,0,1};
	public static int idx = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int size = 2;
		
		for(int y=0;y<N;y++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int x=0;x<N;x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				if(map[y][x] == 9)
					idx = y*N+x;
			}
		}
		int answer = 0;
		int k = 0;
		while(check(map, size)) {
			int ans = bfs(map, idx, size);
			if(ans==-1)
				break;
			answer += ans;
			k++;
			if(k==size && size<9) {		// size가 9 초과이면 현재 아기고래의 위치인 9도 잡아먹을 대상으로 판단하여 무한루프에 빠짐
				size++;
				k=0;
			}
		}
		
		bw.write(answer+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	private static int bfs(int[][] map, int spot, int size) {
		int cnt = 0;
		
		boolean[][] chk = new boolean[map.length][map.length];
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(new Node(spot,9));
		map[spot/map.length][spot%map.length] = 0;
		chk[idx/map.length][idx%map.length] = true;
		int temp_idx = -1;
		
		while(!queue.isEmpty()) {
			int n = queue.size();
			
			while(n-->0) {
				Node temp = queue.poll();
				
				// 0이 아닌, size보다 작은 값을 가지고 있는 경우(이것때문에 9가 넘어가면 무한루프에 빠지게 된다.)
				if(temp.state > 0 && temp.state < size) {
					if(temp_idx==-1)		// 동일 레벨에서 아직 잡아먹은 적이 없는 경우
						temp_idx = temp.pos;
					else {					// 동일 레벨에서 잡아먹은 적이 있는 경우, 우선순위를 고려해서 idx를 정한다.
						if(temp_idx/map.length>temp.pos/map.length)
							temp_idx = temp.pos;
						else if(temp_idx/map.length==temp.pos/map.length && temp_idx%map.length > temp.pos%map.length)
							temp_idx = temp.pos;
					}
				}
				for(int i=0;i<4;i++){	// 4방 탐색
					int ny = temp.pos/map.length+dy[i];
					int nx = temp.pos%map.length+dx[i];
					
					// 이미 방문했던 곳은 경로 낭비이기 때문에 다시 가지 않는다.
					if(nx>=0 && nx<map.length && ny>=0 && ny<map.length && map[ny][nx] <= size && !chk[ny][nx]) {
						queue.offer(new Node(ny*map.length+nx, map[ny][nx]));
						chk[ny][nx] = true;
					}
				}
			}
			if(temp_idx!=-1) {			// 잡아 먹은 경우
				idx = temp_idx;
				map[idx/map.length][idx%map.length] = 0;
				return cnt;
			}
			cnt++;
		}
		return -1;						// 잡아먹을 대상은 있지만 갈 수 없는 경우
	}
	
	private static boolean check(int[][] map, int size) {		// 잡아먹을 대상이 있는지 체크
		for(int y=0;y<map.length;y++) {
			for(int x=0;x<map[0].length;x++) {
				if(map[y][x]>0 && map[y][x]<size)
					return true;
			}
		}
		return false;
	}
}

class Node{
	int pos;
	int state;
	
	Node(int pos, int state){
		this.pos = pos;
		this.state = state;
	}
}
