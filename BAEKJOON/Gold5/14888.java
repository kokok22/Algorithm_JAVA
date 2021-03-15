import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ResearchInstitute {
	public static int[] dx = {0, 0, -1, 1};
	public static int[] dy = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		
		for(int y=0;y<N;y++) {
			st = new StringTokenizer(br.readLine());
			
			for(int x=0;x<M;x++)
				map[y][x] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = recursive(map, 0);
		
		bw.write(cnt+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	// 순열을 통해 map의 값이 0인 부분 3개를 1로 바꿔준다.
	// 조합으로 하면 시간이 줄어들 것 같은데 코드가 복잡해 질 것 같아서 순열로 했습니다.
	private static int recursive(int[][] map, int cnt) {
		int num = 0;
		
		if(cnt==3) {
			int[][] temp = new int[map.length][map[0].length];
			
			for(int y=0;y<map.length;y++) {
				for(int x=0;x<map[0].length;x++) {
					temp[y][x] = map[y][x];
				}
			}	
			return search(temp, new boolean[map.length][map[0].length]);
		}
		
		for(int y=0;y<map.length;y++) {
			for(int x=0;x<map[0].length;x++) {
				if(map[y][x]==0) {
					map[y][x]=1;
					num = Math.max(num, recursive(map, cnt+1));
					map[y][x]=0;
				}
			}
		}
		
		return num;
	}
	
	// 바이러스가 존재하고 아직 방문하지 않았던 지점을 탐지한다.
	private static int search(int[][] map, boolean[][] chk) {			
		for(int y=0;y<map.length;y++) {
			for(int x=0;x<map[0].length;x++) {
				if(map[y][x]==2 && !chk[y][x])
					bfs(map, y, x, chk);
			}
		}
		return count(map);	
	}
	
	// bfs를 돌면서 0을 2로 변경시켜준다.
	private static void bfs(int[][] map, int y, int x, boolean[][] chk) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(x,y));
		chk[y][x] = true;
		
		while(!queue.isEmpty()) {
			int n = queue.size();
			
			while(n-->0) {
				Point p = queue.poll();
				
				for(int i=0;i<4;i++) {
					int ny = p.y+dy[i];
					int nx = p.x+dx[i];
					
					if(nx>=0 && nx<map[0].length && ny>=0 && ny<map.length
							&& !chk[ny][nx] && map[ny][nx]!=1) {
						chk[ny][nx] = true;
						map[ny][nx] = 2;
						queue.offer(new Point(nx, ny));
					}
				}
			}
		}
	}
	
	// 0인 부분의 개수를 센다.
	private static int count(int[][] map) {
		int cnt = 0;
		
		for(int y=0;y<map.length;y++) {
			for(int x=0;x<map[0].length;x++) {
				if(map[y][x]==0)
					cnt++;
			}
		}
		return cnt;
	}
}

class Point{
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
