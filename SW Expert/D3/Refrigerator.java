package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Refrigerator {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		Node[] c = new Node[N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int low = Integer.parseInt(st.nextToken());
			int high = Integer.parseInt(st.nextToken());
			c[i] = new Node(low, high);
		}
		
		Arrays.sort(c);
		
		int cnt = 0;
		int std = -271;
		
		for(Node n:c) {
			if(std<n.low) {
				cnt++;
				std = n.high;
			}
		}
		bw.write(cnt+"");
		bw.flush();
		br.close();
		bw.close();
	}
}

class Node implements Comparable{
	int low;
	int high;

	public Node(int low, int high){
		this.low = low;
		this.high = high;
	}
	
	@Override
	public int compareTo(Object o) {
		Node n = (Node)o;
		int result = this.high-n.high;
		
		return result!=0 ? result : this.low-n.low;
	}
}
