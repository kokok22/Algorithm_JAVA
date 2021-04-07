import java.util.*;
import java.io.*;

public class AlgoSpot {
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		
		for(int y=0;y<N;y++) {
			String s= br.readLine();
			for(int x=0;x<M;x++)
				map[y][x] = Integer.parseInt(s.charAt(x)+"");
		}
		
		int cnt = bfs(map, new boolean[N][M], new int[N][M]);
		
		bw.write(cnt+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static int bfs(int[][] map, boolean[][] chk, int[][] minValue) {
		int result = Integer.MAX_VALUE;
		
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(0,0,0));
		
		while(!queue.isEmpty()) {
			int n = queue.size();
			
			while(n-->0) {
				Point p = queue.poll();
				int y = p.y;
				int x = p.x;
				int cnt = p.cnt;
				
				if(y==map.length-1 &&  x==map[0].length-1)
					result = Math.min(result, cnt);
				
				for(int i=0;i<4;i++) {
					int ny = y+dy[i];
					int nx = x+dx[i];
					int ncnt = cnt;
					
					if(ny>=0 && ny<map.length && nx>=0 && nx<map[0].length) {
						if(map[ny][nx]==1)
							ncnt++;
						
						// 아직 방문 안한 경우
						if(!chk[ny][nx]) {
							chk[ny][nx] = true;
							queue.offer(new Point(ny, nx, ncnt));
							minValue[ny][nx] = ncnt;
						}
						
						// 방문 했던 경우
						else {
							if(minValue[ny][nx]>ncnt) {
								queue.offer(new Point(ny, nx, ncnt));
								minValue[ny][nx] = ncnt;
							}
						}
					}
				}
				
			}
		}
		
		return result;
	}
}

class Point{
	int x,y, cnt;
	
	public Point(int y, int x, int cnt) {
		this.y = y;
		this.x = x;
		this.cnt = cnt;
	}
}
