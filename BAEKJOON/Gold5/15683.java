import java.io.*;
import java.util.*;

public class Surveillance {
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		
		for(int y=0;y<N;y++) {
			st = new StringTokenizer(br.readLine());
			for(int x=0;x<M;x++)
				map[y][x] = Integer.parseInt(st.nextToken());
		}
		
		int check = recursive(map, new boolean[N][M]);
		
		bw.write(check+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static int recursive(int[][] map ,boolean[][] chk) {
		int result = Integer.MAX_VALUE;
		
		boolean flag = false;
		
		int ny = 0;
		int nx = 0;
		
		for(int y=0;y<map.length;y++) {
			for(int x=0;x<map[0].length;x++) {
				if(map[y][x]>0 && map[y][x]<6 && !chk[y][x]) {
					flag = true;
					ny = y;
					nx = x;
					break;
				}
			}
		}

		//System.out.println("\ny:"+ny+" x:"+nx+"\n");
		
		// 끝까지 확인 한 경우
		if(!flag) {
			int cnt = 0;
			//System.out.println();
			for(int y=0;y<map.length;y++) {
				for(int x=0;x<map[0].length;x++) {
					//System.out.print(map[y][x]+" ");
					if(map[y][x]==0)
						cnt++;
				}
				//System.out.println();
			}
			
			return cnt;
		}
		
		else {
			int d = map[ny][nx];
			chk[ny][nx] = true;
			
			int[][] temp;
			
			switch(d) {
			case 1:
				for(int i=0;i<4;i++) {
					temp = copy(map);
					view(temp, ny, nx, i);
					result = Math.min(result, recursive(temp, chk));
				}
				break;
			case 2:
				for(int i=0;i<2;i++) {
					temp = copy(map);
					view(temp, ny, nx, i*2);
					view(temp,ny, nx, i*2+1);
					result = Math.min(result, recursive(temp, chk));
				}
				break;
			case 3:
				for(int i=0;i<2;i++) {
					for(int j=2;j<4;j++) {
						temp = copy(map);
						view(temp, ny, nx, i);
						view(temp, ny, nx, j);
						result = Math.min(result, recursive(temp, chk));
					}
				}
				break;
			case 4:
				for(int i=0;i<2;i++) {
					temp = copy(map);
					view(temp,ny, nx, i);
					view(temp, ny, nx, 2);
					view(temp, ny, nx, 3);
					result = Math.min(result, recursive(temp, chk));
				}
				for(int i=2;i<4;i++) {
					temp = copy(map);
					view(temp, ny, nx, i);
					view(temp, ny, nx, 0);
					view(temp, ny, nx, 1);
					result = Math.min(result, recursive(temp, chk));
				}
				break;
			case 5:
				temp = copy(map);
				
				for(int i=0;i<4;i++)
					view(temp, ny, nx, i);
				result = Math.min(result, recursive(temp, chk));
				break;
			}
			chk[ny][nx] = false;
		}
		return result;
	}
	
	public static int[][] copy(int[][] map){
		int[][] temp = new int[map.length][map[0].length];
		
		for(int y=0;y<map.length;y++) {
			for(int x=0;x<map[0].length;x++)
				temp[y][x] = map[y][x];
		}
		
		return temp;
	}
	
	public static void view(int[][] map, int y, int x, int i) {	
		while(y>=0 && y<map.length && x>=0 && x<map[0].length && map[y][x] !=6) {
			if(map[y][x]==0)
				map[y][x] = 7;
			y+= dy[i];
			x+= dx[i];
		}
	}
}





//2 6 7 3 7 2
//7 0 0 7 0 7
//7 0 0 7 0 7
//7 0 0 7 6 1



