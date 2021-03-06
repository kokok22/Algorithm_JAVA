import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Coin {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] map = new int[N];
		
		for(int i=0;i<N;i++)
			map[N-1-i] = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		
		for(int n : map) {
			if(K/n>0) {
				cnt += K/n;
				K %= n;
			}
		}
		
		bw.write(cnt+"");
		bw.flush();
		br.close();
		bw.close();
	}
}
