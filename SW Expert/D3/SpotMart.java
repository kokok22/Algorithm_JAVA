package com.ssafy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SpotMart {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] snack = new int[N];
			st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<N;i++)
				snack[i] = Integer.parseInt(st.nextToken());
			
			int weight = dfs(snack, new int[2],0,0,M);
			int answer = -1;
			
			if(weight!=0)
				answer = weight;
			bw.write("#"+(t+1)+" "+answer+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
	
	private static int dfs(int[] snack, int[] sel, int idx, int k, int M) {
		if(k==sel.length) {
			int sum = 0;
			for(int w:sel)
				sum += w;
			
			if(sum>M)
				return 0;
			return sum;
		}
		
		int max = 0;
		for(int i=idx;i<snack.length;i++) {
			sel[k] = snack[i];
			int w = dfs(snack,sel,i+1,k+1,M);
			if(w>max)
				max=w;
		}
		return max;
	}
}
