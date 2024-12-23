import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int lastSort = -1;
        int[][] query = new int[Q][2];
        for (int i=0; i<Q; i++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            query[i][0] = q;
            if (q == 0) {
                query[i][1] = Integer.parseInt(st.nextToken());
            } else if (q == 1) {
                lastSort = i;
            }
        }
        boolean[] visited = new boolean[N+1];
        for (int i=0; i<lastSort; i++) {
            if (query[i][0] == 0) {
                visited[query[i][1]] = true;
            }
        }

        Deque<Integer> que = new ArrayDeque<>();
        for (int i=0; i<=N; i++) {
            if (visited[i]) {
                que.offerLast(i);
            }
        }
        boolean isForward = true;

        for (int i=lastSort+1; i<Q; i++) {
            if (query[i][0] == 2) {
                isForward ^= true;
            } else {
                if (isForward) {
                    que.offerFirst(query[i][1]);
                } else {
                    que.offerLast(query[i][1]);
                }
            }
        }
        int result = -1;
        for (int i=1; i<=K; i++) {
            if (isForward) {
                result = que.pollFirst();
            } else {
                result = que.pollLast();
            }
        }

        System.out.println(result);
    }
}