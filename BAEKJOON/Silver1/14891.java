package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class GearWheels {
	public static int cnt = 0;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		LinkedList<Integer> w1 = new LinkedList<Integer>();
		LinkedList<Integer> w2 = new LinkedList<Integer>();
		LinkedList<Integer> w3 = new LinkedList<Integer>();
		LinkedList<Integer> w4 = new LinkedList<Integer>();
		
		LinkedList[] wheels = {w1, w2, w3, w4};
		
		for(int i=0;i<4;i++) {
			String s = br.readLine();
			for(int j=0;j<s.length();j++)
				wheels[i].addFirst(Integer.parseInt(s.charAt(s.length()-j-1)+""));
		}
		
		int K = Integer.parseInt(br.readLine());
		
		for(int i=0;i<K;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken())-1;
			int direct = Integer.parseInt(st.nextToken());
			
			spinleft(wheels, idx-1, direct*-1);
			spinright(wheels, idx+1, direct*-1);
			
			if(direct==1)
				wheels[idx].addFirst(wheels[idx].removeLast());
			else
				wheels[idx].addLast(wheels[idx].removeFirst());
		}
		
		int answer = 0;
		for(int i=0;i<wheels.length;i++) {
			answer += Math.pow(2, i)*(int)wheels[i].peekFirst();
		}
		bw.write(answer+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	private static void spinleft(LinkedList[] wheels, int idx, int direct) {
		if(idx < 0 || idx > wheels.length-1)
			return;
		
		if(wheels[idx].get(2) != wheels[idx+1].get(6)) {
			spinleft(wheels, idx-1,direct*-1);
			if(direct==1)
				wheels[idx].addFirst(wheels[idx].removeLast());
			else
				wheels[idx].addLast(wheels[idx].removeFirst());
		}
	}
	
	private static void spinright(LinkedList[] wheels, int idx, int direct) {
		if(idx<0 || idx > wheels.length-1)
			return;
		
		if(wheels[idx].get(6) != wheels[idx-1].get(2)) {
			spinright(wheels,idx+1,direct*-1);
			if(direct==1)
				wheels[idx].addFirst(wheels[idx].removeLast());
			else
				wheels[idx].addLast(wheels[idx].removeFirst());
		}
	}
}
