import java.util.*;
import java.io.*;

public class PostFix {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		double[] num = new double[N];
		
		String s = br.readLine();
		
		for(int i=0;i<N;i++)
			num[i] = Double.parseDouble(br.readLine());
		
		Stack<Double> stack = new Stack<Double>();
		
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			
			if(c-'A'>=0 && c-'Z' <=0)
				stack.push(num[c-'A']);
			else {
				double n1 = stack.pop();
				double n2 = stack.pop();
				
				if(c=='+')
					stack.push(n2+n1);
				else if(c=='*')
					stack.push(n2*n1);
				else if(c=='-')
					stack.push(n2-n1);
				else if(c=='/')
					stack.push(n2/n1);
			}
		}
		
		double result = stack.pop();
		
		System.out.printf("%.2f",result);
		br.close();
	}
}
