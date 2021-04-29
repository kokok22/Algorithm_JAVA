import java.io.*;

public class NQueen {
	public static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
	public static int[] dy = {0, 0, -1, 1, -1, 1, 1, -1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		
		int cnt = recursive(map, 0);
		
		bw.write(cnt+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static int recursive(int[][] map, int idx) {
		int result = 0;
		
		if(idx>=map.length)
			return 1;
		
		for(int i=0;i<map[0].length;i++) {
			if(map[idx][i]==0) {
				map[idx][i]++;
				spread(map, idx, i);
				result += recursive(map, idx+1);
				map[idx][i]--;
				respread(map, idx, i);
			}
		}
		
		return result;
	}
	
	public static void spread(int[][] map, int y, int x) {
		for(int i=0;i<8;i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			
			while(ny>=0 && ny<map.length && nx>=0 && nx<map[0].length) {
				map[ny][nx]++;
				ny += dy[i];
				nx += dx[i];
			}
		}
	}
	
	public static void respread(int[][] map, int y, int x) {
		for(int i=0;i<8;i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			
			while(ny>=0 && ny<map.length && nx>=0 && nx<map[0].length) {
				map[ny][nx]--;
				ny += dy[i];
				nx += dx[i];
			}
		}
	}
}