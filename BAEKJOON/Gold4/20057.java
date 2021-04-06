import java.io.*;
import java.util.*;

public class WizardShark {
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};
	
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
		
		int cnt = search(map, N/2, N/2);

		bw.write(cnt+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	// 간단하게 정리 좀 해보고 싶은데 잘 안되네요...ㅜㅠ
	
	public static int move(int[][] map, int y, int x, int d) {
		int rest = map[y][x];
		int sum = 0;
		
		int one = (int)(rest*0.01);
		int two = (int)(rest*0.02);
		int five = (int)(rest*0.05);
		int seven = (int)(rest*0.07);
		int ten = (int)(rest*0.1);
		
		int a = rest - 2*ten - 2*seven - five -2*two - 2*one;
		
		map[y][x] = 0;
		
		switch(Math.abs(d)) {
		// 왼(-1), 오(1)
		case 1:
			// 1줄
			if(y-2<0)
				sum += two;
			else
				map[y-2][x] += two;
			
			// 2줄
			if(y-1>=0) {
				if(x+d>=0 && x+d<map[0].length)
					map[y-1][x+d] += ten;
				else
					sum += ten;
				map[y-1][x] += seven;
				map[y-1][x-d] += one;
			}else
				sum += (ten + seven + one);
			
			// 3줄
			if(x+2*d>=0 && x+2*d<map[0].length) {
				map[y][x+2*d] += five;
				map[y][x+d] += a;
			}else if(x+d>=0 && x+d<map[0].length) {
				sum += five;
				map[y][x+d] += a;
			}else {
				sum += five;
				sum += a;
			}
			
			// 4줄
			if(y+1<map.length) {
				if(x+d>=0 && x+d<map[0].length)
					map[y+1][x+d] += ten;
				else
					sum += ten;
				map[y+1][x] += seven;
				map[y+1][x-d] += one;
			}else
				sum += (ten + seven + one);

			// 5줄
			if(y+2<map.length)
				map[y+2][x] += two;
			else
				sum += two;
			
			break;
		
		// 위(2), 아래(-2)
		case 2:
			// 위(1), 아래(-1)
			d = d/2;
			
			// 1줄
			if(x-2<0)
				sum += two;
			else
				map[y][x-2] += two;
			
			// 2줄
			if(x-1<0)
				sum += (one + seven + ten);
			else {
				if(y-d>=0 && y-d<map.length)
					map[y-d][x-1] += ten;
				else
					sum += ten;
				map[y][x-1] += seven;
				map[y+d][x-1] += one;
			}
			
			// 3줄
			if(y-2*d>=0 && y-2*d<map.length) {
				map[y-2*d][x] += five;
				map[y-d][x] += a;
			}else if(y-d>=0 && y-d<map.length) {
				sum += five;
				map[y-d][x] += a;
			}else
				sum += (five + a);
			
			// 4줄
			if(x+1<map[0].length) {
				if(y-d>=0 && y-d < map.length)
					map[y-d][x+1] += ten;
				else
					sum += ten;
				map[y][x+1] += seven;
				map[y+d][x+1] += one;
			}else
				sum += (one + seven + ten);
			
			// 5줄
			if(x+2<map[0].length)
				map[y][x+2] += two;
			else
				sum += two;

			break;
		}
		
		return sum;
	}
	
	
	public static int search(int[][] map, int y, int x) {
		int[] idx = {-1, -2, 1, 2};
		
		int sum = 0;
		
		int cnt = 1;
		int d = 0;
		boolean flag = false;
		
		while(x>=0 && x<map[0].length && y>=0 && y<map.length) {
			for(int i=0;i<cnt;i++) {
				y += dy[d];
				x += dx[d];
				
				if(x>=0 && x<map[0].length && y>=0 && y<map.length)
					sum += move(map, y, x, idx[d]);
				else
					break;
			}
			
			d = (d+1)%4;
			
			if(flag) {
				cnt++;
				flag = false;
			}else
				flag = true;
		}

		return sum;
	}
}
