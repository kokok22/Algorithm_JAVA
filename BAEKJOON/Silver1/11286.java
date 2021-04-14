import java.util.*;
import java.io.*;

public class ABSHeap {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		PriorityQueue<Num> heap = new PriorityQueue<Num>();
		
		for(int t=0;t<T;t++) {
			int x = Integer.parseInt(br.readLine());
			
			if(x==0) {
				if(heap.isEmpty())
					bw.write(0+"\n");
				else
					bw.write(heap.poll().n+"\n");
			}
			else
				heap.offer(new Num(x));
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
}

class Num implements Comparable{
	int n;
	
	public Num(int n) {
		this.n = n;
	}
	
	@Override
	public int compareTo(Object o) {
		Num num = (Num) o;
		
		if(Math.abs(this.n) == Math.abs(num.n))
			return Integer.compare(this.n, num.n);
			
		return Integer.compare(Math.abs(this.n), Math.abs(num.n));
	}
}