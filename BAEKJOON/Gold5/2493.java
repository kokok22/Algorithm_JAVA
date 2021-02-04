package com.ssafy;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Top {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {

		int N = Integer.parseInt(br.readLine());
		String nums = br.readLine();
		StringTokenizer st = new StringTokenizer(nums);
		
		Stack<int[]> stack = new Stack<>();

		int[] answer = new int[N];
		
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(st.nextToken());
			
			while(!stack.empty()) {
				int[] temp = stack.peek();
				
				if(temp[0]>=num) {
					answer[i] = temp[1]; 
					break;
				}
				else
					stack.pop();
			}
			int[] item = {num,i+1};
			stack.push(item);
		}
		
		for(int ans : answer)
			bw.write(ans+" ");
		
		bw.flush();
		br.close();
		bw.close();
	}
}
