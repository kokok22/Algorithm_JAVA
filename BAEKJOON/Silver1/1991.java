import java.io.*;
import java.util.*;

public class TreeCircuit {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		Node[] nodes = new Node[N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			char u = st.nextToken().charAt(0);
			char l = st.nextToken().charAt(0);
			char r = st.nextToken().charAt(0);
			
			nodes[u-'A'] = new Node(u, l, r);
		}
		
		preorder(nodes, 0);
		System.out.println();
		
		inorder(nodes, 0);
		System.out.println();
		
		postorder(nodes, 0);
		System.out.println();
		
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void inorder(Node[] nodes, int idx) {		
		if(idx<0 || idx>=nodes.length)
			return;
		
		Node node = nodes[idx];
		
		if(node.left=='.') {
			System.out.print(node.vertex);
		}else {
			inorder(nodes, node.left-'A');
			System.out.print(node.vertex);
		}
		
		inorder(nodes, node.right-'A');
	}
	
	public static void postorder(Node[] nodes, int idx) {
		if(idx<0 || idx>=nodes.length)
			return;
		
		Node node = nodes[idx];
		
		if(node.left=='.' && node.right=='.') {
			System.out.print(node.vertex);
		}else {
			postorder(nodes, node.left-'A');
			postorder(nodes, node.right-'A');
			System.out.print(node.vertex);
		}
	}
	
	public static void preorder(Node[] nodes, int idx) {
		if(nodes.length<=idx || 0>idx)
			return;
		if(nodes[idx]==null)
			return;
		
		Node node = nodes[idx];
		System.out.print(node.vertex);
		
		preorder(nodes, node.left-'A');
		preorder(nodes, node.right-'A');
	}
	
}

class Node{
	char vertex, left, right;
	
	public Node(char vertex, char left, char right) {
		this.vertex = vertex;
		this.left = left;
		this.right = right;
	}
}
