package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MeetingRoom {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		Node[] arr = new Node[N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			arr[i] = new Node(s,e);
		}
		
		Arrays.sort(arr);
		int cnt = 1;
		int pre = arr[0].end;
		
		for(int i=1;i<arr.length;i++) {
			if(pre<=arr[i].start) {
				cnt++;
				pre = arr[i].end;
			}
		}
		
		bw.write(cnt+"");
		bw.flush();
		br.close();
		bw.close();
	}
}
class Node implements Comparable{
	int start;
	int end;
	
	Node(int start, int end){
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Object o) {
		Node n = (Node)o;
		if(this.end==n.end)
			return this.start-n.start;
		return this.end-n.end;
	}
}
