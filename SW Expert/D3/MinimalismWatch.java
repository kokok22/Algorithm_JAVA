import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MinimalismWatch {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			int num = Integer.parseInt(br.readLine());
			
			int h = num/30;
			int m = num%30*2;
			
			if(h==12)
				h=0;
			
			bw.write("#"+(t+1)+" "+h+" "+m+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
