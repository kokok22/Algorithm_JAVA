import java.io.*;

public class FourSquares {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] sum = new int[n+1];
		sum[0] = 0;
		sum[1] = 1;
		
		for(int i=2;i<=n;i++) {
			sum[i] = Integer.MAX_VALUE;
			
			for(int j=1;j*j<=i;j++)
				sum[i] = Math.min(sum[i], sum[i-j*j]);
			
			sum[i]++;
		}
		
		bw.write(sum[n]+"");
		bw.flush();
		br.close();
		bw.close();
	}
}