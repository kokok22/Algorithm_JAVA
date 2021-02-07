package com.ssafy;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Stack;

public class ParenthesisString {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		Stack<Character> stack = new Stack<>();
		
		for(int t=0;t<N;t++) {
			String s = br.readLine();
			String answer = "NO";
			stack.clear();
			
			for(int i=0;i<s.length();i++) {
				char c = s.charAt(i);
				if(c == ')' && !stack.isEmpty() && stack.peek()=='(') {
					stack.pop();
					continue;
				}
				stack.push(c);
			}
			
			if(stack.isEmpty())
				answer = "YES";
			
			bw.write(answer+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
