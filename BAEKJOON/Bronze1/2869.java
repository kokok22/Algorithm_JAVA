package com.ssafy;

import java.io.*;
import java.util.StringTokenizer;

public class ClimbingSnails {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long V = Long.parseLong(st.nextToken());
		
		long day = (V-A)/(A-B)+1;
		if((V-A)%(A-B)!=0)
			day++;
		
		bw.write(day+"");
		bw.flush();
		bw.close();
		br.close();
	}
}
