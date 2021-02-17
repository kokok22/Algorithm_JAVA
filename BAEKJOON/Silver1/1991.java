package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class QuadTree {
	public static int[][] map;
	public static StringBuilder sb;
	public static int cnt = 10;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		sb = new StringBuilder();
		
		for(int y=0;y<N;y++) {
			String s = br.readLine();
			for(int x=0;x<N;x++) {
				map[y][x] = Integer.parseInt(s.charAt(x)+"");
			}
		}
		
		int[] idx_x = {0, map[0].length};
		int[] idx_y = {0, map.length};
		
		recursive(0, map[0].length, 0, map.length);
		
		bw.write(sb.toString()+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	private static void recursive(int x1, int x2, int y1, int y2) {
		
		if(!chk(x1, x2, y1, y2)) {
			sb.append("(");
			recursive(x1, (x1+x2)/2, y1, (y1+y2)/2);
			recursive((x1+x2)/2, x2, y1, (y1+y2)/2);
			recursive(x1, (x1+x2)/2, (y1+y2)/2, y2);
			recursive((x1+x2)/2, x2, (y1+y2)/2, y2);
			sb.append(")");
		}else
			sb.append(map[y1][x1]+"");
	}
	
	private static boolean chk(int x1, int x2, int y1, int y2) {
		int pre=0;
		for(int y=y1;y<y2;y++) {
			for(int x=x1;x<x2;x++) {
				if(x==x1 && y==y1)
					pre = map[y][x];
				else if(pre != map[y][x])
					return false;
			}
		}
		return true;
	}
}
