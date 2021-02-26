import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class CPU {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder();
			
			String s = convertOP(st.nextToken());
			addO(s, 5, sb);
			sb.append("0");
			
			String sd = Integer.toBinaryString(Integer.parseInt(st.nextToken()));
			addO(sd, 3, sb);
			
			String ad = Integer.toBinaryString(Integer.parseInt(st.nextToken()));
			addO(ad, 3, sb);
			
			String ab = Integer.toBinaryString(Integer.parseInt(st.nextToken()));
			if(sb.charAt(4)=='1')
				addO(ab, 4, sb);
			else {
				addO(ab, 3, sb);
				sb.append(0);
			}
			
			bw.write(sb.toString()+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
	
	private static void addO(String s, int n, StringBuilder sb) {
		int idx = n-s.length();
		
		for(int j=0;j<idx;j++)
			sb.append("0");
		sb.append(s);
	}
	
	private static String convertOP(String s) {
		String[] arr = {"ADD", "SUB", "MOV", "AND", "OR", "NOT", "MULT", "LSFTL", "LSFTR", "ASFTR", "RL", "RR"};
		
		String temp = s;
		
		if(s.charAt(s.length()-1)=='C')
			temp = s.substring(0,s.length()-1);;
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i].equals(temp))
				sb.append(Integer.toBinaryString(i));
		}
		
		if(s.charAt(s.length()-1)=='C')
			sb.append(1);
		else
			sb.append(0);
		
		return sb.toString();
	}
}
