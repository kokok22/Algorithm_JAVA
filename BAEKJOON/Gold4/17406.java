package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class RotateArray4 {
	public static int[] dx = {1,0,-1,0};
	public static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N+1][M+1];
		
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<M+1;j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int[][] ops = new int[R][3];
		
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			int[] op = {r,c,s};
			ops[i] = op;
		}
		
		int answer = dfs(map, ops, new int[R], new boolean[R],0);

		bw.write(answer+"");
		bw.flush();
		br.close();
		bw.close();
	}

	private static int dfs(int[][] map, int[][]ops, int[] sel, boolean[] chk, int k) {
		int min = Integer.MAX_VALUE;
		
		if(k==sel.length) {
			int[][] temp = new int[map.length][map[0].length];
			
			for(int i=0;i<temp.length;i++)
				temp[i] = map[i].clone();
			
			for(int idx:sel) {
				int r = ops[idx][0];
				int c = ops[idx][1];
				int s = ops[idx][2];
				
				for(int j=0;j<s;j++)
					swap(temp,r-s+j, c-s+j, (s-j)*2);
			}
			
			for(int i=1;i<temp.length;i++) {
				int sum=0;
				for(int j=1;j<temp[0].length;j++)
					sum+=temp[i][j];
				min = Math.min(sum,min);
			}
			return min;
		}
		
		else {
			for(int i=0;i<ops.length;i++) {
				if(!chk[i]) {
					chk[i]=true;
					sel[k]=i;
					min = Math.min(min,dfs(map,ops,sel,chk,k+1));
					chk[i]=false;
				}
			}
		}
		return min;
	}
	
	private static void swap(int[][]map, int y, int x, int limit) {
		int pre = map[y][x];
		int idx = 0;
		int cnt = 0;
		
		while(true) {
			if(cnt==limit) {
				cnt=0;
				idx++;
			}
			if(idx==4)
				break;
			int nx = x+dx[idx];
			int ny = y+dy[idx];
			
			int temp = map[ny][nx];
			map[ny][nx] = pre;
			pre = temp;
			cnt++;
			
			x=nx;
			y=ny;
		}
	}
}
