import java.util.*;
import java.io.*;

public class BabyShark {
	public static int[] dx = {0, 0, -1, 1};
	public static int[] dy = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		Point[] ps = new Point[N*N];
		
		for(int i=0;i<N*N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
		
			int no = Integer.parseInt(st.nextToken());
			int[] ls = new int[4];
			
			for(int j=0;j<4;j++)
				ls[j] = Integer.parseInt(st.nextToken());
			
			ps[i] = new Point(no, ls);
		}
		
		int[][] map = new int[N][N];
		
		mapping(map, ps, N);
		
		//print(map);
		
		int result = count(map, ps, N);
		
		bw.write(result+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void print(int[][] map) {
		System.out.println();
		for(int y=0;y<map.length;y++) {
			for(int x=0;x<map[0].length;x++)
				System.out.print(map[y][x]+" ");
			System.out.println();
		}
	}
	
	public static int count(int[][] map, Point[] ps, int N) {
		int result = 0;
		
		for(int i=0;i<N*N;i++) {
			Point p = ps[i];
			int no = p.no;
			int[] likes = p.like;
			
			boolean flag = false;
			
			int count = 0;
			
			for(int y=0;y<N;y++) {
				for(int x=0;x<N;x++) {
					if(map[y][x]==no) {
						flag = true;
						for(int j=0;j<4;j++) {
							int ny = y+dy[j];
							int nx = x+dx[j];
							
							if(ny>=0 && ny<map.length && nx>=0 && nx<map[0].length) {
								for(int like : likes) {
									if(like==map[ny][nx])
										count++;
								}
							}
						}
					}
					if(flag) {
						int temp = 0;
						for(int j=0;j<count;j++) {
							if(temp==0)
								temp++;
							else {
								temp *= 10;
							}
						}
						result += temp;
						break;
					}
				}
				if(flag)
					break;
			}
		}
		
		return result;
	}
	
	public static void mapping(int[][] map, Point[] ps, int N) {
		
		for(int i=0;i<N*N;i++) {
			Point p = ps[i];
			int no = p.no;
			int[] likes = p.like;
			
			int favorite = Integer.MIN_VALUE;
			int empty = Integer.MIN_VALUE;
			int tx = Integer.MAX_VALUE;
			int ty = Integer.MAX_VALUE;
			
			for(int y=0;y<N;y++) {
				for(int x=0;x<N;x++) {
					if(map[y][x]!=0)
						continue;
					
					int tlike = 0;
					int tempty = 0;
					
					for(int j=0;j<4;j++) {
						int ny = y+dy[j];
						int nx = x+dx[j];
						
						if(ny>=0 && ny<map.length && nx>=0 && nx<map[0].length) {
							if(map[ny][nx]==0) {
								tempty++;
								continue;
							}
							for(int like : likes) {
								if(like==map[ny][nx])
									tlike++;
							}
						}
					}
					
					// 1반 조건
					if(favorite<tlike) {
						favorite = tlike;
						empty = tempty;
						tx = x;
						ty = y;
					}
					
					// 2번 조건
					else if(favorite==tlike) {
						if(empty<tempty) {
							empty = tempty;
							tx = x;
							ty = y;
						}
						
						// 3번 조건
						else if(empty==tempty) {
							if(ty>y) {
								ty =y ;
								tx =x;
							}
							
							else if(ty==y && tx>x) {
								tx = x;
							}
						}
					}
				}
			}
			
			map[ty][tx] = no;
		}
	}
}

class Point{
	int no;
	int[] like = new int[4];
	
	public Point(int no, int[] like) {
		this.no = no;
		this.like = like;
	}
}
