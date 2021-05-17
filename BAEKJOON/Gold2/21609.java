import java.io.*;
import java.util.*;

public class MiddleShark {
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][N];
		
		for(int y=0;y<N;y++) {
			st= new StringTokenizer(br.readLine());
			for(int x=0;x<N;x++)
				map[y][x] = Integer.parseInt(st.nextToken());
		}
		
		int result = simulation(map);

		bw.write(result+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static int simulation(int[][] map) {
		int result = 0;
		
		int nx = 0;
		int ny = 0;
		int nnum = 0;
		int nrain = 0;
		
		boolean[][] chk = new boolean[map.length][map[0].length];
		
		while(true) {	
			nnum = 0;
			nrain = 0;
			
			for(int y=0;y<map.length;y++)
				Arrays.fill(chk[y], false);
			
			// 제거할 블록 찾기
			for(int y=0;y<map.length;y++) {
				for(int x=0;x<map[0].length;x++) {
					if(!chk[y][x] && map[y][x]>=1) {
						int[] temp = bfs(map, chk, y, x);
						
						// 블록 크기가 큰 경우
						if(temp[0]>nnum) {
							nx = x;
							ny = y;
							nnum = temp[0];
							nrain = temp[1];
						}
						// 블록 크기가 같은 경우
						else if(temp[0]==nnum) {
							// 무지개 블록이 크거나  같은 경우(어차피 뒤에 나오는 것이 행이랑 열이 크다.)
							if(nrain<=temp[1]) {
								nx = x;
								ny = y;
								nrain = temp[1];
							}
						}
					}
				}
			}
			
			// 제거할 블록 그룹이 없는 경우
			if(nnum<2)
				return result;
			
			// 점수 더하기
			result += (nnum*nnum);
			
			// 제거하기
			delete(map, ny, nx);
			
			// 중력
			gravity_y(map);

			// 회전
			map = rotation(map);

			// 중력
			gravity_y(map);

		}
	}
	
	public static int[][] rotation(int[][] map) {
		int[][] temp = new int[map.length][map[0].length];
		
		for(int y=0;y<map.length;y++) {
			for(int x=0;x<map[0].length;x++) {
				temp[map[0].length-x-1][y] = map[y][x];
			}
		}
		
		return temp;
	}
	
	
	public static void gravity_y(int[][] map) {
		for(int x=0;x<map[0].length;x++) {
			int d = 0;
			for(int y=map.length-1;y>=0;y--) {
				if(map[y][x]==-2)
					d++;
				else if(map[y][x]==-1)
					d = 0;
				else if(map[y][x]>=0 && d!=0) {
					map[y+d][x] = map[y][x];
					map[y][x] = -2;
				}
			}
		}
	}
	
	public static void print(int[][] map) {
		for(int y=0;y<map.length;y++) {
			for(int x=0;x<map[0].length;x++) {
				if(map[y][x]==-2)
					System.out.print("* ");
				else if(map[y][x]==-1)
					System.out.print("# ");
				else
					System.out.print(map[y][x]+" ");
			}
			System.out.println("");
		}
		System.out.println();
	}
	
	public static void delete(int[][] map, int y, int x) {
		boolean[][] chk = new boolean[map.length][map[0].length];
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(y*map[0].length+x);
		chk[y][x] = true;
		int num = map[y][x];
		
		while(!queue.isEmpty()) {
			int n = queue.size();
			
			while(n-->0) {
				int idx = queue.poll();
				y = idx/map[0].length;
				x = idx%map[0].length;
				
				map[y][x] = -2;
				
				for(int i=0;i<4;i++) {
					int ny = y+dy[i];
					int nx = x+dx[i];
					
					if(ny>=0 && ny<map.length && nx>=0 && nx<map[0].length && !chk[ny][nx]) {
						if(map[ny][nx]==num || map[ny][nx]==0) {
							chk[ny][nx] = true;
							queue.offer(ny*map[0].length+nx);
						}
					}
				}
			}
		}
	}
	
	public static int[] bfs(int[][] map, boolean[][] chk, int y, int x) {
		int[] result = new int[2];
		result[0] = 1;
		
		boolean[][] temp = new boolean[map.length][map[0].length];
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(y*map[0].length+x);
		int num = map[y][x];
		chk[y][x] = true;
		temp[y][x] = true;
		
		while(!queue.isEmpty()) {
			int n = queue.size();
			
			while(n-->0) {
				int idx = queue.poll();
				y = idx/map[0].length;
				x = idx%map[0].length;
				
				if(map[y][x]==0)
					result[1]++;
				
				for(int i=0;i<4;i++) {
					int ny = y+dy[i];
					int nx = x+dx[i];
					
					if(ny>=0 && ny<map.length && nx>=0 && nx<map[0].length && !temp[ny][nx]) {
						if(map[ny][nx]==num || map[ny][nx]==0) {
							chk[ny][nx] = true;
							temp[ny][nx] = true;
							queue.offer(ny*map[0].length+nx);
							result[0]++;
						}
					}
				}
			}
		}
		
		return result;
	}
}
