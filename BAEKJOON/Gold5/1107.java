package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class RemoteControl {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String n = br.readLine();
		int N = Integer.parseInt(n);
		int M = Integer.parseInt(br.readLine());
		int size = n.length();
		
		boolean[] nums = new boolean[10];
		
		if(M!=0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<M;i++) {
				int num = Integer.parseInt(st.nextToken());
				nums[num] = true;
			}
		}
		
		int[] t2 = new int[size+1];
		for(int i=1;i<9;i++) {
			if(!nums[i]) {
				t2[0] = i;
				break;
			}
		}

		int num = Math.min(dfs(N, nums, 0, new int[size]),dfs(N, nums, 1, t2));
		
		if(size>1) {
			int[] t1 = new int[size-1];
			for(int i=9;i>=0;i--) {
				if(!nums[i]) {
					t1[0] = i;
					break;
				}
			}
					
			num = Math.min(num, dfs(N, nums, 1, t1));
		}
		
		bw.write(num+"\n");
		bw.flush();
		br.close();
		bw.close();
	}
	
	private static int dfs(int N, boolean[] chk, int k, int[] sel) {
		int answer = Math.abs(100-N);
		
		if(k==sel.length) {
			int num = 0;
			for(int i=0;i<sel.length;i++)
				num += sel[i]*Math.pow(10, sel.length-1-i);
			
			return Math.abs(N-num)+Integer.toString(num).length();
		}
		
		for(int i=0;i<10;i++) {
			if(!chk[i]) {
				sel[k] = i;
				answer = Math.min(answer, dfs(N,chk,k+1,sel));
			}
		}
		return answer;
	}
}
