import java.util.*;
import java.io.*;

public class RobotCleaner {
	public static int[] dx = {0, -1, 0, 1};
	public static int[] dy = {-1, 0, 1, 0};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());  	// y크기
		int M = Integer.parseInt(st.nextToken());  	// x크기

		int[][] map = new int[N][M];				// 지도
		
		st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());   // y좌표
		int c = Integer.parseInt(st.nextToken());   // x좌표
		
		int d = Integer.parseInt(st.nextToken());	// 방향

		for(int y=0;y<N;y++) {
			st = new StringTokenizer(br.readLine());
			for(int x=0;x<M;x++)
				map[y][x] = Integer.parseInt(st.nextToken());
		}
		
		// 내가 만든 4방 탐색 index에 따라 바꿔주기
		if(d==1)
			d=3;
		else if(d==3)
			d=1;
		
		int cnt = search(map, r, c, d, new boolean[N][M]);
		
		bw.write(cnt+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	private static int search(int[][] map, int y, int x, int d, boolean[][] chk) {
		int cnt = 0;
		
		while(true) {
			if(!chk[y][x])
				cnt++;
			chk[y][x] = true;
			
			boolean flag = false;
			
			for(int i=1;i<5;i++) {
				int nd = (d+i)%4;
				int ny = y+dy[nd];
				int nx = x+dx[nd];
				
				if(ny>=0 && ny<map.length && nx>=0 && nx<map[0].length
						&& !chk[ny][nx] && map[ny][nx]!=1) {
					y = ny;
					x = nx;
					d = nd;
					flag = true;
					break;
				}
			}
			
			if(!flag) {
				y -= dy[d];
				x -= dx[d];
				
				if(y<0 || y>=map.length || x<0 || x>=map[0].length
						|| map[y][x]==1)
					break;
			}
		}
		return cnt;
	}
}
