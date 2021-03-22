import java.io.*;
import java.util.*;

public class BaseBall {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] score = new int[N][9];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=0;j<9;j++)
				score[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int[] order = new int[9];
		order[3] = 0;
		
		int result = recursive(score, order, 0, new boolean[9]);
		
		bw.write(result+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static int run(int[] base, int p) {
		int num = 0;
		
		for(int i=2;i>=0;i--) {
			if(base[i]==1) {
				if(i>p) {
					num++;
					base[i]=0;
				}
				else {
					base[i+(2-p)] = 1;
					base[i] = 0;
				}
			}
		}
		
		return num;
	}
	
	public static int recursive(int[][] score, int[] order, int idx, boolean[] chk) {
		int result = Integer.MIN_VALUE;
		
		if(idx==order.length) {
			int num = 0;
			int p = 0;
			
			for(int i=0;i<score.length;i++) {
				// 처음에 queue를 통해 주자가 어디 있는 지 파악해주었는데, 
				int[] base = new int[3];
				int out = 0;
				
				while(out<3) {
					int temp = score[i][order[p]];
					
					// 아웃
					if(temp==0)
						out++;
					
					// 안타
					else if(temp==1) {
						num += run(base, 1);
						base[0] = 1;
					}
					// 2루타
					else if(temp==2) {
						num += run(base, 0);
						base[1] = 1;
					}
					// 3루타
					else if(temp==3) {
						num += run(base, -1);
						base[2] = 1;
					}
					// 4루타
					else {
						num += run(base, -1);
						num ++;
					}
					
					if(++p>=9)
						p=0;
				}
			}	
			return num;
		}
		
		// 4번 주자는 이미 있으니까 넘겨준다.
		if(idx==3)
			idx++;
		
		// 순열을 통해 순서를 계산한다.
		for(int i=1;i<9;i++) {
			if(!chk[i]) {
				chk[i] = true;
				order[idx] = i;
				result = Math.max(result, recursive(score, order, idx+1, chk));
				chk[i] = false;
			}
		}
		return result;
	}
}
