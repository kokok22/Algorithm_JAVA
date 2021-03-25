import java.io.*;
import java.util.*;

public class UrbanDivisionPlan {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Edge[] edgeList = new Edge[M];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			edgeList[i] = new Edge(from, to, weight);
		}
		
		int[] set = new int[N+1];
		
		for(int i=0;i<N+1;i++)
			set[i] = i;
		
		Arrays.sort(edgeList);
		int result = 0;
		int count = 0;
		
		for(Edge edge : edgeList) {
			if(union(edge.from, edge.to, set)) {
				result += edge.weight;
				if(++count == N-2) break;
			}
		}
		
		bw.write(result+"");
		bw.flush();
		br.close();
		bw.close();
	}
	public static int findset(int a, int[] set) {
		if(set[a]==a) return a;
		return set[a] = findset(set[a], set);
	}
	
	public static boolean union(int a, int b, int[] set) {
		int r1 = findset(a,set);
		int r2 = findset(b,set);
		
		if(r1==r2)
			return false;
		
		set[r2] = r1;
		return true;
	}
}

class Edge implements Comparable{
	int from, to, weight;
	
	public Edge(int from, int to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	
	public int compareTo(Object o) {
		Edge e = (Edge) o;
		
		return Integer.compare(this.weight, e.weight);
	}
}
