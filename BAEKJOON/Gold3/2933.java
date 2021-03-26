import java.io.*;
import java.util.*;

public class Mineral {
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
			for(int x=0;x<C;x++) {
				map[y][x] = s.charAt(x);
				
			}
		}
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			int y = map.length-Integer.parseInt(st.nextToken());
			
			// 왼 -> 오
			if(i%2==0) {
				for(int x=0;x<map[0].length;x++) {
					if(map[y][x]=='x') {
						map[y][x]='.';
						// 사라진 곳을 기준으로 4방 탐색 후 바닥과 연결되어 있는지 확인
						for(int j=0;j<4;j++) {
							int ny = y+dy[j];
							int nx = x+dx[j];
							
							if(ny>=0 && ny<map.length && nx>=0 && nx<map[0].length && map[ny][nx]=='x')
								bfs(map, ny, nx, new boolean[map.length][map[0].length]);
						}
						break;
					}
				}
			}
			else if(i%2==1) {
				for(int x=map[0].length-1;x>=0;x--) {
					if(map[y][x]=='x') {
						map[y][x]='.';
						// 사라진 곳을 기준으로 4방 탐색 후 바닥과 연결되어 있는지 확인
						for(int j=0;j<4;j++) {
							int ny = y+dy[j];
							int nx = x+dx[j];
							
							if(ny>=0 && ny<map.length && nx>=0 && nx<map[0].length && map[ny][nx]=='x')
								bfs(map, ny, nx, new boolean[map.length][map[0].length]);
						}
						break;
					}
				}
			}
		}
		
		// 모양 출력
		for(int y=0;y<map.length;y++) {
			for(int x=0;x<map[0].length;x++)
				bw.write(map[y][x]+"");
			bw.write("\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
	
	// 원상 복구
	public static void recover(char[][] map, ArrayList<Integer> arr) {
		for(int i=0;i<arr.size();i++) {
			int idx = arr.get(i);
			int y = idx/map[0].length;
			int x = idx%map[0].length;
			
			map[y][x] = 'x';
		}
	}
	
	
	public static void bfs(char[][] map, int y, int x, boolean[][] chk) {
		Queue<Integer> queue = new LinkedList<Integer>();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		queue.offer(y*map[0].length+x);
		arr.add(y*map[0].length+x);
		chk[y][x] = true;
		
		
		
		while(!queue.isEmpty()) {
			int n = queue.size();
			
			while(n-->0) {
				int idx = queue.poll();
				y = idx/map[0].length;
				x = idx%map[0].length;
				
				map[y][x] = 'o';
				
				if(y==map.length-1) {
					recover(map, arr);
					return;
				}
					
				for(int i=0;i<4;i++) {
					int ny = y+dy[i];
					int nx = x+dx[i];
					
					if(ny>=0 && ny<map.length && nx>=0 && nx<map[0].length && map[ny][nx]=='x' && !chk[ny][nx]) {
						chk[ny][nx] = true;
						queue.offer(ny*map[0].length+nx);
						arr.add(ny*map[0].length+nx);
					}
				}
			}
		}
		// 내려가야 하는 높이 측정
		
		int down = Integer.MAX_VALUE;
		
		for(int i=0;i<map[0].length;i++) {
			int idx = map.length-1;
			for(int j=map.length-1;j>=0;j--) {
				if(map[j][i]=='x')
					idx = j-1;
				if(map[j][i]=='o') {
					down = Math.min(down, idx-j);
				}
			}
		}
		
		for(int i=0;i<map[0].length;i++) {
			for(int j=map.length-1;j>=0;j--) {
				if(map[j][i]=='o') {
					map[j+down][i] = 'x';
					map[j][i] = '.';
				}
			}
		}

	}
}
