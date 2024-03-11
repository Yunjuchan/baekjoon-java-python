import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Main {
	
	private static Deque<Integer> queue; 
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		queue = new ArrayDeque<Integer>();
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String query = st.nextToken();
			if (query.equals("push")) {
				int number = Integer.parseInt(st.nextToken());
				queue.offerFirst(number);
			}
			else if (query.equals("empty")) {
				if (queue.isEmpty()) {
					bw.write(String.valueOf(1));
				}
				else {
					bw.write(String.valueOf(0));
				}
				bw.newLine();
			}
			else if (query.equals("size")) {
				bw.write(String.valueOf(queue.size()));
				bw.newLine();
			}
			else {
				if (queue.isEmpty()) {
					bw.write(String.valueOf(-1));
				}
				else if (query.equals("front")){
					bw.write(String.valueOf(queue.peekLast()));
				}
				else if (query.equals("back")){
					bw.write(String.valueOf(queue.peekFirst()));
				}
				else if (query.equals("pop")){
					bw.write(String.valueOf(queue.pollLast()));
				}
				bw.newLine();
			}
		}	
		bw.close();
	}
}