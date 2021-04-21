import java.io.*;
import java.util.*;


public class DragonCurve {
	public static int[] dx = {1, 0, -1, 0};
	public static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		boolean[][] map = new boolean[101][101];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			
			map[y][x] = true;
			
			LinkedList<Integer> ds = new LinkedList<Integer>();
			ds.addFirst(d);
			x += dx[d];
			y += dy[d];
			
			map[y][x] = true;
			
			int[] spot = {y, x};
			
			for(int j=0;j<g;j++)
				curve(map, spot, ds);
			
		}

		int result = chk(map);
		
		bw.write(result+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void curve(boolean[][] map, int[] spot, LinkedList<Integer> ds) {
		LinkedList<Integer> temp = new LinkedList<Integer>();
		
		int x = spot[1];
		int y = spot[0];
		
		for(int i=0;i<ds.size();i++) {
			int idx = (ds.get(i)+1)%4;
			
			x += dx[idx];
			y += dy[idx];
			
			map[y][x] = true;
			
			temp.addFirst(idx);
			
			spot[1] = x;
			spot[0] = y;
		}
		
		for(int i=temp.size()-1;i>=0;i--)
			ds.addFirst(temp.get(i));
	}
	
	public static int chk(boolean[][] map) {
		int cnt = 0;
		
		for(int y=0;y<map.length-1;y++) {
			for(int x=0;x<map[0].length-1;x++) {
				if(map[y][x] && map[y+1][x] && map[y][x+1] && map[y+1][x+1]) {
					cnt++;
				}
			}
		}
		
		return cnt;
	}
}
