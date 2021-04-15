import java.util.*;
import java.io.*;

public class SnakLadder {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] map = new int[101];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			map[x] = y;
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			map[u] = v;
		}
		
		int cnt = bfs(map, new int[101]);
		
		bw.write(cnt+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static int bfs(int[] map, int[] cnt) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(1);
		
		int result = 1;
		
		while(!queue.isEmpty()) {
			int n = queue.size();
			
			while(n-->0) {
				int idx = queue.poll();
				
				for(int i=1;i<=6;i++) {
					int p = idx+i;
					if(p>=0 && p<=100) {
						if(map[p]!=0)
							p = map[p];
						if(cnt[p]==0 || cnt[p]>result) {
							cnt[p] = result;
							queue.offer(p);
						}
					}
				}
			}
			
			result++;
		}
		
		return cnt[100];
	}
}