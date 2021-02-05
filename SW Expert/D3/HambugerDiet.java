package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HambugerDiet {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		int T = Integer.parseInt(s);
		
		for(int t=0;t<T;t++) {
			s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
		
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			
			int[][] material = new int[2][N];
			
			for(int i=0;i<N;i++) {
				s = br.readLine();
				st = new StringTokenizer(s);
			
				material[0][i] = Integer.parseInt(st.nextToken());
				material[1][i] = Integer.parseInt(st.nextToken());
			}
			
			int answer = recursive(material, 0,0,0,L);
			
			System.out.printf("#%d %d\n",t+1, answer);
		}
		
		br.close();
	}

	private static int recursive(int[][] material, int idx,
								int calorie, int score, int Limit) {
		
		int max = score;
		
		if(idx==material[0].length)
			return max;
		else {
			for(int i=idx;i<material[0].length;i++) {
				int ncal = calorie+material[1][i];
				int nscore = score+material[0][i];
				int temp = 0;
				
				if(ncal<=Limit) {
					temp = recursive(material, i+1, ncal, nscore, Limit);
					
					if(max<temp)
						max= temp;
				}
			}
		}
		return max;
	}
}







