import java.io.*;

public class Parentheses {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long[] dp = new long[5001];
		
		dp[0] = 1;
		dp[2] = 1;
		
		for(int i=4;i<=5000;i+=2) {
			for(int j=2;j<=i;j+=2) {
				dp[i] += (dp[j-2]*dp[i-j]);
				dp[i] %= 1000000007;
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			int L = Integer.parseInt(br.readLine());
			
			bw.write(dp[L]+"\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
}
