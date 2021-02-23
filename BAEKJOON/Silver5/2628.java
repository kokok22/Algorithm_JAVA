import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class PaperCrop {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> y = new ArrayList<Integer>();
		ArrayList<Integer> x = new ArrayList<Integer>();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int direct = Integer.parseInt(st.nextToken());
			
			if(direct==0)
				y.add(Integer.parseInt(st.nextToken()));
			else
				x.add(Integer.parseInt(st.nextToken()));
		}
		
		y.add(Y);
		x.add(X);
		
		Collections.sort(y);
		Collections.sort(x);
		
		int pre_y = 0;
		int pre_x = 0;
		
		int answer = 0;
		
		for(int i=0;i<y.size();i++) {
			int now_y = y.get(i);
			pre_x = 0;
			
			for(int j=0;j<x.size();j++) {
				int now_x = x.get(j);
				int size = (now_x-pre_x)*(now_y-pre_y);
				
				answer = Math.max(answer, size);
				pre_x = now_x;
			}
			pre_y = now_y;
		}
		bw.write(answer+"");
		bw.flush();
		br.close();
		bw.close();
	}
}
