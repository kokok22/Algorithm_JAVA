import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class KoreanMelonField {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] reverse = {0, 3, 4, 2, 1};
		
		int K = Integer.parseInt(br.readLine());
		
		int X = 0;
		int Y = 0;
		
		boolean flag = false;
		
		int min1 = 0;
		int min2 = 0;
		
		int[] temp = new int[6];
		int pre = 0;
		
		for(int i=0;i<6;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			
			if(d == 3 || d == 4)
				Y = Math.max(Y, len);
			else
				X = Math.max(X, len);
			
			if(!flag) {
				if(d==reverse[pre]) {
					min1 = temp[i-1];
					min2 = len;
					flag = true;
				}
			}
			temp[i] = len;
			pre = d;
		}		
		
		if(!flag) {
			min1 = temp[5];
			min2 = temp[0];
		}
			
		int answer = ((X*Y)-(min1*min2))*K;
		
		bw.write(answer+"");
		bw.flush();
		br.close();
		bw.close();
	}
}


//7
//4 50
//2 160
//3 30
//1 60
//3 20
//1 100
//
//7
//4 30
//2 60
//4 20
//2 100
//3 50
//1 160
//
//7
//4 50
//2 100
//3 20
//2 60
//3 30
//1 160
