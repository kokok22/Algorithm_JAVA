package com.ssafy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Stack;

public class MyStack {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String op = st.nextToken();
			int idx = 0;
			
			switch(op) {
			case "push":
				int num = Integer.parseInt(st.nextToken());
				stack.push(num);
				break;
			case "pop":
				if(stack.isEmpty())
					bw.write(-1+"\n");
				else
					bw.write(stack.pop()+"\n");
				break;
			case "size":
				bw.write(stack.size()+"\n");
				break;
			case "empty":
				if(stack.empty())
					bw.write(1+"\n");
				else
					bw.write(0+"\n");
				break;
			case "top":
				if(stack.empty())
					bw.write(-1+"\n");
				else
					bw.write(stack.peek()+"\n");
				break;
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
