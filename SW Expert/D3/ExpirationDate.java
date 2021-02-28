import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ExpirationDate {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			String s = br.readLine();
			
			int x1 = Integer.parseInt(s.substring(0,2));
			int x2 = Integer.parseInt(s.substring(2));
			
			String answer = "NA";
			
			if(chk(x1) && chk(x2))
				answer = "AMBIGUOUS";
			else if(!chk(x1) && chk(x2))
				answer = "YYMM";
			else if(chk(x1) && !chk(x2))
				answer = "MMYY";
				
			bw.write("#"+(t+1)+" "+answer+"\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
	
	private static boolean chk(int x) {
		if(x>12 || x<1)
			return false;
		return true;
	}
}
