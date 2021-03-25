import java.io.*;
import java.util.*;

public class WalkingOverABeer {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			int n = Integer.parseInt(br.readLine());
			
			int[] x_arr = new int[n+2];
			int[] y_arr = new int[n+2];
			
			boolean result = false;
			
			for(int i=0;i<n+2;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				x_arr[i] = Integer.parseInt(st.nextToken());
				y_arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int[][] map = new int[n+2][n+2];
			
			for(int y=0;y<n+2;y++) {
				for(int x=0;x<n+2;x++) {
					map[y][x] = Math.abs(x_arr[y]-x_arr[x])+Math.abs(y_arr[y]-y_arr[x]);
					if(map[y][x]>1000)
						map[y][x] = Integer.MAX_VALUE;
				}
			}

			for(int k=0;k<map.length;k++) {
				for(int i=0;i<map.length;i++) {
					for(int j=0;j<map.length;j++) {
						if(map[i][k]!=Integer.MAX_VALUE && map[k][j]!=Integer.MAX_VALUE)
							map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
					}
				}
			}
			
			if(map[map.length-1][0]!=Integer.MAX_VALUE)
				bw.write("happy\n");
			else
				bw.write("sad\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
}
