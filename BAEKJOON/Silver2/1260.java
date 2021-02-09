package com.ssafy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFSnBFS {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N+1][N+1];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			map[A][B] = 1;
			map[B][A] = 1;
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(V);
		Boolean[] chk = new Boolean[N+1];
		Arrays.fill(chk,false);
		
		while(!stack.isEmpty()) {
			int node = stack.pop();
			if(!chk[node])
				chk[node] = true;
			else
				continue;
			
			int idx = N;
			while(idx>=0) {
				if(map[node][idx]==1 && !chk[idx]) {
					stack.push(idx);
				}
				idx--;
			}
			bw.write(node+" ");
		}
		bw.write("\n");
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(V);
		Arrays.fill(chk,false);
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			if(!chk[node])
				chk[node] = true;
			else
				continue;
			
			int idx = 1;
			while(idx<=N) {
				if(map[node][idx]==1 && !chk[idx]) {
					queue.offer(idx);
				}
				idx++;
			}
			bw.write(node+" ");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
