import java.util.*;
import java.io.*;

public class WoodInvestmentTechnology {
	public static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
	public static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] A = new int[N][N];
		
		for(int y=0;y<N;y++) {
			st = new StringTokenizer(br.readLine());
			for(int x=0;x<N;x++)
				A[y][x] = Integer.parseInt(st.nextToken());
		}
		
		int[][] fert = new int[N][N];
		for(int i=0;i<N;i++)
			Arrays.fill(fert[i],5);
		
		Tree[][] tree = new Tree[N][N];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			tree[x-1][y-1] = new Tree(z);
		}
		
		for(int i=0;i<K;i++) {
			springTofall(fert, tree);  // 봄부터 가을까지
			winter(fert, A, tree);
		}
		int cnt = check(tree);
		
		bw.write(cnt+"");
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static int check(Tree[][] tree) {
		int cnt = 0;
		
		for(int y=0;y<tree.length;y++) {
			for(int x=0;x<tree[0].length;x++) {
				while(!tree[y][x].heap.isEmpty()) {
					cnt++;
					tree[y][x].heap.poll();
				}
			}
		}
		
		return cnt;
	}
	
	public static void springTofall(int[][] fert, Tree[][] tree) {
		int[][] mini = new int[fert.length][fert[0].length];   // 번식한 나무들
		
		
		for(int y=0;y<fert.length;y++) {
			for(int x=0;x<fert[0].length;x++) {
				PriorityQueue<Integer> heap = new PriorityQueue<Integer>(); // 생존 한 나무가 저장될 heap이다.
				
				int rest = 0;
				
				// 해당 좌표에 나무가 있는지 확인, null인 경우는 아직 나무가 심어진 적이 없는 땅이다.
				while(tree[y][x] != null && !tree[y][x].heap.isEmpty()) {
					int temp = tree[y][x].heap.poll();
					
					// 나무의 나이보다 양분이 많거나 같으면
					if(temp<=fert[y][x]) {
						heap.offer(temp+1);
						fert[y][x] -= temp;
						
						// 1살을 더했을 때 5의 배수이면 번식을 하게 된다.
						if((temp+1)%5==0) {
							for(int i=0;i<8;i++) {
								int ny = y+dy[i];
								int nx = x+dx[i];
								
								if(ny>=0 && ny<fert.length && nx>=0 && nx<fert[0].length)
									mini[ny][nx] += 1;   // 임시 리스트에 해당 좌표에 새로 번식하게 되는 나무의 개수가 저장된다.
							}
						}
					
					// 여름에 나무의 나이/2만큼 양분이 증가하게 된다. 그 값을 저장하는 변수이다.
					}else
						rest += temp/2;
				}
				
				// 여름에 증가하는 양분의 값을 양분 배열에 더해준다.
				fert[y][x] += rest;
				
				// 생존한 나무가 들어있는 힙을 해당 좌표의 값으로 넣어준다.
				if(tree[y][x] == null)
					tree[y][x] = new Tree();
				tree[y][x].heap = heap;
			}
		}
		
		// 나무가 번식하는 과정
		for(int y=0;y<fert.length;y++) {
			for(int x=0;x<fert[0].length;x++) {
				while(mini[y][x]-->0)
					tree[y][x].heap.offer(1);
			}
		}
		
	}
	
	public static void winter(int[][] fert, int[][] A, Tree[][] tree) {
		for(int y=0;y<fert.length;y++) {
			for(int x=0;x<fert[0].length;x++)
				fert[y][x] += A[y][x];
		}
	}
}

class Tree{
	PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
	
	public Tree() {};
	
	public Tree(int tree) {
		heap.offer(tree);
	}
}