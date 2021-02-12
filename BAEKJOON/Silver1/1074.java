package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Z {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int idx = 0;
		while(N!=1) {
			double line = Math.pow(2, N-1);
			
			if(line <= r) {
				idx += Math.pow(2,N)*Math.pow(2, N-1);
				r -= line;
			}
			if(line <= c) {
				c -= line;
				idx += line*line;
			}
			N--;
		}
		idx += r*2+c;
		
		bw.write(idx+"");
		bw.flush();
		br.close();
		bw.close();
	}
}
