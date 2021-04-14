import java.io.*;

public class Tiling {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long[] dp = new long[1001];
		
		for(int i=1;i<=1000;i++) {
			if(i==1)
				dp[i] = 1;
			else if(i==2)
				dp[i]= 3;
			else
				dp[i] = (dp[i-1] + 2*dp[i-2])%10007;
		}
		
		int n = Integer.parseInt(br.readLine());
		
		bw.write(dp[n]+"");
		
		bw.flush();
		br.close();
		bw.close();
	}
}