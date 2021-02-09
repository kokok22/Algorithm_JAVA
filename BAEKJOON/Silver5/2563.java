package com.ssafy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ColoredPaper {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[100][100];
		int answer = 0;
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int j=0;j<10;j++) {
				for(int z=0;z<10;z++) {
					if(map[y+j][x+z]==0) {
						map[y+j][x+z] = 1;
						answer++;
					}
				}
			}
		}
		bw.write(answer+"");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
