package com.ssafy.algorithm;

import java.io.*;
import java.util.Stack;

public class MirrorImage {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Stack<Character> stack = new Stack<Character>();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			String s = br.readLine();
			
			for(int i=0;i<s.length();i++) {
				char c = s.charAt(i);
				if(c=='b')
					stack.push('d');
				else if(c=='d')
					stack.push('b');
				else if(c=='p')
					stack.push('q');
				else if(c=='q')
					stack.push('p');
			}
			StringBuilder answer = new StringBuilder();
			while(!stack.isEmpty())
				answer.append(stack.pop());
			
			bw.write("#"+(t+1)+" "+answer+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
