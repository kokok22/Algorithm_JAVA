package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class RollCake {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		int[] cake = new int[L+1];
		
		int[] max = {0,0};
		int[] hope = {0,0};
		
		for(int i=1;i<N+1;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cnt = 0;
			
			for(int j=start;j<=end;j++) {
				if(cake[j]==0) {
					cnt++;
					cake[j]=i;
				}
			}
			if(max[0]<cnt) {
				max[0] = cnt;
				max[1] = i;
			}
			if(hope[0]<end-start+1) {
				hope[0] = end-start+1;
				hope[1] = i;
			}
		}
		bw.write(hope[1]+"\n"+max[1]);
		bw.flush();
		br.close();
		bw.close();
	}
}
