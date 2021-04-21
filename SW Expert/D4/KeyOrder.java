import java.io.*;
import java.util.*;

public class KeyOrder {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			
			boolean[][] map1 = new boolean[N][N];
			boolean[][] map2 = new boolean[N][N];
			
			for(int i=0;i<M;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				
				map1[a][b] = true;
				map2[b][a] = true;
			}
			
			for(int k=0;k<N;k++) {
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						if(map1[i][k] && map1[k][j]) {
							map1[i][j] = true;
							map2[j][i] = true;
						}
					}
				}
			}
			
			int cnt = 0;
			
			for(int y=0;y<N;y++) {
				int temp=0;
				for(int x=0;x<N;x++) {
					if(map1[y][x])
						temp++;
					else if(map2[y][x])
						temp++;
				}
				
				if(temp==N-1)
					cnt++;
			}
			bw.write("#"+(t+1)+" "+cnt+"\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
}
