package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class MonsterHunting {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double D = Double.parseDouble(st.nextToken());
			double L = Double.parseDouble(st.nextToken());
			double N = Double.parseDouble(st.nextToken());
			
			double sum = 0;
			for(int i=0;i<N;i++)
				sum += D*(1+i*L/100);
			bw.write("#"+(t+1)+" "+(int)sum+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
