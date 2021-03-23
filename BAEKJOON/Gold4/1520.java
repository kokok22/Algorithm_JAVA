import java.util.*;
import java.io.*;

public class DownhillRoad {
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[M][N];
		
		for(int y=0;y<M;y++) {
			st = new StringTokenizer(br.readLine());
			
			for(int x=0;x<N;x++)
				map[y][x] = Integer.parseInt(st.nextToken());
		}
		
		int[][] cnt = new int[M][N];
		boolean[][] chk = new boolean[M][N];
		
		int result = dfs(map, cnt, 0, 0, chk);
		
		bw.write(result+"");
		bw.flush();
		br.close();
		bw.close();
	}	
	
	public static int dfs(int[][] map, int[][] cnt, int y, int x, boolean[][] chk) {
		int sum = 0;
		if(y==map.length-1 && x==map[0].length-1)
			return 1;
		
		if(chk[y][x])
			return cnt[y][x];
		
		for(int i=0;i<4;i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			
			if(ny>=0 && ny<map.length && nx>=0 && nx<map[0].length && map[y][x]>map[ny][nx])
				sum += dfs(map, cnt, ny, nx, chk);
		}
		
		chk[y][x] = true;
		cnt[y][x] = sum;
		return sum;
	}
}
