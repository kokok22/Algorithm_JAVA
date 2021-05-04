import java.io.*;
import java.util.*;

// 처음에 group하는 과정이 4방탐색인 줄 알고, 2차원 배열로 map을 만들었는데 번호순서대로 탐색하는 것이었다. queue로 만들어서 하면 조금 더 편할 것 같다는 생각이 든다.

public class MagicShark {
	public static int[] dx = {0, 0, 0, -1, 1};
	public static int[] dy = {0, -1, 1, 0, 0};
	
	public static int sum = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][N];
		
		for(int y=0;y<N;y++) {
			st = new StringTokenizer(br.readLine());
			for(int x=0;x<N;x++)
				map[y][x] = Integer.parseInt(st.nextToken());
		}
		
		int[][] num = new int[N][N]; 	// 각 좌표의 번호가 저장되어 있다.
		Point[] p = new Point[N*N];		// 각 번호의 좌표가 저장되어 있다.
		
		// 좌표와 번호를 매핑한다.
		num[(N-1)/2][(N-1)/2] = 0;
		p[0] = new Point((N-1)/2, (N-1)/2);
		
		init(num, p);
		
		// 구현 시작
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			int d = Integer.parseInt(st.nextToken());	// 방향
			int s = Integer.parseInt(st.nextToken());	// 길이
			
			// 얼음 던지기
			ice(map, d, s);
			
			while(true) {
				// 구슬이동하기
				move(map, p);
				
				// 연속된 구슬 확인
				if(!check(map, p))
					break;
			}
			
			// 그룹화 후 
			map = group(map, p);
			
			//print(map);
		}
		
		bw.write(sum+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static int[][] group(int[][] map, Point[] p) {
		int[][] temp = new int[map.length][map[0].length];
		
		int cnt = 1;
		int pre = map[p[1].y][p[1].x];
		
		int idx = 1;
		
		for(int i=2;i<p.length;i++) {
			int now = map[p[i].y][p[i].x];
			
			if(pre==now)
				cnt++;
			
			else if(now==0 || pre!=now) {
				temp[p[idx].y][p[idx].x] = cnt;
				temp[p[idx+1].y][p[idx+1].x] = pre;
				
				idx += 2;
				pre = now;
				
				cnt = 1;
				
				if(now==0 || idx>=p.length)
					break;
			}
		}
		
		return temp;
	}
	
	public static boolean check(int[][] map, Point[] p) {
		boolean flag = false;
		
		int cnt = 1;
		int pre = map[p[1].y][p[1].x];
		
		for(int i=2;i<p.length;i++) {
			int now = map[p[i].y][p[i].x];
			
			if(now==0)
				break;
			
			if(pre==now)
				cnt++;
			
			else {
				pre = now;
				if(cnt>=4) {
					for(int j=1;j<=cnt;j++) {
						sum += map[p[i-j].y][p[i-j].x];
						map[p[i-j].y][p[i-j].x] = 0;
						flag = true;
					}
				}
				cnt = 1;
			}
		}
		
		return flag;
	}
	
	public static void init(int[][] num, Point[] p) {
		int[] or = {3, 2, 4, 1};	// 이동방향 순서
		int idx=0;					// 이동방향 index
		
		int cnt = 1;				// 방향 이동 길이
		int temp = 0;				// 지금 몇번 이동했는지
		int re = 1;					// 몇번 반복했는지 확인
		
		int x = (num.length-1)/2;
		int y = (num.length-1)/2;
		
		for(int i=1;i<p.length;i++) {
			if(temp!=cnt) {
				x += dx[or[idx]];
				y += dy[or[idx]];
				num[y][x] = i;
				p[i] = new Point(y, x);
				
			}else if(temp==cnt) {
				idx = (idx+1)%4;
				
				// 같은 크기의 이동이 2번씩 반복되기 때문에 체크해준다.
				if(re==2) {
					re = 1;
					cnt++;
				}else
					re++;
				
				temp = 0;
				x += dx[or[idx]];
				y += dy[or[idx]];
				num[y][x] = i;
				
				p[i] = new Point(y, x);
			}

			temp++;
		}
	}
	
	public static void ice(int[][] map, int d, int s) {
		// 상어의 위치
		int x = (map.length-1)/2;
		int y = (map.length-1)/2;
		
		for(int j=1;j<=s;j++) {
			int nx = x+j*dx[d];
			int ny = y+j*dy[d];
			
			if(ny>=0 && ny<map.length && nx>=0 && nx<map[0].length && map[ny][nx]!=0) {
				map[ny][nx] = 0;
			}
		}
	}
	
	public static void move(int[][] map, Point[] p) {
		int t = 1;
		
		for(int j=1;j<p.length-t;j++) {
			int y = p[j].y;
			int x = p[j].x;
			
			if(map[y][x]==0) {
				int ny = p[j+t].y;
				int nx = p[j+t].x;
				
				while(ny>=0 && ny<map.length && nx>=0 && nx<map[0].length && map[ny][nx]==0) {
					t++;
					if(j+t>=p.length)
						return;
					ny = p[j+t].y;
					nx = p[j+t].x;
				}
				
				map[y][x] = map[ny][nx];
				map[ny][nx] = 0;
			}
		}
	}
	
	public static void print(int[][] num) {
		System.out.println();
		for(int y=0;y<num.length;y++) {
			for(int x=0;x<num[0].length;x++)
				System.out.print(num[y][x]+" ");
			System.out.println();
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
