import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Snake {
	public static int[] dx = {1, 0, -1, 0};
	public static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		// 지도
		int[][] map = new int[N][N];
		
		// 사과의 위치를 입력해준다.
		for(int i=0;i<K;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			
			map[y][x] = 1;
		}
		
		// 방향 변환 횟수
		int L = Integer.parseInt(br.readLine());
		
		// 게임 시간
		int time = 0;
		
		// 뱀의 정보
		LinkedList<Node> snake = new LinkedList<Node>();
		snake.addFirst(new Node(0,0));
		
		// 뱀의 이동 방향
		int d = 0;
		
		// 게임 종료 확인
		boolean flag = false;
		
		// 입력
		for(int i=0;i<L;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int t = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			
			while(time<t) {
				
				flag = move(snake, map, d);
				time++;
				
				if(flag)
					break;
			}
			
			// 방향을 바꿔준다.
			if(c=='L') {
				d--;
				if(d<0)
					d=3;
			} else if(c=='D') {
				d++;
				if(d>3)
					d=0;
			}
			
			if(flag)
				break;
		}
		
		// 방향 변경하는 시간 내에 종료되지 않았으면 끝날 때가지 반복
		if(!flag) {
			while(!flag) {
				flag = move(snake, map, d);
				time++;
			}
		}
		
		bw.write(time+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	// 뱀이 이동하는 것
	private static boolean move(LinkedList<Node> snake, int[][] map, int d) {
		Node head = snake.getFirst();
		
		int x = head.x+dx[d];
		int y = head.y+dy[d];
		
		if(!(x>=0 && x<map[0].length && y>=0 && y<map.length) || chk(snake, x, y)) {
			return true;
		}
		
		if(map[y][x]==1) {
			map[y][x]=0;
		}
		else {
			snake.removeLast();
		}
		snake.addFirst(new Node(x,y));
		
		return false;
	}
	
	// 본인의 몸과 부딪혔는지 확인
	private static boolean chk(LinkedList<Node> snake, int x, int y) {
		// 뱀의 머리가 이동한 곳에 몸이 있는 지 확인
		for(int i=0;i<snake.size();i++) {
			Node temp = snake.get(i);
			
			if(temp.x==x && temp.y==y) {
				return true;
			}
		}
		return false;
	}
}

class Node{
	int x;
	int y;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
