package com.ssafy;

import java.util.Arrays;
import java.util.Scanner;

public class WordSorting {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		String[] words = new String[N];
		
		for(int i=0;i<N;i++)
			words[i] = sc.next();
		
		// lambda를 활용한 정렬
		Arrays.sort(words,(w1,w2) -> {
			if(w1.length() == w2.length())
				return w1.compareTo(w2);
			else
				return w1.length()-w2.length();
		});
		
		String pre = "";
		for(String word:words) {
			if(!pre.equals(word))
				System.out.println(word);
			pre = word;
		}
		sc.close();
	}
}