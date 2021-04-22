import java.io.*;
import java.util.*;

public class ShortestPath {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		Node[] nodes = new Node[V+1];
		
		int K = Integer.parseInt(br.readLine());
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			nodes[u] = new Node(v, w, nodes[u]);
		}
		
		int[] distance = new int[V+1];
		boolean[] visited = new boolean[V+1];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[K] = 0;
		
		for(int i=1;i<=V;i++) {
			int min = Integer.MAX_VALUE;
			int current = 0;
			
			for(int j=1;j<=V;j++) {
				if(!visited[j] && min>distance[j]) {
					min = distance[j];
					current = j;
				}
			}
			
			if(current == 0)
				break;
			
			visited[current] = true;
			
			Node node = nodes[current];
			
			while(node != null) {
				if(!visited[node.to])
					distance[node.to] = Math.min(distance[node.to], min + node.weight);
				node = node.next;
			}
		}
		
		for(int i=1;i<=V;i++) {
			int num = distance[i];
			
			if(num==Integer.MAX_VALUE)
				bw.write("INF\n");
			
			else
				bw.write(num+"\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
		
	}
}

class Node{
	int to, weight;
	Node next;
	
	public Node(int to, int weight, Node next) {
		this.to = to;
		this.weight = weight;
		this.next = next;
	}
}
