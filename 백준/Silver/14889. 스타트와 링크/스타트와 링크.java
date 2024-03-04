import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;


public class Main {
	
	private static List<List<Integer>> arr;
	private static boolean[] visited;
	private static int result;
	private static int total;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		visited = new boolean[N];
		arr = new ArrayList<>();
//		배열 정보 저장
		for (int i=0; i<N; i++) {
			visited[i] = false;
			String[] str = br.readLine().split(" ");
			List<Integer> tmp = new ArrayList<Integer>();
			for (String token: str) {
				tmp.add(Integer.parseInt(token));
			}
			total += sum(tmp);
			arr.add(tmp);
		}
//		정답 데이터 초기값
		result = total;
		
		dfs(N, 0, 0, 0, total);
		bw.write(String.valueOf(result));
		bw.close();
		
	}
	
	public static int sum(List<Integer> v) {
		int result = 0;
		for (int i: v) {
			result += i;
		}
		return result;
	}
	
	public static int abs(int a, int b) {
		if (a > b) {
			return a - b;
		} else {
			return b - a;
		}
	}
	
	public static void dfs(int N, int depth, int start, int sumA, int sumB) {
		if (result < sumA-sumB) {return ;}
		if (depth == N / 2) {
			if (result > abs(sumA, sumB)) {
				result = abs(sumA, sumB);
			}
			return ;
		}
		
		for (int i=start+1; i<N; i++) {
			if (visited[i]) {
				continue;
			}
			visited[i] = true;
			int tmp = 0;
			int tmp2 = 0;
			
			for (int j=0; j<N; j++) {
				if (visited[j]) {
					tmp += arr.get(i).get(j) + arr.get(j).get(i);
				} else {
					tmp2 += arr.get(i).get(j) + arr.get(j).get(i);
				}
			}
			
			dfs(N, depth+1, i, sumA+tmp, sumB-tmp2);
			visited[i] = false;
		}
		return ;
	}
	
	
	
}