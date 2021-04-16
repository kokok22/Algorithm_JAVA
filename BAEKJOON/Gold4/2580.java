import java.util.*;
import java.io.*;

public class Sudoku {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[][] map = new int[9][9];
		
		for(int y=0;y<9;y++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int x=0;x<9;x++)
				map[y][x] = Integer.parseInt(st.nextToken());
		}
		
		recursive(map);
		print(map);
		
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
	
	public static boolean check(int[][] map, int y, int x) {
		boolean[] chk = new boolean[10];
		
		// 세로
		for(int i=0;i<9;i++) {
			if(map[i][x]!=0 && chk[map[i][x]])
				return false;
			chk[map[i][x]] = true;
		}
		
		Arrays.fill(chk, false);
		
		// 가로
		for(int i=0;i<9;i++) {
			if(map[y][i]!=0 && chk[map[y][i]])
				return false;
			chk[map[y][i]] = true;
		}
		
		Arrays.fill(chk, false);
		
		// 네모
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(map[i+y/3*3][j+x/3*3]!=0 && chk[map[i+y/3*3][j+x/3*3]])
					return false;
				chk[map[i+y/3*3][j+x/3*3]] = true;
			}
		}
		
		return true;
	}
	
	public static boolean finish(int[][] map) {
		for(int y=0;y<map.length;y++) {
			for(int x=0;x<map[0].length;x++) {
				if(map[y][x]==0)
					return false;
			}
		}
		return true;
	}
	
	public static boolean recursive(int[][] map) {
		if(finish(map))
			return true;
		boolean flag = false;
		
		for(int y=0;y<map.length;y++) {
			for(int x=0;x<map[0].length;x++) {
				
				if(map[y][x]==0) {
					for(int i=1;i<=9;i++) {
						map[y][x] = i;
						if(check(map, y, x))
							flag = recursive(map);
						if(flag)
							return true;
					}
					if(!flag) {
						map[y][x] = 0;
						return false;
					}
				}
			}
		}
		
		return flag;
	}
}

