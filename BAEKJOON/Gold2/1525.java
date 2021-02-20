package com.ssafy.algorithm;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Puzzle {
	public static int[] d = {-1, 1, -3, 3};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Queue<String> queue = new LinkedList<String>();
		HashMap<Integer, Boolean> chk = new HashMap<Integer, Boolean>();
		StringBuilder sb = new StringBuilder();
		
		for(int y=0;y<3;y++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int x=0;x<3;x++) {
				String s = st.nextToken();
				if(s.equals("0"))
					s = "9";
				sb.append(s);
			}
		}
		
		queue.offer(sb.toString());
		chk.put(Integer.parseInt(sb.toString()), true);
		int answer = 0;
		boolean flag = false;
		StringBuilder temp = new StringBuilder();
		
		while(!queue.isEmpty()) {
			int n = queue.size();
			
			while(n-->0) {
				sb.setLength(0);
				sb.append(queue.poll());
				
				if(sb.toString().equals("123456789")) {
					bw.write(answer+"");
					flag = true;
					break;
				}
				
				int idx = sb.indexOf("9");
				
				for(int i=0;i<4;i++) {
					if(idx%3==0 && i==0)
						continue;
					if(idx%3==2 && i==1)
						continue;
					
					int nw = idx+d[i];
					int od = idx;
					temp.setLength(0);
					
					if(nw>=0 && nw<9) {
						int a = Math.min(nw,od);
						int b = Math.max(nw,od);
						
						temp.append(sb.substring(0,a));
						temp.append(sb.substring(b,b+1));
						temp.append(sb.substring(a+1,b));
						temp.append(sb.substring(a,a+1));
						temp.append(sb.substring(b+1));
						
						if(!chk.containsKey(Integer.parseInt(temp.toString()))) {
							chk.put(Integer.parseInt(temp.toString()),true);
							queue.offer(temp.toString());
						}
					}
				}
			}
			if(flag)
				break;
			answer++;
		}
		if(!flag)
			bw.write(-1+"");

		bw.flush();
		br.close();
		bw.close();
	}
}

//6 4 7
//8 5 0
//3 2 1

//
//1 0 3
//4 2 5
//7 8 6
