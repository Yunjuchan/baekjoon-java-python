import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int time = 0;
            int[] cur = new int[h];
            int[][] order = new int[2501][2];
            Arrays.fill(order, new int[] {-1, -1});

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < l; j++) {
                    int x = Integer.parseInt(st.nextToken());
                    if (x == -1) {
                        continue;
                    }
                    order[x] = new int[] {i, j};
                }
            }

            for (int i = 1; i <= 2500; i++) {
                if (order[i][0] == -1 && order[i][1] == -1) {
                    break;
                }
                int y = order[i][0];
                int x = Math.abs(cur[y] - order[i][1]);
                x = Math.min(x, l - x);

                time += y * 20 + x * 5;
                cur[y] = order[i][1];
            }
            sb.append(time).append("\n");
        }
        System.out.println(sb);
    }
}