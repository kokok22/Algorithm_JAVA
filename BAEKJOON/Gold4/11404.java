import java.io.*;
import java.util.*;

public class Floyd {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N+1][N+1];
		
		for(int i=1;i<map.length;i++)
			Arrays.fill(map[i], Integer.MAX_VALUE);
		
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			map[u][v] = Math.min(map[u][v], w);
		}
		
		for(int k=1;k<map.length;k++) {
			for(int i=1;i<map.length;i++) {
				for(int j=1;j<map.length;j++) {
					if(i!=j && map[i][k] != Integer.MAX_VALUE && map[k][j] != Integer.MAX_VALUE)
						map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
				}
			}
		}
		
		for(int y=1;y<map.length;y++) {
			for(int x=1;x<map[0].length;x++) {
				if(map[y][x]==Integer.MAX_VALUE)
					bw.write(0+" ");
				else
					bw.write(map[y][x]+" ");
			}
			bw.write("\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
}
