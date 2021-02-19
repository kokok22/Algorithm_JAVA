package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class CreateSquareNumber {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		int MAX = (int)Math.sqrt(10000000);
		
		ArrayList<Integer> ps = prime(MAX);
		
		for(int t=0;t<T;t++) {
			int answer = 1;
			int A = Integer.parseInt(br.readLine());
			int num = (int)Math.sqrt(A);
			
			if(num*num != A) {
				for(int p:ps) {
					int cnt = 0;
					
					while(A%p==0) {
						A /= p;
						cnt++;
					}
					
					if(cnt%2!=0)
						answer *= p;
					
					if(A==1 || p>A)
						break;
				}
				if(A>1)
					answer *= A;
			}
			bw.write("#"+(t+1)+" "+answer+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
	
	private static ArrayList<Integer> prime(int MAX) {
		boolean[] arr = new boolean[MAX+1];
		arr[0] = arr[1] = false;
		arr[2] = true;
		
		for(int i=3;i<=MAX;i+=2)
			arr[i] = true;
		
		for(int i=3;i<=Math.sqrt(MAX);i+=2) {
			if(arr[i]) {
				for(int j=i*2;j<=MAX;j+=i) {
					arr[j] = false;
				}
			}
		}
		
		ArrayList<Integer> temp = new ArrayList<Integer>();
		
		for(int i=0;i<MAX+1;i++) {
			if(arr[i])
				temp.add(i);
		}
		
		return temp;
	}
	
}