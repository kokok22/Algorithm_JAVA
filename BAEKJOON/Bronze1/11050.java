package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BinomialCoefficient {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int answer = factorial(N)/(factorial(N-K)*factorial(K));
		
		bw.write(answer+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	private static int factorial(int n) {
		int answer = 1;
		
		for(int i=2;i<n+1;i++)
			answer*=i;
		
		return answer;
	}
}
