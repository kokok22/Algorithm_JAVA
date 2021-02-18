package com.ssafy.algorithm;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Editer {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		
		Stack<Character> l = new Stack<Character>();
		Stack<Character> r = new Stack<Character>();
		
		for(int i=0;i<s.length();i++)
			l.push(s.charAt(i));
		
		int M = Integer.parseInt(br.readLine());
		
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char op = st.nextToken().charAt(0);
			
			if(op=='L' && !l.isEmpty())
				r.push(l.pop());
			else if(op=='D' && !r.isEmpty())
				l.push(r.pop());
			else if(op=='B' && !l.isEmpty())
				l.pop();
			else if(op=='P') {
				char alpha = st.nextToken().charAt(0);
				l.push(alpha);
			}
		}
		for(int i=0;i<l.size();i++)
			bw.write(l.get(i));
		for(int i=r.size()-1;i>=0;i--)
			bw.write(r.get(i));
		
		bw.flush();
		br.close();
		bw.close();
	}
}
