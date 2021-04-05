import java.io.*;
import java.util.*;

public class Resignation {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] plan = new int[N][2];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int T = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			
			plan[i][0] = T;
			plan[i][1] = P;
		}
		
		int cnt = recursive(plan, 0, 0, new boolean[N]);
		
		bw.write(cnt+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static int recursive(int[][] plan, int idx, int rest, boolean[] sel) {
		int cnt = Integer.MIN_VALUE;
		
		if(idx==sel.length) {
			if(rest>0)
				return cnt;
			
			int sum = 0;
			for(int i=0;i<sel.length;i++) {
				if(sel[i])
					sum += plan[i][1];
			}
			
			return sum;
		}
		
		if(rest<0)
			rest = 0;
		
		if(rest==0) {
			sel[idx] = true;
			cnt = Math.max(cnt, recursive(plan, idx+1, plan[idx][0]-1, sel));
			sel[idx] = false;
		}
		
		cnt = Math.max(cnt, recursive(plan, idx+1, rest-1, sel));
		
		return cnt;
	}
} 