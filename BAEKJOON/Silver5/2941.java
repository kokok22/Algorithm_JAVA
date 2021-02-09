package com.ssafy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CroatianAlphabet {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] alpha = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		StringBuilder sb = new StringBuilder(br.readLine());
		
		int answer = 0;
		for(String a:alpha) {
			while(sb.toString().contains(a)) {
				int idx = sb.indexOf(a);
				sb.delete(idx, idx+a.length());
				sb.insert(idx, " ");
				answer++;
			}
		}
		answer += sb.toString().replace(" ", "").length();
		
		bw.write(answer+"");
		bw.flush();
		bw.close();
		br.close();
		
	}
}
