package com.ssafy;

import java.util.Scanner;

public class GCD {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		if(A<B) {
			int temp = A;
			A = B;
			B = temp;
		}
		
		int g = gcd(A,B);
		int l = A*B/g;
		
		System.out.println(g);
		System.out.println(l);
		
		sc.close();
	}
	
	private static int gcd(int a, int b) {
		if(b==0)
			return a;
		return gcd(b, a%b);
	}
}
