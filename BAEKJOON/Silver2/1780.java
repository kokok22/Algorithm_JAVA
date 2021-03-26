import java.util.*;
import java.io.*;

public class NumberOfPaper {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		
		for(int y=0;y<N;y++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int x=0;x<N;x++)
				map[y][x] = Integer.parseInt(st.nextToken());
		}
		
		int[] result = new int[3];
		
		recursive(map, result, 0, map[0].length, 0, map.length);
		
		for(int r:result)
			bw.write(r+"\n");
		
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void recursive(int[][] map, int[] result, int x1, int x2, int y1, int y2) {
		int chk = -2;
		boolean flag = true;
		
		for(int y=y1;y<y2;y++) {
			for(int x=x1;x<x2;x++) {
				if(chk==-2)
					chk = map[y][x];
				else if(chk!=map[y][x]) {
					flag = false;
					recursive(map, result, x1, x1+(x2-x1)/3, y1, y1+(y2-y1)/3);
					recursive(map, result, x1+(x2-x1)/3, x1+2*(x2-x1)/3, y1, y1+(y2-y1)/3);
					recursive(map, result, x1+2*(x2-x1)/3, x2, y1, y1+(y2-y1)/3);
					
					recursive(map, result, x1, x1+(x2-x1)/3, y1+(y2-y1)/3, y1+2*(y2-y1)/3);
					recursive(map, result, x1+(x2-x1)/3, x1+2*(x2-x1)/3, y1+(y2-y1)/3, y1+2*(y2-y1)/3);
					recursive(map, result, x1+2*(x2-x1)/3, x2, y1+(y2-y1)/3, y1+2*(y2-y1)/3);
										
					recursive(map, result, x1, x1+(x2-x1)/3, y1+2*(y2-y1)/3, y2);
					recursive(map, result, x1+(x2-x1)/3, x1+2*(x2-x1)/3, y1+2*(y2-y1)/3, y2);
					recursive(map, result, x1+2*(x2-x1)/3, x2, y1+2*(y2-y1)/3, y2);
					return;
				}
			}
		}
		if(flag)
			result[chk+1] +=1;
	}
}
