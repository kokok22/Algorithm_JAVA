import java.io.*;
import java.util.*;

public class FineDust {
	public static int[] dx = {0, 1, 0, -1};
	public static int[] dy = {-1, 0, 1 ,0};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[R][C];
		LinkedList<Integer> air = new LinkedList<Integer>();
		
		for(int y=0;y<R;y++) {
			st = new StringTokenizer(br.readLine());
			
			for(int x=0;x<C;x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				if(map[y][x]==-1) {
					air.add(y);
				}
			}
		}
		
		for(int i=0;i<T;i++) {
			spread(map, air);		// 미세먼지가 퍼지는 부분
			clean(map, air);		// 공기청정기 작동
		}
		
		int cnt = count(map);
		
		bw.write(cnt+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static int count(int[][] map) {
		int cnt = 0;
		
		for(int y=0;y<map.length;y++) {
			for(int x=0;x<map[0].length;x++) {
				if(map[y][x] > 0) {
					cnt += map[y][x];
				}
			}
		}
		
		return cnt;
	}
	
	public static void clean(int[][] map, LinkedList<Integer> air) {
		
		// 위쪽 공기 순환
		int i = 0;
		
		int pre_y = air.get(0);
		int pre_x = 0;
		
		while(true) {
			int y = pre_y + dy[i];
			int x = pre_x + dx[i];
			
			if(y<0 || y>air.get(0) || x<0 || x>=map[0].length) {
				i++;
				continue;
			}
			
			if(x==0 && y==air.get(0))
				break;
			
			if(map[pre_y][pre_x] != -1) {
				map[pre_y][pre_x] = map[y][x];
			}
			
			map[y][x] = 0;
			
			pre_y = y;
			pre_x = x;
		}
		
		// 아래쪽 공기 순환
		
		i = 2;
		 
		pre_y = air.get(1);
		pre_x = 0;
			
		while(true) {
			int y = pre_y + dy[i];
			int x = pre_x + dx[i];
			
			if(y<air.get(1) || y>=map.length || x<0 || x>=map[0].length) {
				i--;
				if(i<0)
					i=3;
				continue;
			}
			
			if(x==0 && y==air.get(1))
				break;
			
			if(map[pre_y][pre_x] != -1) {
				map[pre_y][pre_x] = map[y][x];
			}
			
			map[y][x] = 0;
			
			pre_y = y;
			pre_x = x;
		}
	}
	
	public static void spread(int[][] map, LinkedList<Integer> air) {
		LinkedList<Point> spot = new LinkedList<Point>();
		for(int y=0;y<map.length;y++) {
			for(int x=0;x<map[0].length;x++) {
				if(map[y][x]>0)
					spot.add(new Point(x,y,map[y][x]));
			}
		}
		
		int air1 = air.get(0);
		int air2 = air.get(1);
		
		for(int i=0;i<spot.size();i++) {
			Point p = spot.get(i);
			int x = p.x;
			int y = p.y;
			
			int temp = p.mount/5;
			int cnt = 0;
			
			for(int j=0;j<4;j++) {
				int nx = x+dx[j];
				int ny = y+dy[j];
				if(ny>=0 && ny<map.length && nx>=0 && nx<map[0].length) {
					if(nx==0 && (ny==air1 || ny==air2))
						continue;
					cnt++;
					map[ny][nx] += temp;
				}
			}
			map[y][x] -= temp*cnt;
		}
		
		
		
	}
}

class Point{
	int x;
	int y;
	int mount;
	
	public Point(int x, int y, int mount) {
		this.x = x;
		this.y = y;
		this.mount = mount;
	}
}
