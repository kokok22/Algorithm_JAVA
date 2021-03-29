import java.util.*;
import java.io.*;

public class TwoArmedScale {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] weight = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			weight[i] = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			int K = Integer.parseInt(st.nextToken());
			
			if(recursive(weight, 0, K, new boolean[N][15001], 0))
				bw.write("Y ");
			else
				bw.write("N ");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static boolean recursive(int[] weight, int sum, int K, boolean[][] chk, int idx) {
		boolean result = false;
		
		if(sum==K)
			return true;
		
		if(idx==weight.length)
			return false;
		
		if(!chk[idx][sum+weight[idx]]) {
			chk[idx][sum+weight[idx]] = true;
			result = recursive(weight, sum+weight[idx], K, chk, idx+1);
		}
		
		if(!result && !chk[idx][sum]) {
			chk[idx][sum] = true;
			result = recursive(weight, sum, K, chk, idx+1);
		}
		
		if(!result && !chk[idx][Math.abs(sum-weight[idx])]) {
			chk[idx][Math.abs(sum-weight[idx])] = true;
			result = recursive(weight, Math.abs(sum-weight[idx]), K, chk, idx+1);
		}
		
		return result;
	}
}
