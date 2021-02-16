package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class WhoAreU {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] noSee = new String[N];
		for(int i=0;i<N;i++)
			noSee[i] = br.readLine();
		
		String[] noHear = new String[M];
		for(int i=0;i<M;i++)
			noHear[i] = br.readLine();
		
		Arrays.sort(noSee);
		Arrays.sort(noHear);
		
		LinkedList<String> answer = new LinkedList<String>();
		
		int idx1 = 0;
		int idx2 = 0;
		
		while(idx1<N && idx2<M) {
			int p = noSee[idx1].compareTo(noHear[idx2]);
			
			if(p==0) {
				answer.offerLast(noSee[idx1]);
				idx1++;
				idx2++;
			}else if(p<0) {
				idx1++;
			}else {
				idx2++;
			}
		}
		bw.write(answer.size()+"\n");
		for(String ans : answer)
			bw.write(ans+"\n");
		
		bw.flush();
		br.close();
		bw.close();
	}
}
