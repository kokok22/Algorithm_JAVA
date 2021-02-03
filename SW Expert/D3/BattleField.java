package com.ssafy.day01;

import java.util.Scanner;

public class BattleField {
	static String moving = "UDLR";
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static String shape = "^v<>";
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=0;t<T;t++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			
			char[][] map = new char[H][W];
			
			// 대포의 현재 위치
			int[] pos = new int[2];
			
			// map 만들기
			for(int y=0;y<H;y++) {
				String strs = sc.next();
				for(int x=0;x<W;x++) {
					map[y][x] = strs.charAt(x);
					if("<>^v".contains(map[y][x]+"")){
						pos[0] = x;
						pos[1] = y;
					}
				}
			}
			int _ = sc.nextInt();
			String cmds = sc.next();
			
			recursive(map,cmds,0,pos);
			show(t,map);
		}
	}
	
	private static void recursive(char[][] map, String cmds, int idx, int[] pos) {
		if(idx==cmds.length())
			return;
		
		char cmd = cmds.charAt(idx);
		int idx1 = moving.indexOf(cmd);
		
		int x = pos[0];
		int y = pos[1];
		
		// UDLR인 경우
		if(idx1!=-1) {
			map[y][x] = shape.charAt(idx1);
			int tx = x + dx[idx1];
			int ty = y + dy[idx1];
			
			if(tx>=0 && tx<map[0].length && ty>=0 && ty<map.length && map[ty][tx]=='.') {
				map[y][x] = '.';
				map[ty][tx] = shape.charAt(idx1);
				pos[0] = tx;
				pos[1] = ty;
			}
		}
		// S인 경우
		else {
			char d = map[y][x];
			int idx2 = shape.indexOf(d);
			
			int tx = x+dx[idx2];
			int ty = y+dy[idx2];
			
			while(tx>=0 && tx<map[0].length && ty>=0 && ty<map.length) {
				if(map[ty][tx] == '*') {
					map[ty][tx] = '.';
					break;
				}else if(map[ty][tx] == '#')
					break;
				tx += dx[idx2];
				ty += dy[idx2];
			}
		}
		recursive(map, cmds, idx+1, pos);
	}
	
	private static void show(int t, char[][] map) {
		System.out.printf("#%d ",t+1);
		for(int y=0;y<map.length;y++) {
			for(int x=0;x<map[0].length;x++)
				System.out.print(map[y][x]);
			System.out.println();
		}
	}
	
}
