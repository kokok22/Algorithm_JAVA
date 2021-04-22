import java.io.*;
import java.util.*;

public class Minesweeper {
	public static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
	public static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
	
		for(int t=0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			
			char[][] map = new char[N][N];
			
			for(int y=0;y<N;y++) {
				String s = br.readLine();
				for(int x=0;x<N;x++)
					map[y][x] = s.charAt(x);
			}
			
			count(map);
			
			boolean[][] chk = new boolean[N][N];
			int cnt = 0;
			
			for(int y=0;y<N;y++) {
				for(int x=0;x<N;x++) {
					if(map[y][x]=='0' && !chk[y][x]) {
						cnt++;
						bfs(map, y, x, chk);
					}
				}
			}
			
			for(int y=0;y<N;y++) {
				for(int x=0;x<N;x++) {
					if(map[y][x]!='*' && !chk[y][x])
						cnt++;
				}
			}
			
			bw.write("#"+(t+1)+" "+cnt+"\n");
			
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void bfs(char[][] map, int y, int x, boolean[][] chk) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(y*map[0].length+x);
		chk[y][x] = true;
		
		while(!queue.isEmpty()) {
			int n = queue.size();
			
			while(n-->0) {
				int idx = queue.poll();
				y = idx/map[0].length;
				x = idx%map[0].length;
				
				for(int i=0;i<8;i++) {
					int ny = y+dy[i];
					int nx = x+dx[i];
					
					if(ny>=0 && ny<map.length && nx>=0 && nx<map[0].length && !chk[ny][nx]) {
						chk[ny][nx] = true;
						if(map[ny][nx]=='0')
							queue.offer(ny*map[0].length+nx);
					}
				}
			}
		}
	}
	
	public static void count(char[][] map) {
		for(int y=0;y<map.length;y++) {
			for(int x=0;x<map[0].length;x++) {
				if(map[y][x]=='.') {
					int cnt = 0;
					
					for(int i=0;i<8;i++) {
						int ny = y+dy[i];
						int nx = x+dx[i];
						
						if(ny>=0 && ny<map.length && nx>=0 && nx<map[0].length && map[ny][nx]=='*')
							cnt++;
					}
					
					map[y][x] = Integer.toString(cnt).charAt(0);
				}
			}
		}
	}
}
