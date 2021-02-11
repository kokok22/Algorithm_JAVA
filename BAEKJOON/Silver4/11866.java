package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Josephus0 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer> arr = new LinkedList<Integer>();
		
		for(int i=1;i<N+1;i++)
			arr.offerLast(i);
		bw.write("<"+arr.remove(K-1));
		int idx = K-1;
		
		while(!arr.isEmpty()) {
			idx = (idx+K-1)%arr.size();
			bw.write(", "+arr.remove(idx));
		}
		bw.write(">");
		bw.flush();
		br.close();
		bw.close();
	}
}
