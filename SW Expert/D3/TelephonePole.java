import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TelephonePole {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			
			Node[] nds = new Node[N];
			
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				nds[i] = new Node(a,b);
			}
			
			Arrays.sort(nds);
			
			int cnt = 0;
			
			for(int i=0;i<nds.length;i++) {
				for(int j=i+1;j<nds.length;j++) {
					if(nds[i].b > nds[j].b)
						cnt++;
				}
			}
			bw.write("#"+(t+1)+" "+cnt+"\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
}

class Node implements Comparable{
	int a;
	int b;
	
	public Node(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public int compareTo(Object o) {
		Node n = (Node)o;
		return this.a-n.a;
	}
}
