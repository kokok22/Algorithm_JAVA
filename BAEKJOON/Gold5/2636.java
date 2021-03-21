import java.io.*;
import java.util.*;

public class Cheese {
	public static int[] dx = {0, 0, -1, 1};
	public static int[] dy = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int Y = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[Y][X];
		
		for(int y=0;y<Y;y++) {
			st = new StringTokenizer(br.readLine());
			for(int x=0;x<X;x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		int time = 0;
		int cnt = 0;
		
		while(true) {					
			int temp = count(map);
			if(temp==0)
				break;
			
			cnt = temp;
			
			bfs(map, new boolean[map.length][map[0].length]);
			time++;
		}
		
		bw.write(time+"\n");
		bw.write(cnt+"");
		bw.flush();
		br.close();
		bw.close();
		
	}
	
	public static void bfs(int[][] map, boolean[][] chk) {
		LinkedList<Integer> re = new LinkedList<Integer>();
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(0);
		chk[0][0] = true;
		
		while(!queue.isEmpty()) {
			int n = queue.size();
			
			while(n-->0) {
				int idx = queue.poll();
				
				int y = idx/map[0].length;
				int x = idx%map[0].length;
				
				for(int i=0;i<4;i++) {
					int ny = y+dy[i];
					int nx = x+dx[i];
					
					if(ny>=0 && ny<map.length && nx>=0 && nx<map[0].length && !chk[ny][nx]) {
						if(map[ny][nx] == 1)
							re.add(ny*map[0].length+nx);
						else
							queue.offer(ny*map[0].length+nx);
						
						chk[ny][nx] = true;
					}
				}
			}
		}
		
		for(int i=0;i<re.size();i++) {
			int idx = re.get(i);
			
			int y = idx/map[0].length;
			int x = idx%map[0].length;
			
			map[y][x] = 0;
		}
	}
	
	
	public static int count(int[][] map) {
		int cnt = 0;
		
		for(int y=0;y<map.length;y++) {
			for(int x=0;x<map[0].length;x++) {
				if(map[y][x]!=0)
					cnt++;
			}
		}
		
		return cnt;
	}
}
