import java.io.*;
import java.util.*;

public class IntegerTriangle {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		// 0번 인덱스는 이전 것
		// 1번 인덱스는 현재 것
		int[][] result = new int[N][2];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<=i;j++) {
				result[j][1] = Integer.parseInt(st.nextToken());
				if(j>0 && j<i)
					result[j][1] += Math.max(result[j-1][0], result[j][0]);
				else if(j==0)
					result[j][1] += result[j][0];
				else if(j==i)
					result[j][1] += result[j-1][0];
			}
			
			for(int j=0;j<=i;j++)
				result[j][0] = result[j][1];
		}
		
		int max = Integer.MIN_VALUE;
		
		for(int i=0;i<N;i++)
			max = Math.max(max, result[i][0]);
		
		bw.write(max+"");
		bw.flush();
		br.close();
		bw.close();
	}
}
