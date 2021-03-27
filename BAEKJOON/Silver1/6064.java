import java.util.*;
import java.io.*;

public class KaingCalendar {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
	
			int max = M*N/gcd(M,N);
			
			while(x!=y) {
				if(x<y)
					x += M;
				else
					y += N;
				
				if(x>max || y>max){
					x=-1;
					break;
				}
			}
			
			bw.write(x+"\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static int gcd(int a, int b) {
		while(b!=0) {
			int r = a%b;
			a=b;
			b=r;
		}
		return a;
	}
}
