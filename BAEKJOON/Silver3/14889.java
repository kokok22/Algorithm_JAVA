import java.io.*;
import java.util.*;

public class StartAndLink {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		
		for(int y=0;y<N;y++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int x=0;x<N;x++)
				map[y][x] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = recursive(map, 0, 0, new boolean[N]);
		
		bw.write(cnt+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	private static int recursive(int[][] map, int idx, int k, boolean[] chk) {
		int score = Integer.MAX_VALUE;
		
		// 한 팀만 선발을 한다. 선발되지 못한 인원은 다른 팀의 일원이다.
		if(k==map.length/2) {
			int t1 = 0;
			int t2 = 0;
			
			for(int i=0;i<map.length;i++) {
				if(!chk[i]) {
					for(int j=0;j<map.length;j++) {
						if(!chk[j])
							t1 += map[i][j];
					}
				}
				else if(chk[i]){
					for(int j=0;j<map.length;j++) {
						if(chk[j])
							t2 += map[i][j];
					}
				}
			}
			return Math.abs(t1-t2);
		}
		
		// 조합으로 선발진행
		for(int i=idx;i<map.length;i++) {
			if(!chk[i]) {
				chk[i] = true;
				score = Math.min(score, recursive(map, i+1, k+1, chk));
				chk[i] = false;
			}
		}
		
		return score;
	}
}
