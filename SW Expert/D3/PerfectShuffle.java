package com.ssafy;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class PerfectShuffle {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=0;t<T;t++) {
			int N = sc.nextInt();
			Queue<String> queue1 = new LinkedList<>();
			Queue<String> queue2 = new LinkedList<>();
			
			for(int i=0;i<N/2+N%2;i++)
				queue1.add(sc.next());
			for(int i=N/2+N%2;i<N;i++)
				queue2.add(sc.next());
			
			System.out.printf("#%d ",t+1);
			for(int i=0;i<N;i++) {
				if(i%2==0)
					System.out.print(queue1.poll()+" ");
				if(i%2==1)
					System.out.print(queue2.poll()+" ");
			}
			System.out.println();
		}
	}
}
