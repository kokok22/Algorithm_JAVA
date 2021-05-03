import java.io.*;
import java.util.*;

public class MagicShark {
	public static int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
	public static int[] dy = {0, 0, -1, -1, -1, 0, 1, 1, 1};
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][N];
		boolean[][] chk = new boolean[N][N];
		
		// 지도 생성
		for(int y=0;y<N;y++) {
			st = new StringTokenizer(br.readLine());
			for(int x=0;x<N;x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 구름 배열
		Queue<Point> cloud = new LinkedList<Point>();
		
		// 처음 생성된 구름
		cloud.add(new Point(N-1, 0));
		cloud.add(new Point(N-1, 1));
		cloud.add(new Point(N-2, 0));
		cloud.add(new Point(N-2, 1));
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			int n = cloud.size();
			
			// 구름 이동하기
			for(int j=0;j<n;j++) {
				Point p = cloud.poll();
				
				p.y += s*dy[d];
				p.x += s*dx[d];
				
				// 범위 밖으로 벗어나지 않도록 조정
				while(p.y<0)
					p.y += map.length;
				while(p.x<0)
					p.x += map[0].length;
				
				p.y %= map.length;
				p.x %= map[0].length;
				
				cloud.offer(p);
			}
			
			// 방문배열 초기화
			init(chk);
			
			// 구름 갯수 가져오기
			n = cloud.size();
			
			// 비내리기
			for(int j=0;j<n;j++) {
				Point p = cloud.poll();
				
				// 비내린 위치 다시 저장함
				map[p.y][p.x] += 1;
				cloud.offer(p);
				chk[p.y][p.x] = true;
			}
			
			// 구름 갯수 가져오기
			n = cloud.size();
			
			// 대각선 바구니 확인
			for(int j=0;j<n;j++) {
				Point p = cloud.poll();
				int cnt = 0;
				
				for(int idx=2;idx<9;idx+=2) {
					int ny = p.y+dy[idx];
					int nx = p.x+dx[idx];
					
					if(ny>=0 && ny<map.length && nx>=0 && nx<map[0].length && map[ny][nx]>0) {
						cnt++;
					}
				}
				map[p.y][p.x] += cnt;	
			}
			
			// 바구니 물의 양이 2 이상인 곳 확인
			for(int y=0;y<map.length;y++) {
				for(int x=0;x<map[0].length;x++) {
					if(map[y][x]>=2 && !chk[y][x]) {
						cloud.add(new Point(y, x));
						map[y][x] -= 2;
					}
				}
			}
			
		}
		
		int result = count(map);
		
		bw.write(result+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static int count(int[][] map) {
		int cnt = 0;
		
		for(int y=0;y<map.length;y++) {
			for(int x=0;x<map[0].length;x++)
				cnt += map[y][x];
		}
		
		return cnt;
	}
	
	public static void init(boolean[][] chk) {
		for(int y=0;y<chk.length;y++) {
			for(int x=0;x<chk[0].length;x++)
				chk[y][x] = false;
		}
	}
}

class Point{
	int y, x;
	
	public Point(int y, int x) {
		this.y = y;
		this.x = x;
	}
}
