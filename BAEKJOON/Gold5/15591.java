import java.io.*;
import java.util.*;

public class MooTube {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
	
		Node[] nodes = new Node[N+1];
		
		for(int i=1;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			long r = Integer.parseInt(st.nextToken());
			
			nodes[p] = new Node(q, r, nodes[p]);
			nodes[q] = new Node(p, r, nodes[q]);
		}
		
		for(int i=0;i<Q;i++) {
			st = new StringTokenizer(br.readLine());
			
			long k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			int result = bfs(nodes, k, v);
			
			bw.write(result+"\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static int bfs(Node[] nodes, long k, int v) {
		int result = 0;
		
		boolean[] visit = new boolean[nodes.length];
		visit[v] = true;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(v);
		
		while(!queue.isEmpty()) {
			int n = queue.size();
			
			while(n-->0) {
				int idx = queue.poll();
				Node node = nodes[idx];
				
				while(node!=null) {
					if(!visit[node.v] && node.d >= k) {
						queue.offer(node.v);
						visit[node.v] = true;
						result++;
					}
					node = node.next;
				}
			}
		}

		return result;
	}
}

class Node{
	int v;
	long d;
	Node next;
	
	public Node(int v, long d, Node next) {
		this.v = v;
		this.d = d;
		this.next = next;
	}
}
