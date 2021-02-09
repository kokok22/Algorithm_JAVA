package com.ssafy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Josephus {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i=N;i>0;i--)
			list.addFirst(i);
		
		StringBuilder sb = new StringBuilder();
		
		int idx = (K-1)%N--;
		sb.append("<"+list.remove(idx));
		
		while(N>0) {
			idx = (idx+K-1)%N--;
			sb.append(", "+list.remove(idx));
		}
		
		bw.write(sb.toString()+">");
		bw.flush();
		br.close();
		bw.close();
	}
}