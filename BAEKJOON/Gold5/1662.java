import java.io.*;
import java.util.*;

public class Compression {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Stack<Num> stack = new Stack<Num>();
		
		int result=0;
		String s = br.readLine();
		
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			
			if(c==')') {
				
				Num num = stack.pop();
				char pre = num.value;
				int temp = 0;
				
				while(num.value!='(') {
					temp += num.length;
					num = stack.pop();
				}
				
				char ct = stack.pop().value;
				
				int cnt = Integer.parseInt(ct+"");
				temp *= cnt;
				
				if(pre=='(')
					pre='0';
				
				stack.push(new Num(pre, temp));
			}else
				stack.push(new Num(c, 1));
		}
		
		while(!stack.isEmpty()) {
			Num num = stack.pop();
			result += num.length;
		}
		
		bw.write(result+"");
		bw.flush();
		br.close();
		bw.close();
	}
}
class Num{
	char value;
	int length;
	
	public Num(char value, int length) {
		this.value = value;
		this.length = length;
	}
}
