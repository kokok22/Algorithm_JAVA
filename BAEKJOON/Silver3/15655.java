package com.ssafy.day01;

import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String args[]) {
		try {
			String s = bf.readLine();
		
			StringTokenizer st = new StringTokenizer(s);
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
		
			int[] arr = new int[N];
		
			s = bf.readLine();
			st = new StringTokenizer(s);
			
			for(int i=0;i<N;i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			Arrays.sort(arr);
			
			combination(arr, new int[M], new boolean[N],0, 0);
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void combination(int[] arr, int[] sel, boolean[] v, int k, int idx) throws Exception{
		if(k==sel.length) {
			for(int i=0;i<sel.length;i++) {
				bw.write(Integer.toString(sel[i])+" ");
			}
			bw.newLine();
			return;
		}
		
		for(int i=idx;i<arr.length;i++) {
			if(!v[i]) {
				v[i]=true;
				sel[k] = arr[i];
				combination(arr,sel,v,k+1, i+1);
				v[i]=false;
			}
		}
	}
}






//combination(arr,new int[M],0,0);

//private static void combination(int[] arr, int[] sel, int k, int idx) {
//if(k==sel.length) {
//	for(int i=0;i<sel.length;i++)
//		System.out.print(sel[i]+" ");
//	System.out.println();
//	return;
//}
//
//for(int i=idx;i<arr.length;i++) {
//	sel[k] = arr[i];
//	combination(arr,sel,k+1,i+1);
//}
//}