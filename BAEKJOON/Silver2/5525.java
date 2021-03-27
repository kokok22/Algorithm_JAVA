import java.io.*;

public class IOIOI {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String s = br.readLine();
		
		char[] io = new char[2*N+1];
		
		for(int i=0;i<io.length;i++) {
			if(i%2==0)
				io[i] = 'I';
			else
				io[i] = 'O';
		}
		
		int cnt = KMP(s, io);
		
		bw.write(cnt+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static int[] getPi(char[] io) {
		int[] pi = new int[io.length];
		int j=0;
		
		for(int i=1;i<io.length;i++) {
			while(j>0 && io[i] != io[j])
				j = pi[j-1];
			if(io[i] == io[j])
				pi[i] = ++j;
		}
		
		return pi;
	}
	
	public static int KMP(String s, char[] io) {
		int[] pi = getPi(io);
		int cnt = 0;
		int j=0;
		
		for(int i=0;i<s.length();i++) {
			while(j>0 && s.charAt(i)!=io[j])
				j=pi[j-1];
			if(s.charAt(i)==io[j]) {
				if(j==io.length-1) {
					cnt++;
					j=pi[j];
				}else
					j++;
			}
		}
		return cnt;
	}
}
