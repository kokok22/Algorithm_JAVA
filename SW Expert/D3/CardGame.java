package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class CardGame {
	public static int total = 9*8*7*6*5*4*3*2;
	public static int cnt = 10;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			int[] card = new int[9];
			boolean[] chk = new boolean[18];
			int[] card2 = new int[9];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<9;i++) {
				card[i] = Integer.parseInt(st.nextToken());
				chk[card[i]-1] = true;
			}
			int idx = 0;
			for(int i=0;i<18;i++) {
				if(!chk[i])
					card2[idx++] = i+1;
			}
			
			int answer = dfs(card, card2, 0, new boolean[9], new int[9]);
			bw.write("#"+(t+1)+" "+answer+" "+(total-answer)+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static int dfs(int[] card, int[] card2, int k, boolean[] chk, int[] sel) {
		int answer = 0;
		if(k==card.length) {
			int sum = 0;
			
			for(int i=0;i<9;i++) {
				if(card[i] > card2[sel[i]])
					sum += card[i] + card2[sel[i]];
				else
					sum -= (card[i] + card2[sel[i]]);
			}

			if(sum<0)
				return 0;
			else
				return 1;
		}
		for(int i=0;i<9;i++) {
			if(!chk[i]) {
				chk[i] = true;
				sel[k] = i;
				answer += dfs(card, card2, k+1, chk, sel);
				chk[i] = false;
			}
		}
		return answer;
	}
}
