package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class DeliciousFood {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] sour = new int[N];
		int[] bitter = new int[N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = dfs(sour, bitter, 0, new boolean[N]);
		
		bw.write(answer+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	private static int dfs(int[] sour, int[] bitter, int idx, boolean[] sel) {
		if(idx == sour.length) {
			int sum_sour = 1;
			int sum_bitter = 0;
			boolean flag = false;
			for(int i=0;i<sour.length;i++) {
				if(sel[i]) {
					sum_sour *= sour[i];
					sum_bitter += bitter[i];
					flag = true;
				}
			}
			if (!flag)
				return Integer.MAX_VALUE;
			return Math.abs(sum_sour - sum_bitter);
		}
		
		sel[idx] = true;
		int num1 = dfs(sour, bitter, idx+1, sel);
		
		sel[idx] = false;
		int num2 = dfs(sour, bitter, idx+1, sel);
		
		return Math.min(num1,num2);
	}
}
