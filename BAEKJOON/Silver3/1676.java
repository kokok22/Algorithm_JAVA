import java.io.*;

public class NumberOfZero {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int sum = 1;
		int result = 0;
		
		for(int i=1;i<=N;i++) {
			sum *= i;
			sum %= 10000;
			while(sum%10==0) {
				result += 1;
				sum /= 10;
			}
		}
		
		bw.write(result+"");
		bw.flush();
		br.close();
		bw.close();
	}
}
