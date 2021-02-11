package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AlignCorrdinates {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] dot = new int[N][2];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			dot[i][0] = Integer.parseInt(st.nextToken());
			dot[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(dot,(x1,x2) -> {
			if(x1[0] == x2[0])
				return x1[1]-x2[1];
			return x1[0]-x2[0];
		});
		
		for(int[] p : dot)
			bw.write(p[0]+" "+p[1]+"\n");
		
		bw.flush();
		br.close();
		bw.close();
	}
}
