import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int S = Integer.parseInt(br.readLine());
        int[] arr = new int[2 * S];
        arr[1] = 0;
        Arrays.fill(arr, Integer.MAX_VALUE);
        PriorityQueue<int[]> que = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        que.offer(new int[] {1, 0});

        while (!que.isEmpty()) {
            int[] now = que.poll();

            int c = now[0];
            int t = now[1];
            if (c == 0 || arr[c] < t) {
                continue;
            }

            if (c == S) {
                System.out.println(t);
                return;
            }

            t++;

            if (arr[c - 1] > t) {
                arr[c - 1] = t;
                que.offer(new int[] {c - 1, t});
            }

            while (c < S) {
                t++;
                c += now[0];
                if (arr[c] > t) {
                    arr[c] = t;
                    que.offer(new int[] {c, t});
                }
            }
        }
    }
}
