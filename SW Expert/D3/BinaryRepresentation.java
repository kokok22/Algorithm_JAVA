import java.io.*;
import java.util.StringTokenizer;

public class BinaryRepresentation {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			String answer = "OFF";
			
			String s = Integer.toBinaryString(M);

			if(s.length()>=N && !(s.substring(s.length()-N).contains("0"))){
				answer = "ON";
			}
			bw.write("#"+(t+1)+" "+answer+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
