package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class MinHeap {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
		
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num==0) {
				if(heap.isEmpty())
					bw.write(0+"\n");
				else
					bw.write(heap.poll()+"\n");
			}else {
				heap.offer(num);
			}
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
