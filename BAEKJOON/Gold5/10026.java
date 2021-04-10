import java.util.*;
import java.io.*;

public class ColorWeakness {
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		char[][] map = new char[N][N];
		
		for(int y=0;y<N;y++) {
			String s = br.readLine();
			for(int x=0;x<N;x++)
				map[y][x] = s.charAt(x);
		}
		
		boolean[][] chk1 = new boolean[N][N];
		boolean[][] chk2 = new boolean[N][N];
		
		int cnt1 = 0;
		int cnt2 = 0;
		
		for(int y=0;y<N;y++) {
			for(int x=0;x<N;x++) {
				char c = map[y][x];
				// 정상
				if(!chk1[y][x]) {
					bfs1(map, y, x, c, chk1);
					cnt1++;
				}
				
				// 적록색약
				if(!chk2[y][x]) {
					bfs2(map, y, x, c, chk2);
					cnt2++;
				}
			}
		}
		
		bw.write(cnt1+" "+cnt2+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void bfs1(char[][] map, int y, int x, char c, boolean[][] chk) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(y*map[0].length+x);
		chk[y][x] = true;
		
		while(!queue.isEmpty()) {
			int n = queue.size();
			
			while(n-->0) {
				int p = queue.poll();
				y = p/map[0].length;
				x = p%map[0].length;
				
				for(int i=0;i<4;i++) {
					int ny = y+dy[i];
					int nx = x+dx[i];
					
					if(ny>=0 && ny<map.length && nx>=0 && nx<map[0].length
							&& !chk[ny][nx] && map[ny][nx]==c) {
						chk[ny][nx] = true;
						queue.offer(ny*map[0].length+nx);
					}
				}
			}
		}
		
	}
	
	public static void bfs2(char[][] map, int y, int x, char c, boolean[][] chk) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(y*map[0].length+x);
		chk[y][x] = true;
		
		while(!queue.isEmpty()) {
			int n = queue.size();
			
			while(n-->0) {
				int p = queue.poll();
				y = p/map[0].length;
				x = p%map[0].length;
				
				for(int i=0;i<4;i++) {
					int ny = y+dy[i];
					int nx = x+dx[i];
					
					if(ny>=0 && ny<map.length && nx>=0 && nx<map[0].length && !chk[ny][nx]) {
						if(c=='B' && map[ny][nx]==c) {
							chk[ny][nx] = true;
							queue.offer(ny*map[0].length+nx);
						}else if((c=='R' || c=='G') && map[ny][nx]!='B') {
							chk[ny][nx] = true;
							queue.offer(ny*map[0].length+nx);
						}
					}
				}
			}
		}
	}
}
