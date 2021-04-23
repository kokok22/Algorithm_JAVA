import java.io.*;
import java.util.*;

public class Wormhole {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N+1][N+1];
			
			for(int i=0;i<map.length;i++)
				Arrays.fill(map[i], Integer.MAX_VALUE);
			
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				
				map[u][v] = Math.min(map[u][v], w);
				map[v][u] = Math.min(map[v][u], w);
			}
			
			for(int i=0;i<W;i++) {
				st = new StringTokenizer(br.readLine());
				
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				
				map[u][v] = Math.min(map[u][v], -w);
			}
			
			for(int k=1;k<=N;k++) {
				for(int i=1;i<=N;i++) {
					for(int j=1;j<=N;j++) {
						if(map[i][k]!=Integer.MAX_VALUE && map[k][j]!=Integer.MAX_VALUE) {
							map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
						}
					}
				}
			}
			
			boolean flag = true;
			
			for(int i=1;i<=N;i++) {
				if(map[i][i]<0) {
					flag = false;
					break;
				}
			}
			
			if(flag)
				bw.write("NO\n");
			else
				bw.write("YES\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
}