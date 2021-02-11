package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AlignCoordinates2 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int N = Integer.parseInt(br.readLine());
		
		int[][] spot = new int[N][2];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			spot[i][0] = Integer.parseInt(st.nextToken());
			spot[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(spot, (x1,x2) -> {
			if(x1[1]==x2[1])
				return x1[0]-x2[0];
			return x1[1]-x2[1];
		});
		
		for(int[] s:spot)
			bw.write(s[0]+" "+s[1]+"\n");
		bw.flush();
		br.close();
		bw.close();
	}
}
