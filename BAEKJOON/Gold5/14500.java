import java.util.*;
import java.io.*;

public class Tetromino {
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		
		for(int y=0;y<N;y++) {
			st = new StringTokenizer(br.readLine());
			for(int x=0;x<M;x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result = Integer.MIN_VALUE;
		boolean[][] chk = new boolean[N][M];
		
		for(int y=0;y<N;y++) {
			for(int x=0;x<M;x++) {
				init(chk);
				chk[y][x] = true;
				result = Math.max(result, dfs(map, y, x, chk, 1, map[y][x]));
				result = Math.max(result, block(map, y, x));
			}
		}
		
		bw.write(result+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void init(boolean[][] chk) {
		for(int y=0;y<chk.length;y++)
			Arrays.fill(chk[y],false);
	}
	
	public static int block(int[][] map, int y, int x) {
		int result = Integer.MIN_VALUE;
		
		if(y+2>=0 && y+2<map.length && x+1>=0 && x+1<map[0].length)
			result = Math.max(result, map[y][x]+map[y+1][x]+map[y+2][x]+map[y+1][x+1]);
		
		if(y+2>=0 && y+2<map.length && x-1>=0 && x-1<map[0].length)
			result = Math.max(result, map[y][x]+map[y+1][x]+map[y+2][x]+map[y+1][x-1]);
		
		if(y+1>=0 && y+1<map.length && x+2>=0 && x+2<map[0].length)
			result = Math.max(result, map[y][x]+map[y+1][x+1]+map[y][x+1]+map[y][x+2]);
		
		if(y-1>=0 && y-1<map.length && x+2>=0 && x+2<map[0].length)
			result = Math.max(result, map[y][x]+map[y-1][x+1]+map[y][x+1]+map[y][x+2]);
		
		return result;
	}
	
	public static int dfs(int[][] map, int y, int x, boolean[][] chk, int depth, int sum) {
		int result = Integer.MIN_VALUE;
		
		if(depth==4)		
			return sum;
		
		for(int i=0;i<4;i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			
			if(ny>=0 && ny<map.length && nx>=0 && nx<map[0].length && !chk[ny][nx]) {
				chk[ny][nx] = true;
				result = Math.max(result, dfs(map, ny, nx, chk, depth+1, sum+map[ny][nx]));
				chk[ny][nx] = false;
			}
		}
		return result;
	}
}
