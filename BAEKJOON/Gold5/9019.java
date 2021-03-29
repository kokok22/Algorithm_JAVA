import java.io.*;
import java.util.*;

public class DSLR {
	public static char[] ops = {' ', 'D', 'S', 'L', 'R'};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			long s = bfs(A,B);
			
			Stack<Integer> stack = new Stack<Integer>();
			while(s!=0) {
				int temp = (int)(s%10);
				stack.push(temp);
				s /= 10;
			}
			
			while(!stack.isEmpty())
				bw.write(ops[stack.pop()]+"");
			bw.write("\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static long bfs(int A, int B) {
		long result = 0;
		
		// 0 : 시작
		// 1 : D
		// 2 : S
		// 3 : L
		// 4 : R
		Queue<Number> queue = new LinkedList<Number>();
		queue.offer(new Number(A, 0));
		HashSet<Integer> set = new HashSet<Integer>();
		
		while(!queue.isEmpty()) {
			int n = queue.size();
			
			while(n-->0) {
				Number number = queue.poll();
				long op = number.op;
				int num = number.num;
				
				if(num==B)
					return op;
				
				for(int i=1;i<5;i++) {			
					int nn = num;
					long nop = op*10+i;
					
					if(i==1)
						nn = (nn*2)%10000;
					else if(i==2) {
						if(nn==0)
							nn = 10000;
						nn -=1;
					}
					else if(i==3) {
						int temp = nn/1000;
						nn = (nn*10)%10000+temp;
					}
					else if(i==4) {
						int temp = nn%10;
						nn = nn/10 + temp*1000;
					}
					
					if(!set.contains(nn)) {
						queue.offer(new Number(nn, nop));
						set.add(nn);
					}
				}
			}
		}
		return result;
	}
}

class Number{
	int num;
	long op;
	
	public Number(int num, long op) {
		this.num = num;
		this.op = op;
	}
}
