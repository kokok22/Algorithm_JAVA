import java.io.*;
import java.util.*;

public class SpinThePlatter {
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static int[] dd = {1, -1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		
		for(int y=0;y<N;y++) {
			st = new StringTokenizer(br.readLine());
			for(int x=0;x<M;x++)
				map[y][x] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			
			int xi = Integer.parseInt(st.nextToken());
			int di = Integer.parseInt(st.nextToken());
			int ki = Integer.parseInt(st.nextToken());

			// 원판 돌리기
			for(int y=xi-1;y<map.length;y+=xi) {
				int[] temp = new int[map[0].length];
				
				for(int x=0;x<map[0].length;x++) {
					int idx = x+ki*dd[di];
					
					// 음의 방향으로 가는 경우, 오른쪽 끝으로 보내기 위해 x축의 길이만큼 더해준다.
					// 왼쪽으로 엄청 많이 갈 수도 있기 때문에 while문을 통해 양수가 될 때까지 반복
					while(idx<0)
						idx += map[0].length;
					
					temp[idx%map[0].length] = map[y][x];
				}
				
				for(int x=0;x<map[0].length;x++)
					map[y][x] = temp[x];
			}
			
			// 변경된 것이 몇개인지 저장하는 변수
			// 0이면 변경된 것이 없기 때문에 원판위의 값들을 평균 +- 처리 해줘야 한다.
			int cnt = 0;
			
			boolean[][] chk = new boolean[N][M];
			
			// bfs를 통해 인접한 부분 탐색 및 제거 실시
			for(int y=0;y<map.length;y++) {
				for(int x=0;x<map[0].length;x++) {
					if(map[y][x]>0) {
						init(chk);  // chk 초기화
						cnt += bfs(map, y, x, chk);
					}
				}
			}
			
			if(cnt==0)
				avg(map);
		}
		
		int result = count(map);
		
		bw.write(result+"");
		bw.flush();
		br.close();
		bw.close();
	}	
	
	public static void avg(int[][] map) {
		double sum = 0;
		int cnt = 0;
		
		for(int y=0;y<map.length;y++) {
			for(int x=0;x<map[0].length;x++)
				if(map[y][x]>0) {
					sum += map[y][x];
					cnt++;
				}
		}
		
		if(cnt==0)
			return;
		
		double avg = sum/cnt;
		
		for(int y=0;y<map.length;y++) {
			for(int x=0;x<map[0].length;x++) {
				if(map[y][x]==0)
					continue;
				if(map[y][x]>avg)
					map[y][x]--;
				else if(map[y][x]<avg)
					map[y][x]++;
			}
		}
	}
	
	
	public static int count(int[][] map) {
		int cnt = 0;
		
		for(int y=0;y<map.length;y++) {
			for(int x=0;x<map[0].length;x++) {
				if(map[y][x]>0)
					cnt += map[y][x];
			}
		}
		
		return cnt;
	}
	
	public static int bfs(int[][] map, int y, int x, boolean[][] chk) {
		int cnt = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(y*map[0].length+x);
		chk[y][x] = true;
		
		while(!queue.isEmpty()) {
			int n = queue.size();
			
			while(n-->0) {
				int idx = queue.poll();
				y = idx/map[0].length;
				x = idx%map[0].length;
				
				for(int i=0;i<4;i++) {
					int ny = y+dy[i];
					int nx = x+dx[i];
					
					while(nx<0)
						nx += map[0].length;
					
					nx %= map[0].length;
					
					if(ny>=0 && ny<map.length &&!chk[ny][nx] && map[ny][nx] == map[y][x]) {
						chk[ny][nx] = true;
						cnt++;
						queue.offer(ny*map[0].length+nx);
					}
				}
			}
		}
		
		if(cnt>0) {
			for(y=0;y<chk.length;y++) {
				for(x=0;x<chk[0].length;x++) {
					if(chk[y][x])
						map[y][x] = 0;
				}
			}
		}
		
		return cnt;
	}
	
	
	public static void init(boolean[][] chk) {
		for(int y=0;y<chk.length;y++) {
			for(int x=0;x<chk[0].length;x++) {
				chk[y][x] = false;
			}
		}
	}
}
