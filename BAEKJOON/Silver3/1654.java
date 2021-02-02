package com.ssafy;

import java.util.Arrays;
import java.util.Scanner;

public class CutCable {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int K = sc.nextInt();
		long N = sc.nextLong();
		long[] cables = new long[K];
		
		long sum = 0;
		for(int i=0;i<K;i++) {
			cables[i] = sc.nextLong();
			sum += cables[i];
		}
			
		Arrays.sort(cables);
		
		long max = cables[K-1];
		long min = 1;
		
		while(min<=max) {
			long middle = (max+min)/2;
			long cnt = 0;
			for(int i=0;i<K;i++)
				cnt += cables[i]/middle;
			
			if(cnt>=N)
				min = middle+1;
			else if(cnt<N)
				max = middle-1;
		}
		System.out.println(max);
		sc.close();
	}
}
