import java.io.*;

public class LostParentheses {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		StringBuilder sb = new StringBuilder();
		
		int sum = 0;
		int num;
		char pre = '+';
		
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if(c-'0'>=0 && c-'0'<10)
				sb.append(c);
			else {
				num = Integer.parseInt(sb.toString());
				sb.setLength(0);
				if(pre=='+')
					sum += num;
				else
					sum -= num;
				
				if(c=='-')
					pre='-';
			}
		}
		
		num = Integer.parseInt(sb.toString());
		if(pre=='-')
			sum -= num;
		else
			sum += num;
		
		bw.write(sum+"");
		bw.flush();
		br.close();
		bw.close();
	}
}
