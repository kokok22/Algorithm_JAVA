import java.io.*;
import java.util.*;

public class KevinBacon {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] adjMat = new int[N+1][N+1];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			int p1 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			
			adjMat[p1][p2] = 1;
			adjMat[p2][p1] = 1;
		}
		
		// floyd-warshall
		for(int k=1;k<N+1;k++) {
			for(int i=1;i<N+1;i++) {
				for(int j=1;j<N+1;j++) {
					if(i==j)
						continue;
					if(adjMat[i][k]!=0 && adjMat[k][j]!=0) {
						if(adjMat[i][j]==0)
							adjMat[i][j] = adjMat[i][k] + adjMat[k][j];
						else
							adjMat[i][j] = Math.min(adjMat[i][j], adjMat[i][k]+adjMat[k][j]);
					}
				}
			}
		}
		
		int max = Integer.MAX_VALUE;
		int idx = 0;
		
		for(int y=1;y<N+1;y++) {
			int sum = 0;
			for(int x=1;x<N+1;x++) {
				sum += adjMat[y][x];
			}
			
			if(max>sum) {
				idx = y;
				max = sum;
			}
		}
		
		bw.write(idx+"");
		bw.flush();
		br.close();
		bw.close();
	}
}
