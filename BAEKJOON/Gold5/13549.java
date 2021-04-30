import java.io.*;
import java.util.*;

public class HideAndSeek {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int cnt = bfs(new int[100001], N, K);
		
		bw.write(cnt+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static int bfs(int[] map, int N , int K) {
		Arrays.fill(map, Integer.MAX_VALUE);
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(N);
		map[N] = 0;
		
		while(!queue.isEmpty()) {
			int n = queue.size();
			
			while(n-->0) {
				int idx = queue.poll();
				
				if(idx==K)
					return map[idx];
				
				for(int i=0;i<3;i++) {
					int nidx = idx;
					int t = map[idx];
					if(i==0) {
						nidx += 1;
						t++;
					}
					else if(i==1) {
						nidx -= 1;
						t++;
					}
					else if(i==2)
						nidx *= 2;
					
					if(nidx>=0 && nidx<map.length && map[nidx] > t) {
						queue.offer(nidx);
						map[nidx] = t;
					}	
				}
			}
		}

		return 0;
	}
}
