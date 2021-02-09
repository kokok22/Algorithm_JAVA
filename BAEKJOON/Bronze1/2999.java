package com.ssafy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SecretEmail {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String message = br.readLine();
		
		int N = message.length();
		
		int R = 1;
		int C = N;
		for(int i=(int)Math.sqrt(N);i>0;i--) {
			if(N%i==0) {
				R=i;
				C=N/i;
				break;
			}
		}
		
		char[][] m = new char[R][C];
		
		int cnt=0;
		for(int j=0;j<C;j++) {
			for(int i=0;i<R;i++)
				m[i][j] = message.charAt(cnt++);
		}
		
		for(int j=0;j<R;j++) {
			for(int i=0;i<C;i++)
				bw.write(m[j][i]); 
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
