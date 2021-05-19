import java.io.*;
import java.util.*;

public class Sticker {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			int n = Integer.parseInt(br.readLine());
			
			int[][] map = new int[2][n];
			
			for(int y=0;y<2;y++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int x=0;x<n;x++) {
					map[y][x] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] dp = new int[2][n];
			
			for(int x=0;x<n;x++) {
				if(x==0) {
					dp[0][x] = map[0][x];
					dp[1][x] = map[1][x];
				}
				else if(x==1) {
					dp[0][x] = dp[1][x-1]+map[0][x];
					dp[1][x] = dp[0][x-1]+map[1][x];
				}
				else {
					dp[0][x] = Math.max(dp[1][x-2], dp[1][x-1])+map[0][x];
					dp[1][x] = Math.max(dp[0][x-2], dp[0][x-1])+map[1][x];
				}
			}
			
			int result = Math.max(dp[1][n-1], dp[0][n-1]);
			
			bw.write(result+"\n");
			
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
}
