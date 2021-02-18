package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MonarchyAndRepublicanism {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			
			Node[] ns = new Node[N];
			double[][] effect = new double[N+1][2];
			
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				double s = Double.parseDouble(st.nextToken());
				
				ns[i] = new Node(x,y,s,i+1);
			}
			
			Arrays.sort(ns);
			
			for(int i=0;i<N;i++) {
				for(int j=i+1;j<N;j++) {
					double ef = ns[i].s/(pow(ns[j].x-ns[i].x,2)+pow(ns[j].y-ns[i].y,2));
					
					if(ef>ns[j].s) {
						if(effect[ns[j].idx][0] ==0 || effect[ns[j].idx][1] < ef) {
							double[] temp = {ns[i].idx, ef};
							effect[ns[j].idx] = temp;
						}else if(effect[ns[j].idx][1] == ef) {
							effect[ns[j].idx][0] = -1;
						}
					}
				}
			}
			
			bw.write("#"+(t+1)+" ");
			for(int i=1;i<=N;i++) {
				if(effect[i][0]==0)
					bw.write("K ");
				else if(effect[i][0]==-1)
					bw.write("D ");
				else {
					int k = (int)effect[i][0];
					while(true) {
						int num = (int)effect[k][0];
						if(num>0)
							k = num;
						else
							break;
					}
					bw.write(k+" ");
				}
			}
			bw.write("\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
	
	private static double pow(int a, int num) {
		double answer = 1;
		for(int i=0;i<num;i++) {
			answer *= a; 
		}
		return answer;
	}
}

class Node implements Comparable{
	int x;
	int y;
	double s;
	int idx;
	
	Node(int x, int y, double s, int idx){
		this.x = x;
		this.y = y;
		this.s = s;
		this.idx = idx;
	}

	@Override
	public int compareTo(Object o) {
		Node n = (Node)o;
		return (int)(n.s-this.s);
	}
}
