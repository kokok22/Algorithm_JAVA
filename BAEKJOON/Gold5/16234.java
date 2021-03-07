import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PopulationMovement {
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][N];
		
		for(int y=0;y<N;y++) {
			st = new StringTokenizer(br.readLine());
			
			for(int x=0;x<N;x++)
				map[y][x] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		
		while(true) {
			int num = bfs(map, L, R, new boolean[N][N]);

			if(num==0)
				break;
			else
				cnt += num;
		}
		
		bw.write(cnt+"");
		bw.flush();
		br.close();
		bw.close();
	}	
	
	public static int bfs(int[][] map, int L, int R, boolean[][] chk) {
		int cnt = 0;
		
		// 모든 좌표를 다 돌아댕긴다.
		for(int y=0;y<map.length;y++) {
			for(int x=0;x<map[0].length;x++) {
				Queue<Integer> queue = new LinkedList<Integer>();
				ArrayList<Integer> arr = new ArrayList<Integer>();
				int sum = 0;
				
				if(!chk[y][x]) {
					queue.offer(y*map[0].length+x);
					chk[y][x] = true;
					
					while(!queue.isEmpty()) {
						int n = queue.size();
						
						while(n-->0) {
							int idx = queue.poll();
							int iy = idx/map[0].length;
							int ix = idx%map[0].length;
							int num = map[iy][ix];
							arr.add(idx);
							sum += num;
							
							for(int i=0;i<4;i++) {
								int ny = iy + dy[i];
								int nx = ix + dx[i];
								
								if(ny>=0 && ny<map.length && nx>=0 && nx<map[0].length && !chk[ny][nx]) {
									int temp = Math.abs(map[ny][nx]-num);
									
									if(temp>=L && temp<=R) {
										chk[ny][nx] = true;
										queue.offer(ny*map[0].length+nx);
									}
								}
							}
						}
					}
				}
				
				if(arr.size()>1) {
					cnt=1;
					int avg = sum/arr.size();
					
					for(int i=0;i<arr.size();i++) {
						int idx = arr.get(i);
						int ny = idx/map[0].length;
						int nx = idx%map[0].length;
						
						map[ny][nx] = avg;
					}
				}
			}
		}
		return cnt;
	}
}
