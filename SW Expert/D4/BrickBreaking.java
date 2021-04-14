import java.util.*;
import java.io.*;

public class BrickBreaking {
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[H][W];
			
			for(int y=0;y<H;y++) {
				st = new StringTokenizer(br.readLine());
				for(int x=0;x<W;x++)
					map[y][x] = Integer.parseInt(st.nextToken());
			}
			
			int cnt = recursive(map, new int[N], 0);
			bw.write("#"+(t+1)+" "+cnt+"\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void print(int[][] map) {
		for(int y=0;y<map.length;y++) {
			for(int x=0;x<map[0].length;x++)
				System.out.print(map[y][x]+" ");
			System.out.println();
		}
	}
	
	public static void copy(int[][] temp, int[][] map) {
		for(int y=0;y<map.length;y++) {
			for(int x=0;x<map[0].length;x++)
				temp[y][x] = map[y][x];
		}
	}
	
	public static int count(int[][] map) {
		int result = 0;
		
		for(int y=0;y<map.length;y++) {
			for(int x=0;x<map[0].length;x++) {
				if(map[y][x]!=0)
					result++;
			}
		}
		
		return result;
	}
	
	// 잘 됨
	public static void bomb2(int[][] map, int y, int x) {
		int num = map[y][x];
		map[y][x] = 0;
		
		for(int n=1;n<num;n++) {
			for(int i=0;i<4;i++) {
				int ny = y+n*dy[i];
				int nx = x+n*dx[i];
				
				if(ny>=0 && ny<map.length && nx>=0 && nx<map[0].length && map[ny][nx]!=0)
					bomb2(map, ny, nx);
			}
		}
	}
	
	public static void move(int[][] map) {
		for(int x=0;x<map[0].length;x++) {
			int n = 0;
			
			for(int y=map.length-1;y>=0;y--) {
				if(map[y][x]==0)
					n++;
				else if(n>0) {
					map[y+n][x] = map[y][x];
					map[y][x] = 0;
				}
			}
		}
	}
	
	public static void bomb(int[][] map, int idx) {
		for(int y=0;y<map.length;y++) {
			if(map[y][idx]!=0) {
				bomb2(map, y, idx);
				move(map);
				return;
			}
		}
	}
	
	public static int recursive(int[][] map, int[] sel, int k) {
		int result = Integer.MAX_VALUE;
		
		if(k==sel.length) {
			// 임시 배열 사용하기
			int[][] temp = new int[map.length][map[0].length];
			
			copy(temp, map);
			
			for(int idx : sel)
				// 폭탄 떨어뜨리기
				bomb(temp, idx);

			// 남은 블록 세기
			result = count(temp);
			
			return result;
		}
		
		for(int i=0;i<map[0].length;i++) {
			sel[k]=i;
			result = Math.min(result, recursive(map,sel,k+1));
		}
		
		return result;
	}
}
