package com.ssafy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class MyQueue {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		int last = -1;
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String op = st.nextToken();
			int idx = 0;
			
			switch(op) {
			case "push":
				int num = Integer.parseInt(st.nextToken());
				queue.offer(num);
				last = num;
				break;
			case "pop":
				if(queue.isEmpty())
					bw.write(-1+"\n");
				else
					bw.write(queue.poll()+"\n");
				break;
			case "size":
				bw.write(queue.size()+"\n");
				break;
			case "empty":
				if(queue.isEmpty())
					bw.write(1+"\n");
				else
					bw.write(0+"\n");
				break;
			case "front":
				if(queue.isEmpty())
					bw.write(-1+"\n");
				else
					bw.write(queue.peek()+"\n");
				break;
			case "back":
				if(queue.isEmpty())
					last = -1;
				bw.write(last+"\n");
				break;
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
