import java.util.*;
import java.io.*;

public class Suji {
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			char[][] map = new char[R][C];
			
			for(int y=0;y<R;y++) {
				String s = br.readLine();
				for(int x=0;x<C;x++) {
					map[y][x] = s.charAt(x);
				}
			}
			
			boolean[] chk = new boolean['Z'-'A'+1];
			chk[map[0][0]-'A'] = true;
			
			int cnt = dfs(map, chk, 0, 0, 1);
			bw.write("#"+(t+1)+" "+cnt+"\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static int dfs(char[][] map, boolean[] chk, int y, int x, int depth) {
		int cnt = depth;
		
		for(int i=0;i<4;i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			
			if(ny>=0 && ny<map.length && nx>=0 && nx<map[0].length && !chk[map[ny][nx]-'A']) {
				chk[map[ny][nx]-'A'] = true;
				cnt = Math.max(cnt, dfs(map, chk, ny, nx, depth+1));
				chk[map[ny][nx]-'A'] = false;
			}
		}
		return cnt;
	}	
}