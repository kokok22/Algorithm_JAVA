package com.ssafy;

import java.io.*;
import java.util.StringTokenizer;

public class WoodCutting {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		long[] trees = new long[N];
		s = br.readLine();
		st = new StringTokenizer(s);
		
		long max = 0;
		long min = 0;
		
		for(int i=0;i<N;i++) {
			trees[i] =Integer.parseInt(st.nextToken());
			max = Math.max(trees[i], max);
		}
		
		long sum=0;
		long mid = 0;
		
		long[] idx = {2000000000, 0};
		
		while(min<=max) {
			sum = 0;
			mid = (max+min)/2;
			
			for(long tree: trees) {
				if(tree>mid)
					sum += tree-mid;
			}
			
			if(sum<M)
				max = mid-1;
			else if(sum>M) {
				if(idx[0]>sum-M) {
					idx[0] = sum-M;
					idx[1] = mid;
				}
				min = mid+1;
			}
			else
				break;
		}
		if(sum-M<0)
			mid = idx[1];
		
		bw.write(mid+"\n");
		bw.flush();
		br.close();
		bw.close();
	}
}
