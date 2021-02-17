package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ChickenDelivery {
	public static ArrayList<int[]> home;
	public static ArrayList<int[]> store;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		home = new ArrayList<int[]>();
		store = new ArrayList<int[]>();
		
		for(int y=0;y<N;y++) {
			st = new StringTokenizer(br.readLine());
			for(int x=0;x<N;x++) {
				int num = Integer.parseInt(st.nextToken());
				int[] temp = {y,x};
				if(num==1)
					home.add(temp);
				else if(num==2)
					store.add(temp);
			}
		}
		
		int answer = search(new boolean[store.size()], 0, 0, M);
		
		bw.write(answer+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	private static int search(boolean[] sel, int k, int idx, int max) {		
		if(k==max || idx==sel.length) {
			if(k==0)
				return Integer.MAX_VALUE;
			
			int sum = 0;
			for(int i=0;i<home.size();i++) {
				int y1 = home.get(i)[0];
				int x1 = home.get(i)[1];
				
				int min = Integer.MAX_VALUE;
				for(int j=0;j<sel.length;j++) {
					if(sel[j]) {
						int y2 = store.get(j)[0];
						int x2 = store.get(j)[1];
						
						min = Math.min(min, Math.abs(x2-x1)+Math.abs(y2-y1));
					}
				}
				sum+= min;
			}		
			return sum;
		}
		
		sel[idx] = true;
		int num1 = search(sel, k+1, idx+1, max);
		
		sel[idx] = false;
		int num2 = search(sel, k, idx+1, max);
		
		return Math.min(num1, num2);
	}
}
