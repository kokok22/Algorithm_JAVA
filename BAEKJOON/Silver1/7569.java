import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato {
	public static int[] dx = {-1, 1, 0, 0, 0, 0};
	public static int[] dy = {0, 0, -1, 1, 0, 0};
	public static int[] dz = {0, 0, 0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int Z = Integer.parseInt(st.nextToken());
		
		Node[][][] map = new Node[Z][Y][X];
		
		for(int z=0;z<Z;z++) {
			for(int y=0;y<Y;y++) {
				st = new StringTokenizer(br.readLine());
				for(int x=0;x<X;x++)
					map[z][y][x] = new Node(Integer.parseInt(st.nextToken()), 0, false);
			}
		}
		
		for(int z=0;z<Z;z++) {
			for(int y=0;y<Y;y++) {
				for(int x=0;x<X;x++) {
					Node temp = map[z][y][x];
					if(temp.state==1 && temp.day==0 && !temp.visit)
						bfs(map, z, y, x);
				}
			}
		}
		
		int cnt = chk(map);
		
		bw.write(cnt+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static int chk(Node[][][] map) {
		int answer = 0;
		
		for(int z=0;z<map.length;z++) {
			for(int y=0;y<map[0].length;y++) {
				for(int x=0;x<map[0][0].length;x++) {
					Node temp = map[z][y][x];
					if(temp.state==0)
						return -1;
					else
						answer = Math.max(answer, temp.day);
				}
			}
		}
		return answer;
	}
	
	public static void bfs(Node[][][] map, int z, int y, int x) {
		Queue<Point>queue = new LinkedList<Point>();
		queue.offer(new Point(z,y,x));
		
		while(!queue.isEmpty()) {
			int n = queue.size();
			
			while(n-->0) {
				Point p = queue.poll();
				Node temp = map[p.z][p.y][p.x];
				temp.visit = true;
				
				for(int i=0;i<6;i++) {
					int nz = p.z+dz[i];
					int ny = p.y+dy[i];
					int nx = p.x+dx[i];
					
					if(nz>=0 && nz<map.length && ny>=0 && ny<map[0].length && nx>=0 && nx<map[0][0].length) {
						Node ntemp = map[nz][ny][nx];
						// 이미 익은 것 
						if(ntemp.state==1) {
							// 날짜가 지금보다 빠른 것 그리고 아직 안 지나갔던 것
							if(temp.day+1>ntemp.day && !ntemp.visit) {
								ntemp.visit = true;
								queue.offer(new Point(nz,ny,nx));
							}
							if(temp.day+1<ntemp.day) {
							// 날짜가 지금보다 느린 것, 지금 날짜로 변경, 방문여부 상관 없음
								ntemp.visit = true;
								ntemp.day = temp.day+1;
								queue.offer(new Point(nz,ny,nx));
							}
						}
							
						// 안 익은 것
						if(ntemp.state==0) {
							ntemp.state = 1;
							ntemp.day = temp.day+1;
							ntemp.visit = true;
							queue.offer(new Point(nz,ny,nx));
						}
					}
				}
			}
		}
	}
}

class Node{
	int state;
	int day;
	boolean visit;
	
	public Node(int state, int day, boolean visit) {
		this.state = state;
		this.day = day;
		this.visit = visit;
	}
}

class Point{
	int z;
	int y;
	int x;
	
	public Point(int z, int y, int x) {
		this.z = z;
		this.y = y;
		this.x = x;
	}
}