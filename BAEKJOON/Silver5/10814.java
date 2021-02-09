package com.ssafy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SortByAge {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		P[] ps = new P[N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			int order = i;
			ps[i] = new P(age, name, order); 
		}
		
		Arrays.sort(ps, (p1,p2)->{
			if(p1.age == p2.age)
				return p1.order-p2.order;
			return p1.age-p2.age;
		});
		
		for(int i=0;i<N;i++)
			bw.write(ps[i].age+" "+ps[i].name+"\n");
		
		bw.flush();
		br.close();
		bw.close();
	}
}
class P{
	int age;
	String name;
	int order;
	
	P(int age, String name, int order){
		this.age = age;
		this.name = name;
		this.order = order;
	}
}
