import java.io.*;
import java.util.*;

public class Bracket {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		Stack<String> stack = new Stack<String>();
		Stack<Character> chk = new Stack<Character>();
		
		boolean flag = true;
		
		// 올바른 괄호인지 확인
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			
			if(c=='[' || c=='(')
				chk.push(c);
			else {
				if(chk.isEmpty()) {
					flag = false;
					break;
				}
				
				char temp = chk.pop();
				if(c==']' && temp!='[') {
					flag = false;
					break;
				}else if(c==')' && temp!='(') {
					flag = false;
					break;
				}
			}
		}
		
		if(!chk.isEmpty())
			flag = false;
		
		
		if(!flag)
			bw.write(0+"");
		// 계산하는 과정
		else {
			for(int i=0;i<s.length();i++) {
				char c = s.charAt(i);
				
				if(c=='[' || c=='(') {
					stack.push(c+"");
				} else if(c==']' || c==')') {
					String temp = stack.pop();
					int sum = 0;
					
					while(!temp.equals("[") && !temp.equals("(")) {
						sum += Integer.parseInt(temp);
						temp = stack.pop();
					}
					
					if(sum==0)
						sum=1;
					
					if(temp.equals("["))
						sum *= 3;
					else if(temp.equals("("))
						sum *= 2;
					
					stack.push(Integer.toString(sum));
				}
			}
			
			int result = 0;
			
			while(!stack.isEmpty()) {
				String num = stack.pop();
				result += Integer.parseInt(num);
			}
			bw.write(result+"");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
}