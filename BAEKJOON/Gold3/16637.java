import java.io.*;
import java.util.*;

public class AddParentheses {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		long[] numbers = new long[N/2+1];
		char[] ops = new char[N/2];
		
		String s = br.readLine();
		
		for(int i=0;i<N;i++) {
			char c = s.charAt(i);
			
			if(i%2==0)
				numbers[i/2] = Integer.parseInt(c+"");
			else
				ops[i/2] = c;
		}
		
		long cnt = recursive(numbers, ops, 0);
		
		bw.write(cnt+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void print(long[] nums, char[] ops) {
		for(int i=0;i<nums.length;i++)
			System.out.print(nums[i]+" ");
		System.out.println();
		
		for(int i=0;i<ops.length;i++)
			System.out.print(ops[i]);
		System.out.println();
	}
	
	public static long recursive(long[] numbers, char[] ops, int idx) {
		long sum = Integer.MIN_VALUE;
		
		// 마지막 숫자는 괄호의 시작이 될 수 없다.
		if(idx>=numbers.length-1) {
			sum = numbers[0];
			for(int i=1;i<numbers.length;i++)
				sum = cal(sum, numbers[i], ops[i-1]);
//			print(numbers, ops);
//			System.out.println(sum);
			return sum;
		}
		
		// 해당 idx에 괄호가 들어가는 경우
		long num1 = numbers[idx];
		long num2 = numbers[idx+1];
		char op = ops[idx];
		
		long num = cal(num1,num2,op);
		
		// 바꿔주기
		numbers[idx] = num;
		numbers[idx+1] = 0;
		ops[idx] = '+';
		
		sum = Math.max(sum, recursive(numbers, ops, idx+2));
		
		// 복구
		numbers[idx] = num1;
		numbers[idx+1] = num2;
		ops[idx] = op;
		
		// 해당 idx가 괄호에 들어가지 않는 경우
		sum = Math.max(sum, recursive(numbers, ops, idx+1));
		
		return sum;
	}
	
	public static long cal(long num1, long num2, char op) {
		long num = num1;
		
		if(op=='-')
			num -= num2;
		else if(op=='+')
			num += num2;
		else if(op=='*')
			num *= num2;
		
		return num;
	}
}
