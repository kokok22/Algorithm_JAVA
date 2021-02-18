package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class PocketMonMaster {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> int_map = new HashMap<String, Integer>();
		String[] str_map = new String[N];
		
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			int_map.put(s, i+1);
			str_map[i] = s;
		}
		
		for(int i=0;i<M;i++) {
			String in = br.readLine();
			if(in.charAt(0)>='0' && in.charAt(0)<='9') {
				int num = Integer.parseInt(in);
				bw.write(str_map[num-1]+"\n");
			}else
				bw.write(int_map.get(in)+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
