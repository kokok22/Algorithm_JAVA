package com.ssafy;

import java.util.Scanner;

public class Password {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		for(int t=0;t<10;t++) {
			String answer = "";				// 정답
			
			int num = sc.nextInt();			// 문자열 길이
			int start = 0;
			int end = 1;
			
			String numbers = sc.next();		// 문자열
			
			int[] idx = new int[num];		// 삭제 여부 확인
			
			while(end < num) {
//				System.out.println(start+","+end);
				if(idx[start]==0) {
					if(numbers.substring(start,start+1).equals(numbers.substring(end, end+1))){
						idx[start--]=1;
						idx[end++]=1;
					}
					else {
						start = end;
						end += 1;
					}
				}
				else
					start--;
				
				if(start<0) {
					start = end;
					end +=1;
				}
			}
			
			for(int i=0;i<num;i++) {
				if(idx[i]==0)
					answer+=numbers.substring(i,i+1);
			}

			System.out.printf("#%d %s\n",t+1,answer);
		}
	}
}
