import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class LabyrinthSearch {
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
			String s = br.readLine();
			
			for(int x=0;x<M;x++)
				map[y][x] = Integer.parseInt(s.charAt(x)+"");
		}
		
		int cnt = bfs(map, 0, new boolean[N][M]);
		
		bw.write(cnt+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	private static int bfs(int[][] map, int start, boolean[][] chk) {
		int cnt = 1;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		chk[0][0] = true;
		
		while(!queue.isEmpty()) {
			int n = queue.size();
			
			while(n-->0) {
				int idx = queue.poll();
				int y = idx/map[0].length;
				int x = idx%map[0].length;
				
				if(y==map.length-1 && x==map[0].length-1)
					return cnt;
				
				for(int i=0;i<4;i++) {
					int ny = y+dy[i];
					int nx = x+dx[i];
					
					if(ny>=0 && ny<map.length && nx>=0 && nx<map[0].length && !chk[ny][nx] && map[ny][nx]==1) {
						queue.offer(ny*map[0].length+nx);
						chk[ny][nx] = true;
					}
				}
			}
			cnt++;
		}
	return cnt;
	}
}
