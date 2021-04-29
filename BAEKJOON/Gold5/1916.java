import java.io.*;
import java.util.*;

public class MinimumCost {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		Node[] nodes = new Node[N+1];
		
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			nodes[u] = new Node(v, w, nodes[u]);
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int[] distance = new int[N+1];
		boolean[] visited = new boolean[N+1];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		
		for(int i=1;i<=N;i++) {
			int min = Integer.MAX_VALUE;
			int current = start;
			
			for(int j=0;j<=N;j++) {
				if(!visited[j] && min>distance[j]) {
					min = distance[j];
					current = j;
				}
			}
			
			visited[current] = true;
			if(current==end) break;
			
			Node node = nodes[current];
			
			while(node!=null) {
				int j = node.vertex;
				if(!visited[j] && distance[j]>min+node.value)
					distance[j] = min+node.value;
				
				node = node.next;
			}
		}
		
		bw.write(distance[end]+"");
		bw.flush();
		br.close();
		bw.close();
	}
}

class Node{
	int vertex, value;
	Node next;
	
	public Node(int vertex, int value, Node next) {
		this.vertex = vertex;
		this.value = value;
		this.next = next;
	}
}
