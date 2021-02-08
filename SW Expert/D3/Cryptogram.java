package com.ssafy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Cryptogram {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int t=0;t<1;t++) {
			int N = Integer.parseInt(br.readLine());
			LinkedList<Integer> list = new LinkedList<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<N;i++)
				list.add(Integer.parseInt(st.nextToken()));
			
			int n = Integer.parseInt(br.readLine());
			String op = br.readLine();
			st = new StringTokenizer(op);
			
			String[] temp = op.split("I ");
			
			for(int i=0;i<temp.length-1;i++) {
				String _ = st.nextToken();
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				System.out.println(i+" "+_+" "+x+" "+y);
				
				for(int j=0;j<y;j++)
					list.add(x+j, Integer.parseInt(st.nextToken()));
			}
			bw.write("#"+(t+1)+" ");
			for(int i=0;i<10;i++)
				bw.write(list.get(i)+" ");
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}