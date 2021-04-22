import java.io.*;
import java.util.*;

public class WordMath {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		// 알파벳 개수만큼 배열 생성
		Word[] words = new Word['Z'-'A'+1];
		
		
		for(int i=0;i<words.length;i++)
			words[i] = new Word((char)('A'+i));
		
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			
			int v = 1;
			
			// 해당 알파벳이 등장한 자릿수를 더해준다.
			for(int j=0;j<s.length();j++) {
				char c = s.charAt(s.length()-j-1);
				words[c-'A'].nums += 1*v;
				
				v *= 10;
			}
		}
		
		Arrays.sort(words);
		
		int sum = 0;
		
		// 최대 알파벳의 숫자는 10개이고 0은 어차피 결과에 영향이 없으니까 9번만 돈다.
		for(int i=9;i>0;i--) {
			Word w = words[9-i];
			
			sum += i*w.nums;
		}
		
		bw.write(sum+"");
		bw.flush();
		br.close();
		bw.close();
	}
}
class Word implements Comparable{
	char c;
	int nums = 0;
	
	public Word(char c) {
		this.c = c;
	}

	@Override
	public int compareTo(Object o) {
		Word w = (Word) o;
		
		if(w.nums == this.nums)
			return Integer.compare(this.c, w.c);
		return Integer.compare(w.nums, this.nums);
	}
}