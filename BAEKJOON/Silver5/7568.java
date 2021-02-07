package com.ssafy;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Body {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		ArrayList<int[]> bodys = new ArrayList<int[]>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int[] temp = {Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())};
			bodys.add(temp);
		}
		
		for(int i=0;i<N;i++) {
			int cnt = 1;
			int[] p1 = bodys.get(i);
			
			for(int j=0;j<N;j++) {
				if(i==j)
					continue;
				
				int[] p2 = bodys.get(j);
				
				if(p1[0]<p2[0] && p1[1]<p2[1])
					cnt++;
			}
			bw.write(cnt+" ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
