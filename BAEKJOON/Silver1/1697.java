package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HideAndSeek {
	public static int cnt = 0;
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Node> queue = new LinkedList<Node>();
		boolean[] chk = new boolean[100000+1];
		
		queue.offer(new Node(N,0));
		int cnt = 0;
		int answer = Integer.MAX_VALUE;
		boolean flag = true;
		
		while(!queue.isEmpty()) {
			int num = queue.size();
			
			while(num-->0) {
				Node node = queue.poll();
				
				if(node.pos == K) { 					  // 범위 내의 이동으로 도착
					flag = false;
					break;
				}
				
				if(node.pos > 100000 || node.pos <0)  	// 범위 이탈제외
					continue;
				
				if(chk[node.pos])						// 이미 방문 제외
					continue;
				else
					chk[node.pos] = true;
				
				if(node.pos > K) {						 // N이 더 큰 경우에는 뒤로 가는 것 밖에 답이 없다.
					answer = Math.min(answer, cnt+node.pos-K);
					continue;
				}
				
				if(node.direct==0) {    				// 곱하기를 해준 경우에는 좌우 상관없이 이동 가능
					queue.offer(new Node(node.pos-1,-1));
					queue.offer(new Node(node.pos*2,0));
					queue.offer(new Node(node.pos+1,1));
				}else {   								// 좌우 이동의 경우 이동했던 방향으로만 이동 가능
					queue.offer(new Node(node.pos+node.direct, node.direct));
					queue.offer(new Node(node.pos*2,0));
				}
				
			}
			if(!flag) {									// 범위 내 이동으로 도착한 경우 cnt와 answer를 비교
				answer = Math.min(cnt, answer);
				break;
			}
			cnt++;
		}
		bw.write(answer+"");
		bw.flush();
		br.close();
		bw.close();
	}
}

class Node{
	int pos;
	int direct;
	
	Node(int pos, int direct){
		this.pos = pos;
		this.direct = direct;
	}
}
