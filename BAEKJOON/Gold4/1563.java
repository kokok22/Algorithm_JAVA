import java.io.*;

public class PerfectAttendance {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		// 출석, 지각, 결석1, 결석2   // 지각 0회, 지각 1회
		int[][][] result = new int[1001][4][2];	

		for(int i=1;i<1001;i++) {
			if(i==1) {
				result[i][0][0] = 1;
				result[i][1][1] = 1;
				result[i][2][0] = 1;
			}
			else {
				result[i][0][0] = (result[i-1][0][0] + result[i-1][2][0] + result[i-1][3][0])%1000000;
				result[i][0][1] = (result[i-1][0][1] + result[i-1][1][1] + result[i-1][2][1] + result[i-1][3][1])%1000000;
				result[i][1][1] = (result[i-1][0][0] + result[i-1][2][0] + result[i-1][3][0])%1000000;
				result[i][2][0] = result[i-1][0][0]%1000000;
				result[i][2][1] = (result[i-1][0][1] + result[i-1][1][1])%1000000;
				result[i][3][0] = result[i-1][2][0]%1000000;
				result[i][3][1] = result[i-1][2][1]%1000000;
			}
		}
		
		int sum = 0;
		
		for(int y=0;y<4;y++) {
			for(int x=0;x<2;x++)
				sum += (result[N][y][x]%1000000);
		}
		
		bw.write(sum%1000000+"");
		bw.flush();
		br.close();
		bw.close();
	}
}