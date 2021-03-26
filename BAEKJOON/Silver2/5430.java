import java.io.*;

public class AC {
	public static void main(String[] agrs) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			String s = br.readLine();
			int n = Integer.parseInt(br.readLine());
			
			String sb = br.readLine();
			String[] arr = sb.substring(1, sb.length()-1).split(",");
			
			int order = 1;
			int start = 0;
			int end = arr.length;
			
			boolean flag = true;
			
			for(int i=0;i<s.length();i++) {
				char c = s.charAt(i);
				
				if(c=='R')
					order *= -1;
				else if(c=='D') {
					if(n==0) {
						flag = false;
						break;
					}
					if(order==1)
						start +=1;
					else
						end -=1;
					n--;
				}
			}
			if(flag)
				bw.write(print(arr, order, start, end)+"\n");
			else
				bw.write("error\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static String print(String[] arr, int order, int start, int end) {
		StringBuilder sb = new StringBuilder();
		
		int n = arr.length;
		sb.append("[");
		
		if(order==1) {
			for(int i=start;i<end;i++) {
				sb.append(arr[i]);
				if(i!=end-1)
					sb.append(",");
			}
		}
		else {
			for(int i=end-1;i>=start;i--) {
				sb.append(arr[i]);
				if(i!=start)
					sb.append(",");
			}	
		}
		sb.append("]");
		return sb.toString();
	}
}
