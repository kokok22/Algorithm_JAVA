import java.util.*;
import java.io.*;

public class Monkey {
	// 0~3 : 4방 탐색, 4~11 : 말의 움직임
	public static int[] dx = {-1, 1, 0, 0, -2, -1, 1, 2, 2, 1, -1, -2};
	public static int[] dy = {0, 0, -1, 1, -1, -2, -2, -1, 1, 2, 2, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[H][W];
		
		for(int y=0;y<H;y++) {
			st = new StringTokenizer(br.readLine());
			for(int x=0;x<W;x++)
				map[y][x] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = bfs(map, K, new boolean[H][W][K+1]);

		bw.write(cnt+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	// chk는 3차원 배열로 마지막 차원에는 남은 말의 움직임 횟수가 들어간다.
	public static int bfs(int[][] map, int K, boolean[][][] chk) {
		int cnt = 0;
		
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(0,0, K));
		chk[0][0][K] = true;
		
		while(!queue.isEmpty()) {
			int n = queue.size();
			
			while(n-->0) {
				Point p = queue.poll();
				int x = p.x;
				int y = p.y;
				int k = p.k;
				
				if(y==map.length-1 && x==map[0].length-1)
					return cnt;
				
				// 4방 탐색
				for(int i=0;i<12;i++) {
					if(i>=4 && k==0)
						break;
					int nx = x+dx[i];
					int ny = y+dy[i];
					int nk = k;
					
					if(i>=4)
						nk--;
					
					if(ny>=0 && ny<map.length && nx>=0 && nx<map[0].length && !chk[ny][nx][nk] && map[ny][nx] != 1) {
						queue.offer(new Point(nx, ny, nk));
						chk[ny][nx][nk] = true;
					}
				}
			}	
			cnt++;
		}
		return -1;
	}
}

class Point{
	int x, y, k;
	
	public Point(int x, int y, int k) {
		this.x = x;
		this.y = y;
		this.k = k;
	}
}
