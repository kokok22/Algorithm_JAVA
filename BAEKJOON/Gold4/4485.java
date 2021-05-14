import java.io.*;
import java.util.*;

public class Jellda {
	public static int[] dx = {0, 0, -1, 1};
	public static int[] dy = {-1, 1, 0 ,0};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = 1;
		
		while(true) {
			int N = Integer.parseInt(br.readLine());
			int answer = 0;
			
			if(N==0)
				break;
			
			int[][] map = new int[N][N];
			
			for(int y=0;y<N;y++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int x=0;x<N;x++)
					map[y][x] = Integer.parseInt(st.nextToken());
			}
			
			answer = count(map);
			
			bw.write("Problem "+t+": "+answer+"\n");
			t++;
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static int count(int[][] map) {
		int[][] distance = new int[map.length][map[0].length];
		boolean[][] visit = new boolean[map.length][map[0].length];
		
		for(int y=0;y<distance.length;y++)
			Arrays.fill(distance[y], Integer.MAX_VALUE);
		
		distance[0][0] = map[0][0];
		
		while(true) {
			int min = Integer.MAX_VALUE;
			
			int ty = 0;
			int tx = 0;
			
			for(int y=0;y<distance.length;y++) {
				for(int x=0;x<distance[0].length;x++) {
					if(!visit[y][x] && min>distance[y][x]) {
						min = distance[y][x];
						ty = y;
						tx = x;
					}
				}
			}
			
			int y = ty;
			int x = tx;
			
			if(y==map.length-1 && x==map[0].length-1)
				break;
			
			visit[y][x] = true;
			
			for(int i=0;i<4;i++) {
				int ny = y+dy[i];
				int nx = x+dx[i];
				
				if(ny>=0 && ny<map.length && nx>=0 && nx<map[0].length)
					distance[ny][nx] = Math.min(distance[ny][nx], min + map[ny][nx]);
			}
		}
		
		return distance[map.length-1][map[0].length-1];
	}
}