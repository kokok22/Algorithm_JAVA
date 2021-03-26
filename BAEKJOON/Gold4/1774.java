import java.io.*;
import java.util.*;

public class CommunicationWithGod {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		double[] arr_x = new double[N+1];
		double[] arr_y = new double[N+1];
		
		// 좌표 값 입력 받기
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine());
			
			arr_x[i] = Double.parseDouble(st.nextToken());
			arr_y[i] = Double.parseDouble(st.nextToken());
		}
		
		Edge[] edgeList = new Edge[sum(N)];
		int cnt = 0;
		
		// 간선 리스트 생성
		for(int y=1;y<N+1;y++) {
			for(int x=y+1;x<N+1;x++) {
				double weight = Math.sqrt(Math.pow(arr_x[y]-arr_x[x],2)+Math.pow(arr_y[y]-arr_y[x],2));
				edgeList[cnt++] = new Edge(y,x,weight);
			}
		}
		// 간선 리스트 정렬
		Arrays.sort(edgeList);
		
		// 서로소 집합 생성
		int[] parents = new int[N+1];
		for(int i=1;i<N+1;i++)
			parents[i] = i;
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			int p1 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			
			union(parents, p1,p2);
		}
		
		// 이제 시작(kruskal algorithm)
		double result = 0;
		cnt = 0;
		
		for(Edge edge : edgeList) {
			if(union(parents,edge.from,edge.to)) {
				result += edge.weight;
				if(++cnt==N-1-M)
					break;
			}
		}
		
		System.out.printf("%.2f",result);
		br.close();
		bw.close();
	}
	
	public static int findset(int a, int[] parents) {
		if(parents[a] == a)
			return a;
		
		return parents[a] = findset(parents[a], parents);
	}
	
	public static boolean union(int[] parents, int a, int b) {
		int p1 = findset(a, parents);
		int p2 = findset(b, parents);
		
		if(p1==p2)
			return false;
		
		parents[p1] = p2;
		return true;
	}
	
	public static int sum(int N) {
		int result = 0;
		for(int i=1;i<N;i++)
			result += i;
		
		return result;
	}
}

class Edge implements Comparable{
	int from, to;
	double weight;
	
	public Edge(int from, int to, double weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Object o) {
		Edge e = (Edge) o;
		return Double.compare(this.weight, e.weight);
	}
}
