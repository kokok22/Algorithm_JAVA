package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Make1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(N);
		int cnt = 0;
		boolean flag = false;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			while(size-->0) {
				int num = queue.poll();
				if(num==1) {
					flag = true;
					break;
				}
					
				if(num%3==0)
					queue.offer(num/3);
				if(num%2==0)
					queue.offer(num/2);
				queue.offer(num-1);
			}
			if(flag) {
				bw.write(cnt+"");
				break;
			}
			cnt++;
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
