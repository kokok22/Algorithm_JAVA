package com.ssafy.algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class JumpJump {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int p1 = Integer.parseInt(st.nextToken());
		int p2 = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		int cnt = 1000;
		
		while(p1!=p2 && cnt-->0) {
			if(p1<p2)
				p1 += X;
			else
				p2 += Y;
		}
		answer = p1;
		if(cnt<=0)
			answer = -1;
		
		bw.write(answer+"\n");
		bw.flush();
		br.close();
		bw.close();
	}
}
