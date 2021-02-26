import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PuyoPuyo {
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		char[][] map = new char[12][6];
		
		for(int y=0;y<12;y++) {
			String s = br.readLine();
			for(int x=0;x<6;x++)
				map[y][x] = s.charAt(x);
		}
		
		int answer = 0;
		
		while(true) {
			
			boolean[][] chk = new boolean[12][6];
			int temp = 0;
			
			for(int y=0;y<12;y++) {
				for(int x=0;x<6;x++) {
					if(map[y][x] != '.' && !chk[y][x])
						temp += bfs(map, y, x, map[y][x], chk);
				}
			}
			if(temp==0)
				break;

			move(map);
			answer++;

		}
		bw.write(answer+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	private static void move(char[][] map) {
		for(int x=0;x<map[0].length;x++) {
			for(int y=map.length-1;y>=0;y--) {
				int cnt=0;
				
				while(map[y-cnt][x]=='.') {
					cnt++;
					if(y-cnt<0)
						break;
				}
				
				if(cnt==0)
					continue;
				
				int i=0;
				while(y-cnt-i>=0) {
					map[y-i][x] = map[y-i-cnt][x];
					i++;
				}
				map[0][x] = '.';
			}
		}
		
	}
	
	private static int bfs(char[][] map, int y, int x, char c, boolean[][] chk) {
		int answer = 0;
		
		Stack<Integer> stack = new Stack<Integer>();
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(y*map[0].length+x);
		stack.push(y*map[0].length+x);
		chk[y][x] = true;
		
		while(!queue.isEmpty()) {
			int n = queue.size();
			
			while(n-->0) {
				int idx = queue.poll();
				y = idx/map[0].length;
				x = idx%map[0].length;
				
				for(int i=0;i<4;i++) {
					int ny = y+dy[i];
					int nx = x+dx[i];
					
					if(nx>=0 && nx<map[0].length && ny>=0 && ny<map.length && map[ny][nx]==c && !chk[ny][nx]) {
						queue.offer(ny*map[0].length+nx);
						stack.push(ny*map[0].length+nx);
						chk[ny][nx]=true;
					}
				}
			}
		}
		
		if(stack.size()>=4) {
			answer = 1;
			while(!stack.isEmpty()) {
				int idx = stack.pop();
				int ny = idx/map[0].length;
				int nx = idx%map[0].length;
				
				map[ny][nx] = '.';
			}
		}
		return answer;
	}
}
