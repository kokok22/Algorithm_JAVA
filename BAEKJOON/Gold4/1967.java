import java.io.*;
import java.util.*;

public class TreeDistance {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		Node[] nodes = new Node[N+1];
		
		for(int i=1;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			nodes[u] = new Node(v, w, nodes[u]);
			nodes[v] = new Node(u, w, nodes[v]);
		}
		
		int[] result = new int[2];
		
		for(int i=1;i<=N;i++) {
			Node node = nodes[i];
			
			if(node!=null && node.next==null) {
				result = dfs(nodes, i, new boolean[N+1]);
				break;
			}
		}
		
		result = dfs(nodes, result[0], new boolean[N+1]);
		
		bw.write(result[1]+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static int[] dfs(Node[] nodes, int idx, boolean[] chk) {
		int[] temp = {0, Integer.MIN_VALUE};
		
		Stack<Point> stack = new Stack<Point>();
		stack.push(new Point(idx, 0));
		chk[idx] = true;
		
		while(!stack.isEmpty()) {
			Point p = stack.pop();
			Node node = nodes[p.vertex];
			
			boolean flag = false;
			
			while(node!=null) {
				if(!chk[node.to]) {
					flag = true;
					chk[node.to] = true;
					stack.push(new Point(node.to, p.sum+node.weight));
				}
				node = node.next;
			}
			
			if(!flag && p.sum>temp[1]) {
				temp[0] = p.vertex;
				temp[1] = p.sum;
			}
		}
		
		return temp;
	}
}
class Point{
	int vertex, sum;
	
	public Point(int vertex, int sum) {
		this.vertex = vertex;
		this.sum = sum;
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