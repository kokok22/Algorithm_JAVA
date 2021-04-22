import java.io.*;
import java.util.*;

public class TreeDistance {
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int V = Integer.parseInt(br.readLine());
		
		Node[] nodes = new Node[V+1];
		
		for(int i=0;i<V;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			
			while(true) {
				int end = Integer.parseInt(st.nextToken());
				
				if(end == -1)
					break;
				
				int distance = Integer.parseInt(st.nextToken());
				
				nodes[start] = new Node(end, distance, nodes[start]);
			}
		}
		
		int[] result = dfs(nodes, 1, new boolean[V+1]);
		result = dfs(nodes, result[1], new boolean[V+1]);
		
		bw.write(result[0]+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static int[] dfs(Node[] nodes, int idx, boolean[] chk) {
		Stack<Point> stack = new Stack<Point>();
		stack.push(new Point(idx, 0));
		chk[idx] = true;
		
		int[] temp = {Integer.MIN_VALUE, 0};
		
		while(!stack.isEmpty()) {
			Point p = stack.pop();
			int sum = p.sum;
			Node node = nodes[p.vertex];
			
			boolean flag = false;
			
			while(node!=null) {
				if(!chk[node.vertex]) {
					chk[node.vertex] = true;
					flag = true;
					stack.push(new Point(node.vertex, sum+node.distance));
				}
				
				node = node.next;
			}
			
			if(!flag) {
				if(temp[0]<=sum) {
					temp[0] = sum;
					temp[1] = p.vertex;
				}
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
	int vertex, distance;
	Node next;
	
	public Node(int vertex, int distance, Node next) {
		this.vertex = vertex;
		this.distance = distance;
		this.next = next;
	}
}
