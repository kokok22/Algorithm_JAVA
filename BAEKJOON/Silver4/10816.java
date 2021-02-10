package com.ssafy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class NumberCard2 {
	public static int MAX = 2000000;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			long num = Long.parseLong(st.nextToken());
			int cnt = 0;

			if(map.containsKey(num))
				cnt = map.get(num);
			map.put(num, cnt+1);
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<M;i++) {
			long num = Long.parseLong(st.nextToken());
			int cnt = 0;
			
			if(map.containsKey(num))
				cnt = map.get(num);
			bw.write(cnt+" ");

		}
		bw.write("\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
