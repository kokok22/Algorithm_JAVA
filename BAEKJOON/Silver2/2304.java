import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Warehouse {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		Node[] ns = new Node[N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			
			ns[i] = new Node(L, H);
		}
		
		Arrays.sort(ns);
		
		int x1 = 0;
		int x2 = N-1;

		int answer = 0;
		
		while(x1<x2) {
			if(ns[x1].H < ns[x2].H) {
				int p = x1;
				while(ns[p].H > ns[++x1].H);
				
				answer += (ns[x1].L-ns[p].L)*ns[p].H;
			}else {
				int p = x2;
				while(ns[p].H > ns[--x2].H);
				
				answer += (ns[p].L-ns[x2].L)*ns[p].H;
			}
		}
		
		answer += ns[x1].H;
		
		bw.write(answer+"");
		bw.flush();
		br.close();
		bw.close();
	}
}

class Node implements Comparable{
	int L;
	int H;
	
	public Node(int L, int H) {
		this.L = L;
		this.H = H;
	}

	@Override
	public int compareTo(Object o) {
		Node n = (Node) o;
		return this.L - n.L; 
	}
}
