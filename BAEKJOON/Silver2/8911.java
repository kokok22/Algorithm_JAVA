import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Turtle {
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {-1,0,1,0};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			int x = 0;
			int y = 0;
			
			int x1 = 0;
			int x2 = 0;
			int y1 = 0;
			int y2 = 0;
			
			int idx = 0;
			
			String s = br.readLine();
			
			for(int i=0;i<s.length();i++) {
				char op = s.charAt(i);
				if(op=='F') {
					x += dx[idx];
					y += dy[idx];
				}else if(op=='B') {
					x -= dx[idx];
					y -= dy[idx];
				}else if(op=='L') {
					if(--idx<0)
						idx=3;
				}else if(op=='R') {
					if(++idx>3)
						idx=0;
				}
				x1 = Math.max(x1, x);
				x2 = Math.min(x2, x);
				y1 = Math.max(y1, y);
				y2 = Math.min(y2, y);
			}
			
			bw.write((x1-x2)*(y1-y2)+"\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
}
