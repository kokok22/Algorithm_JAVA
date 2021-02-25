import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class StackingDices {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] reverse = {5, 3, 4, 1, 2, 0};
		int[][] dice = new int[N][6];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<6;j++)
				dice[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 0;
		
		for(int i=0;i<6;i++) {
			int sum = 0;
			int start = dice[0][reverse[i]];
			sum += max_num(dice[0], i, reverse[i]);
			
			for(int j=1;j<N;j++) {
				int idx = 0;
				for(int k=0;k<6;k++) {
					if(dice[j][k]==start)
						idx = k;
				}
				sum += max_num(dice[j], idx, reverse[idx]);
				start = dice[j][reverse[idx]];
			}
			answer = Math.max(answer, sum);
		}
		bw.write(answer+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	private static int max_num(int[] arr, int idx1, int idx2) {
		int max = 0;
		
		for(int i=0;i<6;i++) {
			if(i!=idx1 && i != idx2)
				max = Math.max(max, arr[i]);
		}		
		return max;
	}
}



// (1, 5) => 6
// (5, 3) => 6
// (3, 4) => 6
// (4, 6) => 5
// (6, 3) => 5 