import java.io.*;

public class OneTwoThree {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			int n = Integer.parseInt(br.readLine());
			
			int[] count = new int[n+1];
			
			for(int i=1;i<=n;i++) {
				if(i==1)
					count[i] = 1;
				else if(i==2)
					count[i] = 2;
				else if(i==3)
					count[i] = 4;
				else
					count[i] = count[i-3] + count[i-2] + count[i-1]; 
			
			}
			bw.write(count[n]+"\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
}
