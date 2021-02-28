import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class MySet {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int M = Integer.parseInt(br.readLine());
		
		Set<Integer> set = new HashSet<Integer>();
		
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String op = st.nextToken();
			
			if(op.equals("add"))
				set.add(Integer.parseInt(st.nextToken()));
			else if(op.equals("remove"))
				set.remove(Integer.parseInt(st.nextToken()));
			else if(op.equals("check")) {
				if(set.contains(Integer.parseInt(st.nextToken())))
					bw.write(1+"\n");
				else
					bw.write(0+"\n");
			}else if(op.equals("toggle")) {
				int num = Integer.parseInt(st.nextToken());
				if(set.contains(num))
					set.remove(num);
				else
					set.add(num);
			}else if(op.equals("all")) {
				Set<Integer> temp = new HashSet<Integer>();
				for(int j=0;j<20;j++)
					temp.add(j+1);
				set = temp;
			}else if(op.equals("empty"))
				set = new HashSet<Integer>();
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
}
