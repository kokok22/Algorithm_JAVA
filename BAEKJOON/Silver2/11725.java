import java.io.*;
import java.util.*;

public class TreeParent {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		Node[] adj = new Node[N+1];
		
		for(int i=1;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			adj[u] = new Node(v, adj[u]);
			adj[v] = new Node(u, adj[v]);
		}
		
		boolean[] visit = new boolean[N+1];
		int[] parent = new int[N+1];
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(1);
		visit[1] = true;
		
		while(!queue.isEmpty()) {
			int n = queue.size();
			
			while(n-->0) {
				int v = queue.poll();
				
				Node node = adj[v];
				
				while(node != null) {
					int temp = node.vertex;
					if(!visit[temp]) {
						visit[temp] = true;
						queue.offer(temp);
						parent[temp] = v;
						
					}
					node = node.next;
				}
			}
		}
		
		for(int i=2;i<=N;i++) {
			bw.write(parent[i]+"\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}	
}

class Node{
	int vertex;
	Node next;
	
	public Node(int vertex, Node next) {
		this.vertex = vertex;
		this.next = next;
	}
}