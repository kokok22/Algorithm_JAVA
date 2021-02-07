package com.ssafy;

import java.io.*;

public class SugarDelivery {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int five = N/5;
		int three = 0;
		int cnt = -1;
		
		while(five>=0) {
			if((N-5*five)%3!=0)
				five--;
			else {
				three = (N-5*five)/3;
				cnt = five+three;
				break;
			}
		}
		bw.write(cnt+"\n");
		bw.flush();
		br.close();
		bw.close();
	}
}
