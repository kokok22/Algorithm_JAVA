import java.io.*;

public class ClimbingStairs {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] stairs = new int[N];
		
		for(int i=0;i<N;i++)
			stairs[i] = Integer.parseInt(br.readLine());
		
		// 0번 :	1번 뛴 것 (이전 것의 1번 인덱스)
		// 1번 : 2번 뛴 것 (전전의 0번 인덱스, 전전의 1번인덱스 중 최대 값)
		
		int[][] result = new int[N][3];
		
		for(int i=0;i<N;i++) {
			if(i==0) {
				result[i][0] = stairs[i];
				result[i][1] = stairs[i];
			}
			else if(i==1) {
				result[i][0] = result[i-1][1]+stairs[i];
				result[i][1] = stairs[i];
			}
			else {
				result[i][0] = result[i-1][1]+stairs[i];
				result[i][1] = Math.max(result[i-2][0], result[i-2][1])+stairs[i];
			}
		}
		
		bw.write(Math.max(result[N-1][0], result[N-1][1])+"");
		bw.flush();
		br.close();
		bw.close();
	}
}
