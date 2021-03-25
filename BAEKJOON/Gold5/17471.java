import java.io.*;
import java.util.*;

public class GerryMandering {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		Node[] adjList = new Node[N+1];
		int[] num = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<N+1;i++)
			num[i] = Integer.parseInt(st.nextToken());
			
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			
			for(int j=0;j<M;j++) {
				int vertex = Integer.parseInt(st.nextToken());
				adjList[i] = new Node(vertex, adjList[i]);
			}
		}
		
		int cnt = powerset(num, adjList, new boolean[N+1], 1, 0);
		
		if(cnt==Integer.MAX_VALUE)
			cnt = -1;
		
		bw.write(cnt+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void bfs(Node[] adjList, int idx, boolean[] chk, boolean[] sel) {
		boolean flag = sel[idx];
		
		chk[idx] = true;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(idx);
		
		while(!queue.isEmpty()) {
			int n = queue.size();
			
			while(n-->0) {
				idx = queue.poll();
				Node node = adjList[idx];
				
				while(node!=null) {
					if(!chk[node.vertex] && sel[node.vertex]==flag) {
						queue.offer(node.vertex);
						chk[node.vertex] = true;
					}
					node = node.next;
				}
			}
		}
	}
	
	public static boolean check(boolean[] sel, Node[] adjList) {
		boolean[] chk1 = new boolean[sel.length];
		boolean[] chk2 = new boolean[sel.length];
		
		boolean flag1 = false;
		boolean flag2 = false;
		
		for(int i=1;i<sel.length;i++) {
			// true부분 확인
			if(sel[i]) {
				// 아직 체크 안함
				if(!flag1) {
					bfs(adjList, i, chk1, sel);
					flag1 = true;
				}
				// 체크 했음
				else {
					// 근데 체크가 안된 경우
					if(!chk1[i])
						return false;
				}
			}
			
			// false부분 확인
			else {
				if(!flag2) {
					bfs(adjList, i, chk2, sel);
					flag2 = true;
				}
				else {
					if(!chk2[i])
						return false;
				}
			}
		}
		return true;
	}
	
	
	public static int powerset(int[] num, Node[] adjList, boolean[] sel, int idx, int cnt) {
		int result = Integer.MAX_VALUE;
		
		if(idx==num.length || cnt==num.length/2) {
			if(cnt==0)
				return result;
			
			if(check(sel, adjList)) {
				int t1 = 0;
				int t2 = 0;
				for(int i=1;i<sel.length;i++) {
					if(sel[i])
						t1 += num[i];
					else
						t2 += num[i];
				}
				
				return Math.abs(t1-t2);
			}
			else
				return result;
		}

		sel[idx] = true;
		result = Math.min(result, powerset(num, adjList, sel, idx+1, cnt+1));
		
		sel[idx] = false;
		result = Math.min(result, powerset(num, adjList, sel, idx+1, cnt));
		
		return result;
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