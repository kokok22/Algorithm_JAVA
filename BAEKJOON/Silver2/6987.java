import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class WorldCup {
	public static int[] reverse = {2, 1, 0};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int t=0;t<4;t++) {
			int[][] map = new int[6][3];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int y=0;y<6;y++) {
				for(int x=0;x<3;x++)
					map[y][x] = Integer.parseInt(st.nextToken());
			}
			
			int answer = dfs(map, 0, 1);
			bw.write(answer+" ");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
	
	private static int dfs(int[][] map, int t1, int t2) {
		if(t1==5) {
			for(int y=0;y<6;y++) {
				for(int x=0;x<3;x++) {
					if(map[y][x]!=0)
						return 0;
				}
			}
			return 1;
		}
		
		int answer = 0;
		
		for(int i=0;i<3;i++) {
			if(map[t1][i]!=0 && map[t2][reverse[i]]!=0) {
				map[t1][i] -= 1;
				map[t2][reverse[i]] -= 1;
				
				if(t2==map.length-1) 
					answer = Math.max(answer, dfs(map, t1+1, t1+2));
				else
					answer = Math.max(answer, dfs(map, t1, t2+1));
				
				map[t1][i] += 1;
				map[t2][reverse[i]] += 1;
			}
		}
		
		return answer;
	}
}
