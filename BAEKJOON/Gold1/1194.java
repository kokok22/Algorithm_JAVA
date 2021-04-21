import java.util.*;
import java.io.*;

public class Moon {
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[N][M];
		
		int start = 0;
		
		for(int y=0;y<N;y++) {
			String s = br.readLine();
			
			for(int x=0;x<M;x++) {
				map[y][x] = s.charAt(x);
				if(map[y][x]=='0')
					start = y*map[0].length+x;
			}
		}
		
		int cnt = bfs(map, start, new boolean[N][M][64]);
		
		bw.write(cnt+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static int bfs(char[][] map, int start, boolean[][][] chk) {
		Queue<Point> queue = new LinkedList<Point>();
		int y = start/map[0].length;
		int x = start%map[0].length;
		
		queue.offer(new Point(y, x));
		chk[y][x][0] = true;
		
		int result = 0;
		
		while(!queue.isEmpty()) {
			int n = queue.size();
			
			while(n-->0) {
				Point p = queue.poll();
				y = p.y;
				x = p.x;
				int key = p.key;
				
				if(map[y][x]=='1')
					return result;
				
				for(int i=0;i<4;i++) {
					int ny = y+dy[i];
					int nx = x+dx[i];
					
					if(ny>=0 && ny<map.length && nx>=0 && nx<map[0].length && map[ny][nx]!='#' && !chk[ny][nx][key]) {
						
						// 빈 곳, 시작점, 출구
						if(map[ny][nx]=='.' || map[ny][nx]=='0' || map[ny][nx] =='1') {
							chk[ny][nx][key] = true;
							queue.offer(new Point(ny, nx, p.key));
						}
						
						// 열쇠가 있는 곳
						else if(map[ny][nx]>='a' && map[ny][nx]<='f') {
							int nkey = key | (1<<(map[ny][nx]-'a'));
							chk[ny][nx][nkey] = true;
							queue.offer(new Point(ny, nx, nkey));
						}
						
						// 문이 있는 곳
						else if(map[ny][nx]>='A' && map[ny][nx]<='F') {
							int door = map[ny][nx]-'A';
							
							if((key & (1<<door))>0) {
								chk[ny][nx][key] = true;
								queue.offer(new Point(ny, nx, key));
							}
						}
					}
				}
			}
			result++;
		}
		
		return -1;
	}
}

class Point{
	int y, x;
	int key;
	
	public Point(int y, int x) {
		this.y = y;
		this.x = x;
		this.key = 0;
	}
	
	public Point(int y, int x, int key) {
		this.y = y;
		this.x = x;
		this.key = key;
	}
}