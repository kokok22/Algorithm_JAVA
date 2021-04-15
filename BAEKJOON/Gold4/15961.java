import java.util.*;
import java.io.*;

public class Sushi {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] dishes = new int[N];
		int[] visit = new int[d+1];
		
		for(int i=0;i<N;i++)
			dishes[i] = Integer.parseInt(br.readLine());
		
		int total = 1;
		int result = Integer.MIN_VALUE;
		
		visit[c]++;
		
		for(int i=0;i<N+k;i++) {
			if(i>=k) {
				if(--visit[dishes[i-k]]==0)
					total--;
			}
			
			int idx = i%N;
			
			if(visit[dishes[idx]]++==0)
				total++;
			
			result = Math.max(result, total);
		}

		bw.write(result+"");
		bw.flush();
		br.close();
		bw.close();
	}
}
