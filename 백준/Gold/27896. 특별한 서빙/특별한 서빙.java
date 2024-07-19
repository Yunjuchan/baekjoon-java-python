import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        long[] DP = new long [N];
        PriorityQueue<int[]> que = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                int result = Integer.compare(b[1], a[1]);
                if (result == 0) {
                    return Integer.compare(a[0], b[0]);
                }
                return result;
            }
        });

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            int x = Integer.parseInt(st.nextToken());
            A[i] = x;
            if (i != 0) {
                DP[i] = DP[i-1] + A[i];
            } else {
                DP[i] = A[i];
            }
        }

        long minus = 0;
        int cnt = 0;

        for (int i=0; i<N; i++) {
            que.add(new int[]{i, A[i]});
//            System.out.println("i: " + i + " DP[i] - minus: " + (DP[i] - minus));
            if(DP[i] - minus >= M) {
                List<int[]> B = new ArrayList<>();
                while (!que.isEmpty()) {
                    int[] tmp = que.poll();
                    minus += 2 * tmp[1];
                    cnt += 1;
                    if (DP[i] - minus < M) {
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}