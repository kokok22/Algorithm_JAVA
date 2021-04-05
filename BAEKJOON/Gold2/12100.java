import java.util.*;
import java.io.*;

// 20*20(map의 크기)*20(최대 한 줄 이동 하니까)*4^5
// 계산결과 1억보다 작기 때문에 순열조합으로 풀어도 될 것 같다고 생각했습니다.

public class Easy {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		
		for(int y=0;y<map.length;y++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int x=0;x<map[0].length;x++)
				map[y][x] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = recursive(map, new int[5], 0);
		
		bw.write(cnt+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	// 최대값 도출하는 method
	private static int count(int[][] map) {
		int num = Integer.MIN_VALUE;
		
		for(int y=0;y<map.length;y++) {
			for(int x=0;x<map[0].length;x++)
				num = Math.max(num, map[y][x]);
		}
		
		return num;
	}
	
	// 배열 복사하는 method
	private static int[][] copy(int[][] map){
		int[][] temp = new int[map.length][map[0].length];
		
		for(int y=0;y<map.length;y++) {
			for(int x=0;x<map[0].length;x++)
				temp[y][x] = map[y][x];
		}
		
		return temp;
	}
	
	// 방향에 따라 이동하는 method
	private static void move(int[][] map, int d) {
		boolean[][] chk = new boolean[map.length][map[0].length];
		
		switch(d) {
		// 왼쪽으로 이동
		case 0:
			for(int y=0;y<map.length;y++) {
				int idx = 1;
				for(int x=1;x<map[0].length;x++) {
					if(map[y][x]==0)
						idx++;
					else if(map[y][x]==map[y][x-idx] && !chk[y][x-idx]) {
						map[y][x-idx] *= 2;
						if(map[y][x]!=0)
							chk[y][x-idx] = true;
						map[y][x]=0;
						idx++;
					}else {
						if(map[y][x-idx]==0) {
							map[y][x-idx] = map[y][x];
							map[y][x] = 0;
							idx++;
						}
						else {
							map[y][x-idx+1] = map[y][x];
							if(idx!=1)
								map[y][x]=0;
						}
					}
				}
			}
			break;
		
		// 오른쪽으로 이동
		case 1:
			for(int y=0;y<map.length;y++) {
				int idx = 1;
				for(int x=map[0].length-2;x>=0;x--) {
					if(map[y][x]==0)
						idx++;
					else if(map[y][x]==map[y][x+idx] && !chk[y][x+idx]) {
						map[y][x+idx] *= 2;
						if(map[y][x]!=0)
							chk[y][x+idx] = true;
						map[y][x]=0;
						idx++;
					}else {
						if(map[y][x+idx]==0) {
							map[y][x+idx] = map[y][x];
							map[y][x] = 0;
							idx++;
						}
						else {
							map[y][x+idx-1] = map[y][x];
							if(idx!=1)
								map[y][x]=0;
						}
					}
				}
			}
			break;
			
		// 아래로 이동
		case 2:
			for(int x=0;x<map[0].length;x++) {
				int idx = 1;
				for(int y=map.length-2;y>=0;y--) {
					if(map[y][x]==0)
						idx++;
					else if(map[y][x]==map[y+idx][x] && !chk[y+idx][x]) {
						map[y+idx][x] *= 2;
						if(map[y][x]!=0)
							chk[y+idx][x] = true;
						map[y][x]=0;
						idx++;
					}else {
						if(map[y+idx][x]==0) {
							map[y+idx][x] = map[y][x];
							map[y][x] = 0;
							idx++;
						}
						else {
							map[y+idx-1][x] = map[y][x];
							if(idx!=1)
								map[y][x]=0;
						}
					}
				}
			}
			break;
			
		// 위로 이동
		case 3:
			for(int x=0;x<map[0].length;x++) {
				int idx = 1;
				for(int y=1;y<map.length;y++) {
					if(map[y][x]==0)
						idx++;
					else if(map[y][x]==map[y-idx][x] && !chk[y-idx][x]) {
						map[y-idx][x] *= 2;
						if(map[y][x]!=0)
							chk[y-idx][x] = true;
						map[y][x]=0;
						idx++;
					}else {
						if(map[y-idx][x]==0) {
							map[y-idx][x] = map[y][x];
							map[y][x] = 0;
							idx++;
						}
						else {
							map[y-idx+1][x] = map[y][x];
							if(idx!=1)
								map[y][x] = 0;
						}
					}
				}
			}
			break;
		}
	}
	
	
	private static int recursive(int[][] map, int[] sel, int idx) {
		int cnt = 0;
		
		if(idx==sel.length) {
			int[][] temp = copy(map);
			for(int i=0;i<sel.length;i++)
				move(temp, sel[i]);
			return count(temp);
		}
		
		for(int i=0;i<4;i++) {
			sel[idx] = i;
			cnt = Math.max(cnt, recursive(map, sel, idx+1));
		}
		return cnt;
	}
}
