import java.util.*;
import java.io.*;

public class RGBDistance {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][3];
		
		for(int y=0;y<N;y++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int x=0;x<3;x++)
				map[y][x] = Integer.parseInt(st.nextToken());
		}
		
		int[][] cost = new int[N][3];
		
		for(int y=0;y<N;y++) {
			if(y==0) {
				cost[y][0] = map[y][0];
				cost[y][1] = map[y][1];
				cost[y][2] = map[y][2];
			}
			else {
				cost[y][0] = Math.min(cost[y-1][1],cost[y-1][2])+map[y][0];
				cost[y][1] = Math.min(cost[y-1][0], cost[y-1][2])+map[y][1];
				cost[y][2] = Math.min(cost[y-1][0], cost[y-1][1])+map[y][2];
			}
		}
		
		int result = Math.min(cost[N-1][0], cost[N-1][1]);
		result = Math.min(result, cost[N-1][2]);
		
		bw.write(result+"");
		bw.flush();
		br.close();
		bw.close();
	}
}
