import java.util.*;
import java.io.*;

public class Postfix {
	public static HashMap<Character, Integer> set = new HashMap<Character, Integer>();
	

	public static void main(String[] args) throws IOException {
		set.put('+', 1);
		set.put('-', 1);
		set.put('*', 2);
		set.put('/', 2);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		
		Stack<Character> stack = new Stack<Character>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			
			if(c>='A' && c<='Z')
				sb.append(c);
			
			else if(c=='(')
				stack.push(c);
			
			else if(c==')') {
				while(true) {
					char temp = stack.pop();
					
					if(temp=='(')
						break;
					
					sb.append(temp);
				}
			}
			
			else if(c=='*' || c=='/' || c=='+' || c=='-') {
				if(!stack.isEmpty()) {
					char temp = stack.peek();
					
					while(!stack.isEmpty() && temp!='(' && set.get(c)<=set.get(temp)) {
						sb.append(stack.pop());
						if(!stack.isEmpty())
							temp = stack.peek();
					}
				}
				stack.push(c);
			}
		}
		
		while(!stack.isEmpty()) {
			char c = stack.pop();
			
			if(c=='+' || c=='-' || c=='*' || c=='/')
				sb.append(c);
		}
		
		bw.write(sb.toString()+"");
		bw.flush();
		br.close();
		bw.close();
	}
}