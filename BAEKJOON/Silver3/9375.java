import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class FashionKing {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			int n = Integer.parseInt(br.readLine());
			HashMap<String, Integer> set = new HashMap<String, Integer>();
			ArrayList<String> keys = new ArrayList<String>();
			
			for(int i=0;i<n;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String name = st.nextToken();
				String kind = st.nextToken();
				
				if(set.containsKey(kind))
					set.put(kind, set.get(kind)+1);
				else {
					set.put(kind, 1);
					keys.add(kind);
				}
			}
			
			int answer = 1;
			
			for(int i=0;i<keys.size();i++)
				answer *= (set.get(keys.get(i))+1);
			
			bw.write((answer-1)+"\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
}
