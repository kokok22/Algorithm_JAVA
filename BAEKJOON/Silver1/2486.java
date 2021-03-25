import java.io.*;
import java.util.*;

public class SafeArea {
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		
		int max = Integer.MIN_VALUE;
		
		for(int y=0;y<N;y++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int x=0;x<N;x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[y][x]);
			}
		}
		
		int result = Integer.MIN_VALUE;
		
		for(int i=0;i<max;i++) {
			boolean[][] chk = new boolean[N][N];
			int cnt = 0;
			for(int y=0;y<N;y++) {
				for(int x=0;x<N;x++) {
					if(!chk[y][x] && map[y][x]>i) {
						cnt++;
						bfs(map, chk, y, x, i);
					}
				}
			}
			result = Math.max(cnt, result);
		}
		
		bw.write(result+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void bfs(int[][] map, boolean[][] chk, int y, int x, int limit) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(y*map[0].length+x);
		chk[y][x] = true;
		
		while(!queue.isEmpty()) {
			int n = queue.size();
			
			while(n-->0) {
				int idx = queue.poll();
				y = idx/map[0].length;
				x = idx%map[0].length;
				
				for(int i=0;i<4;i++) {
					int ny = y+dy[i];
					int nx = x+dx[i];
					
					if(ny>=0 && ny<map.length && nx>=0 && nx<map[0].length && !chk[ny][nx] && map[ny][nx]>limit) {
						chk[ny][nx] = true;
						queue.offer(ny*map[0].length+nx);
					}
				}
			}
		}
		
	}
}
