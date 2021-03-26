import java.util.*;
import java.io.*;

public class FishingKing {
	public static int[] dx = {0, 0, 0, 1, -1};
	public static int[] dy = {0, -1, 1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Shark[][] map = new Shark[R][C];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			map[r-1][c-1] = new Shark(s,d,z);
		}
		
		int result = 0;
		
		for(int x=0;x<map[0].length;x++) {
			// 상어 잡기
			for(int y=0;y<map.length;y++) {
				if(map[y][x]!=null) {
					result += map[y][x].z;
					map[y][x] = null;
					break;
				}
			}
			
			Shark[][] temp = new Shark[map.length][map[0].length];
			
			// 상어 이동
			for(int i=0;i<map[0].length;i++) {
				for(int j=0;j<map.length;j++) {
					if(map[j][i]!=null) {
						Shark shark = map[j][i];
						int ny = j;
						int nx = i;

						// 위-아래
						if(shark.d<=2) {
							ny += shark.s*dy[shark.d];
							
							while(ny<0 || ny>map.length-1) {
								if(ny<0) {
									shark.d = 2;
									ny = Math.abs(ny);
								}
								else if(ny>map.length-1) {
									shark.d = 1;
									ny = 2*(map.length-1)-ny;
								}
							}
						}
						// 좌-우
						else if(shark.d>=3) {
							nx = i+shark.s*dx[shark.d];
							
							while(nx<0 || nx>map[0].length-1) {
								if(nx<0) {
									shark.d = 3;
									nx = Math.abs(nx);
								}
								else if(nx>map[0].length-1) {
									shark.d = 4;
									nx = 2*(map[0].length-1)-nx;
								}
							}
						}
						
						if(temp[ny][nx]!= null) {
							Shark shark2 = temp[ny][nx];
							
							if(shark2.z < shark.z)
								temp[ny][nx] = shark;
						}
						else
							temp[ny][nx] = shark;
					}
				}
			}
			
			map=temp;
		}
		
		bw.write(result+"");
		bw.flush();
		br.close();
		bw.close();
	}
}

class Shark{
	int s, d, z;
	
	public Shark(int s, int d, int z) {
		this.s = s;
		this.d = d;
		this.z = z;
	}
}
