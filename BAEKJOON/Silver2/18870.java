import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Compression {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] temp = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			temp[i] = arr[i];
		}
		
		Arrays.sort(temp);
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		
		int idx = 0;
		
		for(int i=0;i<temp.length;i++) {
			if(!hash.containsKey(temp[i]))
				hash.put(temp[i], idx++);
		}
		
		for(int num : arr)
			bw.write(hash.get(num)+" ");
			
		bw.flush();
		br.close();
		bw.close();
	}
}

