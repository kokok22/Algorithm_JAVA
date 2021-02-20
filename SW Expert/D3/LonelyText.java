package com.ssafy.algorithm;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class LonelyText {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			String s = br.readLine();
			char[] arr = new char[s.length()];
			
			for(int i=0;i<s.length();i++)
				arr[i] = s.charAt(i);
			
			Arrays.sort(arr);
			Stack<Character> stack = new Stack<Character>();

			for(int i=0;i<s.length();i++) {
				if(!stack.isEmpty() && stack.peek()==arr[i])
					stack.pop();
				else
					stack.push(arr[i]);
			}
			
			StringBuilder answer = new StringBuilder();
			
			if(stack.isEmpty())
				answer.append("Good");
			else {
				for(int i=0;i<stack.size();i++)
					answer.append(stack.get(i));
			}	
			bw.write("#"+(t+1)+" "+answer+"\n");	
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
