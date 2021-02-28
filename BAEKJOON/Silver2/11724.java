import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class NumberOfLink {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N+1][N+1];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			map[u][v] = 1;
			map[v][u] = 1;
		}
		
		int cnt = 0;
		boolean[] chk = new boolean[N+1];
		
		for(int i=1;i<=N;i++)
			cnt += bfs(map, chk, i);
		
		bw.write(cnt+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	private static int bfs(int[][] map, boolean[] chk, int idx) {
		if(chk[idx])
			return 0;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(idx);
		
		while(!queue.isEmpty()) {
			int n = queue.size();
			
			while(n-->0) {
				int node = queue.poll();
				
				for(int i=1;i<map.length;i++) {
					if(map[node][i]!=0 && !chk[i]) {
						chk[i] = true;
						queue.offer(i);
					}
				}
			}
		}
		
		return 1;
	}
}
