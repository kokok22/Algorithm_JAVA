import java.io.*;
import java.util.*;

public class SupplyRoute {
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] map = new int[N][N];
			
			for(int y=0;y<N;y++) {
				String s = br.readLine();
				for(int x=0;x<N;x++)
					map[y][x] = Integer.parseInt(s.charAt(x)+"");
			}
			
			int cnt = bfs(map, new boolean[N][N], new int[N][N]);
			bw.write("#"+(t+1)+" "+cnt+"\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static int bfs(int[][] map, boolean[][] chk, int[][] deep) {
		Queue<Spot> queue = new LinkedList<Spot>();
		queue.offer(new Spot(0,0,0));
		chk[0][0] = true;
		
		int cnt = Integer.MAX_VALUE;
		
		while(!queue.isEmpty()) {
			int n = queue.size();
			
			while(n-->0) {
				Spot p = queue.poll();
				int y = p.y;
				int x = p.x;
				int d = p.d;
				
				if(x==map[0].length-1 && y==map.length-1)
					cnt = Math.min(cnt, d);
				
				for(int i=0;i<4;i++) {
					int ny = y+dy[i];
					int nx = x+dx[i];
					int nd = d+map[y][x];
					
					if(ny>=0 && ny<map.length && nx>=0 && nx<map[0].length) {
						if(!chk[ny][nx]) {
							chk[ny][nx]= true;
							deep[ny][nx] = nd;
							queue.offer(new Spot(ny, nx, nd));
						}else if(nd<deep[ny][nx]) {
							deep[ny][nx] = nd;
							queue.offer(new Spot(ny, nx, nd));
						}
					}
				}
			}
		}
		return cnt;
	}
}

class Spot{
	int y,x,d;
	
	public Spot(int y, int x, int d) {
		this.y = y;
		this.x = x;
		this.d = d; 
	}
}
