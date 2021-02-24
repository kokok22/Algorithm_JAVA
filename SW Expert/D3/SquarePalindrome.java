import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SquarePalindrome {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			int cnt = 0;
			
			for(int i=A;i<=B;i++) {
				double temp = Math.sqrt(i);
				if(temp == (int)temp && chk(Integer.toString(i)) && chk(Integer.toString((int)temp)))
					cnt++;
			}
			bw.write("#"+(t+1)+" "+cnt+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static boolean chk(String num) {
		int first = 0;
		int last = num.length()-1;
		
		while(first<last) {
			if(num.charAt(first)==num.charAt(last)) {
				first++;
				last--;
			}
			else
				return false;
		}
		return true;
	}
}
