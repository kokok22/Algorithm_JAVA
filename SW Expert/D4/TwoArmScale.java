package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class TwoArmScale {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			int[] map = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<N;i++)
				map[i] = Integer.parseInt(st.nextToken());
			
			int cnt = dfs(map, new boolean[N], 0, 0, 0);
			
			bw.write("#"+(t+1)+" "+cnt+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
	
	private static int dfs(int[] map, boolean[] chk, int R, int L, int idx) {
		int answer = 0;
		int N = map.length;
		
		if(idx==N)
			return 1;
		
		for(int i=0;i<N;i++) {
			if(!chk[i]) {
				chk[i] = true;
				
				// L쪽에 넣어보기
				L += map[i];
				if(L>=R) 
					answer += dfs(map, chk, R, L, idx+1);
				L -= map[i];
				
				// R쪽에 넣어보기
				R += map[i];
				if(L>=R)
					answer += dfs(map, chk, R, L, idx+1);
				R -= map[i];
				
				chk[i] = false;
			}
		}
		return answer;
	}
}