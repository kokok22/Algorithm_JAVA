package com.ssafy.day01;

import java.util.Scanner;

public class RotateArray {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int R = sc.nextInt();
		
		int[][] map = new int[N][M];
		
		// 배열 만들기
		for(int y=0;y<N;y++) {
			for(int x=0;x<M;x++)
				map[y][x] = sc.nextInt();
		}
				
		for(int i=0;i<R;i++) {
			int op = sc.nextInt();
			if(op==1)
				map = swap1(map);
			else if(op==2)
				map = swap2(map);
			else if(op==3)
				map = swap3(map);
			else if(op==4)
				map = swap4(map);
			else if(op==5)
				map = swap5(map);
			else if(op==6)
				map = swap6(map);
		}
		
		for(int y=0;y<map.length;y++) {
			for(int x=0;x<map[0].length;x++)
				System.out.print(map[y][x]+" ");
			System.out.println();
		}
		sc.close();
	}

	private static int[][] swap1(int[][]map) {
		int size = map.length;
		
		for(int i=0;i<size/2;i++) {
			int[] temp = map[i];
			map[i] = map[size-1-i];
			map[size-1-i] = temp;
		}
		return map;
	}
	
	private static int[][] swap2(int[][] map) {
		int size = map[0].length;
		
		for(int i=0;i<size/2;i++) {
			for(int j=0;j<map.length;j++) {
				int temp = map[j][i];
				map[j][i] = map[j][size-1-i];
				map[j][size-1-i] = temp;
			}
		}
		return map;
	}
	
	private static int[][] swap3(int[][] map) {
		int[][] temp = new int[map[0].length][map.length];
		
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[0].length;j++) {
				temp[j][map.length-i-1] = map[i][j];
			}
		}
		return temp;
	}

	private static int[][] swap4(int[][] map) {
		int[][] temp = new int[map[0].length][map.length];
		
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[0].length;j++) {
				temp[map[0].length-j-1][i] = map[i][j];
			}
		}
		return temp;
	}

	private static int[][] swap5(int[][] map) {
		int[][] temp = new int[map.length][map[0].length];
		
		int N = map.length;
		int M = map[0].length;
		
		for(int i=0;i<M/2;i++) {
			for(int j=0;j<N/2;j++)
				temp[j][i+M/2] = map[j][i];
		}
		for(int i=0;i<M/2;i++) {
			for(int j=N/2;j<N;j++)
				temp[j-N/2][i] = map[j][i];
		}
		for(int i=M/2;i<M;i++) {
			for(int j=0;j<N/2;j++)
				temp[j+N/2][i] = map[j][i];
		}
		for(int i=M/2;i<M;i++) {
			for(int j=N/2;j<N;j++)
				temp[j][i-M/2] = map[j][i];
		}
		return temp;
	}

	private static int[][] swap6(int[][] map) {
		int[][] temp = new int[map.length][map[0].length];
		
		int N = map.length;
		int M = map[0].length;
		
		for(int i=0;i<M/2;i++) {
			for(int j=0;j<N/2;j++)
				temp[j+N/2][i] = map[j][i];
		}
		for(int i=0;i<M/2;i++) {
			for(int j=N/2;j<N;j++)
				temp[j][i+M/2] = map[j][i];
		}
		for(int i=M/2;i<M;i++) {
			for(int j=0;j<N/2;j++)
				temp[j][i-M/2] = map[j][i];
		}
		for(int i=M/2;i<M;i++) {
			for(int j=N/2;j<N;j++)
				temp[j-N/2][i] = map[j][i];
		}
		return temp;
	}
}
