package com.ssafy.algorithm;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Trust {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			
			Queue<Integer> B = new LinkedList<Integer>();
			Queue<Integer> O = new LinkedList<Integer>();
			
			Queue<Character> order = new LinkedList<Character>();
			
			for(int i=0;i<N;i++) {
				char c = st.nextToken().charAt(0);
				int idx = Integer.parseInt(st.nextToken());
				
				if(c=='B')
					B.offer(idx);
				else
					O.offer(idx);
				order.offer(c);
			}
			
			int cnt = 0;
			int pre_b = 1;
			int pre_o = 1;
			
			int now_b = -1;
			int now_o = -1;
			
			int temp;
			
			while(!order.isEmpty()) {	
				if(!B.isEmpty() && now_b==-1) {
					temp = B.poll();
					now_b = Math.abs(temp-pre_b);
					pre_b = temp;
				}
				
				if(!O.isEmpty() && now_o==-1) {
					temp = O.poll();
					now_o = Math.abs(temp-pre_o);
					pre_o = temp;
				}
				
				char op = order.poll();
				
				if(op=='B') {
					cnt += now_b+1;
					if(now_b+1 > now_o)
						now_o = 0;
					else
						now_o -= now_b+1;
					now_b = -1;
				}else {
					cnt += now_o+1;
					if(now_o+1 > now_b)
						now_b = 0;
					else
						now_b -= now_o+1;
					now_o = -1;
				}
				
			}
			bw.write("#"+(t+1)+" "+cnt+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
