package com.ssafy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class FishBun {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String answer = "Possible";

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
			st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<N;i++)
				queue.offer(Integer.parseInt(st.nextToken()));
			
			int visit = 0;
			for(int i=0;i<N;i++) {
				int p = queue.poll();
				
				int num = p/M*K-visit;
				visit++;
				if(num<=0) {
					answer = "Impossible";
					break;
				}
			}
			bw.write("#"+(t+1)+" "+answer+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
