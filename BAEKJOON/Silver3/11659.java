import java.util.*;
import java.io.*;

public class SubSum {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int[] sums = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			if(i==1)
				sums[i] = Integer.parseInt(st.nextToken());
			else
				sums[i] = sums[i-1] + Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int result = sums[b]-sums[a-1];
			
			bw.write(result+"\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
}
