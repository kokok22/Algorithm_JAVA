import java.util.Scanner;

public class Main {

	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		int MAX_NUM = 1000000;
		
		boolean[] prime = new boolean[MAX_NUM+1];

		prime[2] = true;		
		for(int i=3;i<MAX_NUM;i+=2)
			prime[i] = true;
		
		for(int i=3;i*i<MAX_NUM;i+=2) {
			if(prime[i]) {
				for(int j=i*2;j<MAX_NUM;j+=i) {
					prime[j] = false;
				}
			}
		}

		int num = sc.nextInt();
		
		while(true) {
			if(num==0)
				break;
			Boolean find = false;
			for(int i=0;i<= num/2;i++) {
				if(prime[i] && prime[num-i]) {
					System.out.printf("%d = %d + %d\n",num,i,num-i);
					find = true;
					break;
				}
			}
			if(!find)
				System.out.println("Goldbach's conjecture is wrong.");
			num = sc.nextInt();	
		}
	}
}