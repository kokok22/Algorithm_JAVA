import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int K = sc.nextInt();
		
		for (int i=0;i<K;i++) {
			int sum = 0;
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			for(int x = x1;x<=x2;x++) {
				for(int y = y1;y<=y2;y++) {
					sum += map[x-1][y-1];		
				}
			}	
			System.out.println(sum);
		}
	}
}