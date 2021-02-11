package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class MyDeque {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new LinkedList<Integer>();
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String op = st.nextToken();
			int num;
			
			switch(op) {
			case "push_back":
				num = Integer.parseInt(st.nextToken());
				deque.offerLast(num);
				break;
			case "push_front":
				num = Integer.parseInt(st.nextToken());
				deque.offerFirst(num);
				break;
			case "front":
				if(deque.isEmpty())
					bw.write(-1+"\n");
				else
					bw.write(deque.peekFirst()+"\n");
				break;
			case "back":
				if(deque.isEmpty())
					bw.write(-1+"\n");
				else
					bw.write(deque.peekLast()+"\n");
				break;
			case "pop_front":
				if(deque.isEmpty())
					bw.write(-1+"\n");
				else
					bw.write(deque.pollFirst()+"\n");
				break;
			case "pop_back":
				if(deque.isEmpty())
					bw.write(-1+"\n");
				else
					bw.write(deque.pollLast()+"\n");
				break;
			case "size":
				bw.write(deque.size()+"\n");
				break;
			case "empty":
				if(deque.isEmpty())
					bw.write(1+"\n");
				else
					bw.write(0+"\n");
				break;
			}
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
