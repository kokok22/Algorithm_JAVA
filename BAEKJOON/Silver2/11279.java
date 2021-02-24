import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxHeap {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Comparator.reverseOrder());
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(br.readLine());
			int answer = 0;
			
			if(num==0 && !heap.isEmpty())
				bw.write(heap.poll()+"\n");
			else if(num>0)
				heap.offer(num);
			else
				bw.write(0+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
