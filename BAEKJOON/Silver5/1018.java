import java.util.Scanner;

public class Main {

	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		
		int[][] check1 = {
				{'W','B','W','B','W','B','W','B'},
				{'B','W','B','W','B','W','B','W'}
		};
		
		int[][] check2 = {
				{'B','W','B','W','B','W','B','W'},
				{'W','B','W','B','W','B','W','B'}
		};
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		char[][] map = new char[M][N];
		
		
		// 지도 만들기
		for(int i=0;i<M;i++) {
			String color = sc.next();
			for(int j=0;j<N;j++)
				map[i][j] = color.charAt(j);
		}
		
		int min_num = 64;
		int[] count = new int[2];
		
		for(int y=0;y<=M-8;y++) {
			for(int x=0;x<=N-8;x++) {
				count[0] = 0;
				count[1] = 0;
				
				for(int i=0;i<8;i++) {
					for(int j=0;j<8;j++) {
						if(map[y+i][x+j]!=check1[i%2][j])
							count[0] += 1;
						if(map[y+i][x+j]!=check2[i%2][j])
							count[1] += 1;
					}
				}
				
				if(min_num > count[0])
					min_num = count[0];
				if(min_num > count[1])
					min_num = count[1];
			}
		}
		
		System.out.println(min_num);
		
	}
}