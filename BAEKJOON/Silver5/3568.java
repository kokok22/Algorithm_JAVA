import java.util.*;
import java.io.*;

public class iSharp {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine().replaceAll(", ", " ");
		
		String[] arr = s.substring(0, s.length()-1).split(" ");
		
		for(int i=1;i<arr.length;i++) {
			bw.write(arr[0]+"");
			
			Stack<Character> stack = new Stack<Character>();
			StringBuilder sb = new StringBuilder();
			
			for(int j=0;j<arr[i].length();j++) {
				char c = arr[i].charAt(j);
				
				if((c>='a' && c<='z') || (c>='A' && c<='Z'))
					sb.append(c);
				else {
					if(c=='[') {
						j++;
						stack.push(']');
						stack.push('[');
					}
					else
						stack.push(c);
				}
			}
			
			while(!stack.isEmpty())
				bw.write(stack.pop());
			bw.write(" "+sb.toString()+";"+"\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
}
