import java.util.Scanner;

public class Main {

	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=0;t<T;t++) {
			int N = sc.nextInt();
			int[] score = new int[N];
			
			float total=0;
			for(int i=0;i<N;i++) {
				score[i] = sc.nextInt();
				total += score[i];
			}
			
			float avg = total/N;
			
			int count = 0;
			for(int i=0;i<N;i++) {
				if(score[i]>avg)
					count += 1;
			}
			
			System.out.printf("%.3f%%\n",(float)count/N*100);
		}
	}
}