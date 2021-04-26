import java.io.*;
import java.util.*;

public class RainWater {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		int[] map = new int[W];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<W;i++)
			map[i] = Integer.parseInt(st.nextToken());
		
		int start = 0;
		int end = W-1;
		
		int sum = 0;
		
		int rtop = W-1;
		int ltop = 0;
		
		while(start<end) {
			if(map[start] < map[end]) {
				start++;
				int temp = map[ltop]-map[start];
				if(temp>0) 
					sum += temp;
				else
					ltop = start;
			}else {
				end--;
				int temp = map[rtop]-map[end];
				if(temp>0)
					sum += temp;
				else
					rtop = end;
			}
		}
		
		bw.write(sum+"");
		bw.flush();
		br.close();
		bw.close();
	}
}
