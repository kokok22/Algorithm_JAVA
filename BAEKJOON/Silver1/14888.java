import java.io.*;
import java.util.StringTokenizer;

public class InsertOperator {
	public static int max = Integer.MIN_VALUE;
	public static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N];		// 숫자들
		int[] ops = new int[4];			// 연산자 개수
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++)
			nums[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<4;i++)
			ops[i] = Integer.parseInt(st.nextToken());
		
		recursive(nums, ops, 1, nums[0]);
		
		bw.write(max+"\n"+min);
		bw.flush();
		br.close();
		bw.close();
	}
	
	// 순열을 통해 모든 경우의 수를 탐색하여 계산하였다.
	private static void recursive(int[] nums, int[] ops, int idx, int sum) {		
		if(idx==nums.length) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
		}
		
		for(int i=0;i<4;i++) {
			if(ops[i]>0) {
				ops[i]--;
				
				int temp = sum;
				
				switch(i) {
				case 0:
					temp += nums[idx];
					break;
				case 1:
					temp -= nums[idx];
					break;
				case 2:
					temp *= nums[idx];
					break;
				case 3:
					temp /= nums[idx];
					break;
				}
				
				recursive(nums, ops, idx+1, temp);
				ops[i]++;
			}
		}
	}
}
