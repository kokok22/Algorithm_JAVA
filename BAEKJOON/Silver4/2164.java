package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Card2 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		Queue<Integer> queue = new LinkedList<>();
		
		int num = Integer.parseInt(st.nextToken());
		
		for(int i=1;i<=num;i++)
			queue.add(i);
		
		// 1자리 숫자만 있는 것이 아니기 때문에 string으로 하면 안된다.
		while(queue.size()>1) {
			queue.poll();
			queue.add(queue.poll());
		}
		
		System.out.println(queue.poll());

		br.close();
	}
}