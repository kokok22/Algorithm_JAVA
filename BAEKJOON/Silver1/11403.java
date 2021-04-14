import java.util.*;
import java.io.*;

public class FindPaths {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		
		for(int y=0;y<N;y++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int x=0;x<N;x++)
				map[y][x] = Integer.parseInt(st.nextToken());
		}

		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][k]*map[k][j]>0)
						map[i][j] = 1;
				}
			}
		}
		
		print(map, bw);
		
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void print(int[][] map, BufferedWriter bw) throws IOException {
		for(int y=0;y<map.length;y++) {
			for(int x=0;x<map[0].length;x++)
				bw.write(map[y][x]+" ");
			bw.write("\n");
		}
	}
}
