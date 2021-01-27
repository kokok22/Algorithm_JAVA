import java.util.Scanner;

public class Main {

	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		char[][] map = new char[N][N];
		
		// map 생성
		for(int i=0;i<N;i++) {
			String text = sc.next();
			for(int j=0;j<N;j++)
				map[i][j] = text.charAt(j);
		}
		
		// max 값
		int max_count = 1;
	
		// 가로 먼저 계산
		for(int i=0;i<N;i++) {
			for(int j=0;j<N-1;j++) {
				if(map[i][j] != map[i][j+1]) {
					// swap
					char temp = map[i][j];
					map[i][j] = map[i][j+1];
					map[i][j+1] = temp;
					
					int count1 = column(map);
					int count2 = row(map);
					
					if(max_count < count1)
						max_count = count1;
					if(max_count < count2)
						max_count = count2;
					
					// 원위치
					map[i][j+1] = map[i][j];
					map[i][j] = temp;
				}
			}
		}
		
		// 세로 계산
		for(int i=0;i<N;i++) {
			for(int j=0;j<N-1;j++) {
				if(map[j][i] != map[j+1][i]) {
					// swap
					char temp = map[j][i];
					map[j][i] = map[j+1][i];
					map[j+1][i] = temp;
					
					int count1 = column(map);
					int count2 = row(map);
					
					if(max_count < count1)
						max_count = count1;
					if(max_count < count2)
						max_count = count2;
					
					// 원위치
					map[j+1][i] = map[j][i];
					map[j][i] = temp;
				}
			}
		}	
		System.out.println(max_count);		
	}
	
	// 가로방향으로 최다 동일 검사
	public static int row(char[][] map) {
		int max_count = 1;
		
		for(int y=0;y<map.length;y++) {
			int count = 1;
			char pre = map[y][0];
			for(int x=1;x<map.length;x++) {
				if(pre==map[y][x]) {
					count+=1;
				}
				else {
					pre = map[y][x];
					count = 1;
				}
				if(max_count < count)
					max_count = count;
			}
		}
		return max_count;
	}
	
	// 세로방향으로 검사 최다 동일 검사
	public static int column(char[][] map) {
		int max_count = 1;
		
		for(int x=0;x<map.length;x++) {
			int count = 1;
			char pre = map[0][x];
			for(int y=1;y<map.length;y++) {
				if(pre==map[y][x])
					count+=1;
				else {
					pre = map[y][x];
					count = 1;
				}
				if(max_count < count)
					max_count = count;
			}
		}
		return max_count;
	}
}
