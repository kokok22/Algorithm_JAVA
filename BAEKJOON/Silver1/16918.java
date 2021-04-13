import java.io.*;
import java.util.*;

public class Bomberman {
	public static int[] dx = {0, 0, -1, 1};
	public static int[] dy = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[R][C];
		
		for(int y=0;y<R;y++) {
			String s = br.readLine();
			for(int x=0;x<C;x++) {
				char c= s.charAt(x);
				if(c=='O')
					map[y][x] = 2;
			}
		}
		
		for(int i=1;i<N;i++) {
			if(i%2==1)
				insert(map);
			else
				bomb(map);
		}
		
		print(map);
		br.close();
	}
	
	public static void print(int[][] map) {
		for(int y=0;y<map.length;y++) {
			for(int x=0;x<map[0].length;x++) {
				if(map[y][x]==0)
					System.out.print(".");
				else
					System.out.print("O");
			}
			System.out.println();
		}
	}
	
	public static void insert(int[][] map) {
		for(int y=0;y<map.length;y++) {
			for(int x=0;x<map[0].length;x++) {
				map[y][x] += 1;
			}
		}
	}
	
	public static void bomb(int[][] map) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		for(int y=0;y<map.length;y++) {
			for(int x=0;x<map[0].length;x++) {
				if(map[y][x]>0)
					map[y][x] += 1;
				if(map[y][x]>=3) {
					map[y][x] = 0;
					for(int i=0;i<4;i++) {
						int ny = y+dy[i];
						int nx= x+dx[i];
						
						if(ny>=0 && ny<map.length && nx>=0 && nx<map[0].length)
							list.add(ny*map[0].length+nx);
					}
				}
			}
		}
		
		for(int idx : list) {
			int y = idx/map[0].length;
			int x = idx%map[0].length;
			
			map[y][x] = 0;
		}
	}
}
