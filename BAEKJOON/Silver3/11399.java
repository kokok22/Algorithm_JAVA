package com.ssafy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ATM {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		ArrayList<Integer> p = new ArrayList<Integer>();
		
		for(int i=0;i<N;i++) {
			p.add(sc.nextInt());
		}
		
		Collections.sort(p);
		int sum=0;
		
		for(int i=0;i<N-1;i++) {
			sum += p.get(i);
			p.set(i+1, p.get(i)+p.get(i+1));
		}
		
		sum += p.get(N-1);
		
		System.out.println(sum);
		
		sc.close();
	}
}
