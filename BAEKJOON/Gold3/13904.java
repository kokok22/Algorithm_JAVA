import java.io.*;
import java.util.*;

public class HW {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		Work[] works = new Work[N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			works[i] = new Work(d,w);
		}
		
		Arrays.sort(works);
		
		int result = 0;
		
		boolean[] chk = new boolean[1001];
		
		for(int i=0;i<works.length;i++) {
			int idx = works[i].d;
			
			while(idx>0 && chk[idx]) {
				idx--;
			}
			if(idx>0) {
				result += works[i].w;
				chk[idx] = true;
			}
		}
		
		bw.write(result+"");
		bw.flush();
		br.close();
		bw.close();
	}
}

class Work implements Comparable{
	int d,w;
	
	public Work(int d, int w) {
		this.d = d;
		this.w = w;
	}
	
	@Override
	public int compareTo(Object o) {
		Work work = (Work) o;
		
		if(work.w==this.w)
			return Integer.compare(this.d, work.d);
		return Integer.compare(work.w, this.w);
	}
}
