import java.util.*;
import java.io.*;

public class Cheese {
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
		
		int cnt = 1;
		
		while(true) {
			bfs(map, new int[N][M], new boolean[N][M]);
			if(check(map)==0)
				break;
			cnt++;
		}
		
		bw.write(cnt+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void bfs(int[][] map, int[][] cnt, boolean[][] chk) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(0);
		chk[0][0] = true;
		
		while(!queue.isEmpty()) {
			int n = queue.size();
			
			while(n-->0) {
				int p = queue.poll();
				int y = p/map[0].length;
				int x = p%map[0].length;
				
				for(int i=0;i<4;i++) {
					int ny = y+dy[i];
					int nx = x+dx[i];
					
					if(ny>=0 && ny<map.length && nx>=0 && nx<map[0].length && !chk[ny][nx]) {
						if(map[ny][nx]==0) {
							chk[ny][nx]=true;
							queue.offer(ny*map[0].length+nx);
						}else if(map[ny][nx]==1) {
							cnt[ny][nx] += 1;
						}
					}
				}
			}
		}
		
		for(int y=0;y<map.length;y++) {
			for(int x=0;x<map[0].length;x++) {
				if(cnt[y][x]>1)
					map[y][x] = 0;
			}
		}
	}
	
	
	public static int check(int[][] map) {
		int cnt = 0;
		
		for(int y=0;y<map.length;y++) {
			for(int x=0;x<map[0].length;x++) {
				if(map[y][x]==1)
					cnt++;
			}
		}
		
		return cnt;
	}
}
