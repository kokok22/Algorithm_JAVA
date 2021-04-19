import java.util.*;
import java.io.*;

public class combination {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int p = 1234567891;
			
			long[] fact = new long[n+1];
			
			for(int i=1;i<fact.length;i++) {
				if(i==1)
					fact[i] = 1;
				else
					fact[i] = (fact[i-1]*i)%p;
			}
			
			long result = (fact[n]*pow(fact[r], p-2, p)%p * pow(fact[n-r],p-2,p)%p)%p;
			bw.write("#"+(t+1)+" "+result+"\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static long pow(long x, long y, long p) {
		long sum = 1L;
		
		x = x%p;
		
		while(y>0) {
			if(y%2==1)
				sum = (sum*x)%p;
			y = y>>1;
			x = (x*x) % p;
		}
		return sum;
	}
}
