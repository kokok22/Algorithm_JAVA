import java.util.*;
import java.io.*;

public class DoublePriorityQueue {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			int k = Integer.parseInt(br.readLine());
			
			PriorityQueue<Point> minheap = new PriorityQueue<Point>();
			PriorityQueue<Point> maxheap = new PriorityQueue<Point>(Collections.reverseOrder());
			
			boolean[] chk = new boolean[k];
			
			int cnt = 0;
			
			for(int i=0;i<k;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				char op = st.nextToken().charAt(0);
				int num = Integer.parseInt(st.nextToken());
				
				// 삽입 연산
				if(op=='I') {
					minheap.offer(new Point(num, i));
					maxheap.offer(new Point(num, i));
					cnt++;
				}
				// 삭제 연산
				else if(op=='D') {
					if(cnt==0)
						continue;
					
					// 최소값 삭제
					if(num==-1) {
						Point p = minheap.poll();
						
						while(chk[p.idx]) 
							p = minheap.poll();
						
						chk[p.idx] = true;
					}
					// 최대값 삭제
					else {
						Point p = maxheap.poll();
						
						while(chk[p.idx])
							p = maxheap.poll();
						
						chk[p.idx] = true;
					}
					cnt--;
				}
			}
			
			if(cnt==0)
				bw.write("EMPTY\n");
			else {
				Point max = maxheap.poll();
				while(chk[max.idx])
					max = maxheap.poll();
				
				Point min = minheap.poll();
				while(chk[min.idx])
					min = minheap.poll();
				
				bw.write(max.value+" "+min.value+"\n");
			}
		}
		bw.flush();
		br.close();
		bw.close();
	}
}

class Point implements Comparable{
	int value;
	int idx;
	
	public Point(int value, int idx) {
		this.value = value;
		this.idx = idx;
	}

	@Override
	public int compareTo(Object o) {
		Point p = (Point) o;
		return Integer.compare(this.value, p.value);
	}
}
