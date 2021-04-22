import java.util.*;
import java.io.*;

public class Honey {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N][N];
			
			for(int y=0;y<N;y++) {
				st = new StringTokenizer(br.readLine());
				for(int x=0;x<N;x++)
					map[y][x] = Integer.parseInt(st.nextToken());
			}
			
			int result = Integer.MIN_VALUE;
			
			for(int y=0;y<map.length;y++) {
				for(int x=0;x<=map[0].length-M;x++) {
					int[] arr = new int[M];
					
					for(int i=0;i<M;i++)
						arr[i] = map[y][x+i];
					
					result = Math.max(result, recursive(map, y*map[0].length+x+M, arr, M, C));
					
				}
			}
			
			bw.write("#"+(t+1)+" "+result+"\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static int recursive(int[][] map, int idx, int[] arr, int M, int C) {
		int result = Integer.MIN_VALUE;
		
		for(int i=idx;i<map[0].length*map.length;i++) {
			int y = i/map[0].length;
			int x= i%map[0].length;
			
			int[] arr2 = new int[M];
			
			if(x+M>map[0].length)
				continue;
			
			for(int j=0;j<M;j++)
				arr2[j] = map[y][x+j];
			
			int num = calc(arr, 0, C, new boolean[M])+ calc(arr2, 0, C, new boolean[M]);
			
			result = Math.max(result, num);
		}
		
		return result;
	}
	
	public static int calc(int[] arr, int idx ,int C, boolean[] chk) {
		int result = Integer.MIN_VALUE;
		
		if(idx==chk.length) {
			int temp = 0;
			int sum = 0;
			
			for(int i=0;i<chk.length;i++) {
				if(chk[i]) {
					temp += arr[i];
					sum += arr[i]*arr[i];
				}
			}
			
			if(temp>C)
				return result;
			
			return sum;
		}
		
		chk[idx] = true;
		result = Math.max(result, calc(arr, idx+1, C, chk));
		
		chk[idx] = false;
		result = Math.max(result, calc(arr, idx+1, C, chk));
		
		return result;
	}
}
