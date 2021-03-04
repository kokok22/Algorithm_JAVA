import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Permutation1 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			
			boolean[] chk = new boolean[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<N;i++)
				chk[Integer.parseInt(st.nextToken())-1] = true;
			
			String answer = "Yes";
			
			for(int i=0;i<N;i++) {
				if(!chk[i]) {
					answer = "No";
					break;
				}
			}
			bw.write("#"+(t+1)+" "+answer+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
