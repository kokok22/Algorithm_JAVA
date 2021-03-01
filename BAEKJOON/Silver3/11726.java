import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Tiling {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] d = new int[1001];
		d[1] = 1;
		d[2] = 2;
		d[3] = 3;
		
		for(int i=4;i<=n;i++)
			d[i] = (d[i-1]+d[i-2])%10007;
		
		bw.write(d[n]+"");
		bw.flush();
		br.close();
		bw.close();
	}

}
