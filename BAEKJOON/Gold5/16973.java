import java.util.*;
import java.io.*;

public class RectangularEscape {
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
			st = new StringTokenizer(br.readLine());
			for(int x=0;x<M;x++)
				map[y][x] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int s1 = Integer.parseInt(st.nextToken());
		int s2 = Integer.parseInt(st.nextToken());
		int f1 = Integer.parseInt(st.nextToken());
		int f2 = Integer.parseInt(st.nextToken());
		
		int cnt = bfs(map, H, W, s1-1, s2-1, f1-1, f2-1, new boolean[N][M]);
		
		bw.write(cnt+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static int bfs(int[][] map, int H, int W, int s1, int s2, int f1, int f2, boolean[][] chk) {
		int cnt = 0;
		
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(s1, s2));
		chk[s1][s2] = true;
		
		while(!queue.isEmpty()) {
			int n = queue.size();
			
			while(n-->0) {
				Point p = queue.poll();
				int x = p.x;
				int y = p.y;
				
				if(y==f1 && x==f2)
					return cnt;
				
				for(int i=0;i<4;i++) {
					int nx = x+dx[i];
					int ny = y+dy[i];
					
					if(nx>=0 && nx+W<=map[0].length && ny>=0 && ny+H<=map.length && !chk[ny][nx]
							& check(map, H, W, nx, ny, i)) {
						chk[ny][nx] = true;
						queue.offer(new Point(ny, nx));
					}
				}
			}
			cnt++;
		}
		
		return -1;
	}
	
	public static boolean check(int[][] map, int H, int W, int x, int y, int idx) {	
		switch(idx){
		// 왼쪽으로 이동
		case 0:
			for(int i=0;i<H;i++)
				if(map[y+i][x]==1)
					return false;
			break;
		
		// 오른쪽으로 이동
		case 1:
			for(int i=0;i<H;i++)
				if(map[y+i][x+W-1]==1)
					return false;
			break;
			
		// 위로 이동
		case 2:
			for(int i=0;i<W;i++)
				if(map[y][x+i]==1)
					return false;
			break;
			
		// 아래로 이동
		case 3:
			for(int i=0;i<W;i++)
				if(map[y+H-1][x+i]==1)
					return false;
			break;
		}
		
		return true;
	}
}

class Point{
	int y;
	int x;
	
	public Point(int y, int x) {
		this.x = x;
		this.y = y;
	}
}
