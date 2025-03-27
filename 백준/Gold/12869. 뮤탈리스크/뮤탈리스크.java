import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;

    static int[][] atk;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        boolean[][][] visited = new boolean[61][61][61];
        arr = new int[3];
        atk = new int[][] {{1,3,9}, {1,9,3}, {3,1,9}, {3,9,1}, {9,1,3}, {9,3,1}};

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Queue<int[]> que = new LinkedList<>();

        que.offer(new int[]{0, arr[0], arr[1], arr[2]});
        visited[arr[0]][arr[1]][arr[2]] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            if (cur[1] <= 0 && cur[2] <= 0 && cur[3] <= 0) {
                System.out.println(cur[0]);
                return;
            }
            for (int i = 0; i < 6; i++) {
                int[] clone = cur.clone();
                clone[0]++;
                boolean flag = false;
                for (int j = 0; j < 3; j++) {
                    if (clone[j + 1] == 0 && atk[i][j] == 9) {
                        flag = true;
                        break;
                    }
                    clone[j + 1] = Math.max(clone[j + 1] - atk[i][j], 0);
                }
                if (flag) {
                    continue;
                }
                if (visited[clone[1]][clone[2]][clone[3]]) {
                    continue;
                }
                visited[clone[1]][clone[2]][clone[3]] = true;
                que.offer(clone);
            }
        }
    }
}
