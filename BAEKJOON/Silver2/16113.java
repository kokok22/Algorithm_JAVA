import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Signal {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		char[][] map = new char[5][N/5];
		
		String s = br.readLine();
		
		int cnt = 0;
		
		for(int y=0;y<5;y++) {
			for(int x=0;x<N/5;x++)
				map[y][x] = s.charAt(cnt++);
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int x=0;x<N/5;x++) {
			int num = count(map,x);
			if(num==0) {
				if(sb.length()>0) {
				
					if(sb.toString().equals("434") && map[3][x-1]=='#')
						sb.append("0");
					
					bw.write(convert(sb.toString())+"");
					sb.setLength(0);
				}
				continue;
			}
			
			sb.append(num);
		}
		
		if(sb.length()>0) {
			if(sb.toString().equals("434") && map[3][N/5-1]=='#')
				sb.append("0");
			
			bw.write(convert(sb.toString())+"");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
	
	private static int count(char[][] map, int x) {
		int cnt = 0;
		for(int y=0;y<5;y++) {
			if(map[y][x]=='#')
				cnt++;
		}
		
		return cnt;
	}
	
	private static int convert(String s) {
		String[] arr = {"525", "5", "434", "335", "315", "4340", "534", "115", "535", "435"};
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i].equals(s))
				return i;
		}
		
		return 0;
	}
}
