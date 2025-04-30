import java.io.*;
import java.util.*;

public class Main {

    static final int INIT = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            int B = - Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            if (B == 0 && P == 0) {
                System.out.println(sb);
                return;
            }

            int[] cur = new int[B + 1];
            int[][] status = new int[B][2];
            int time = 0;
            cur[0] = P;

            int[][] bridges = new int[B][2];
            for (int i = 0; i < B; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 2; j++) {
                    bridges[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            while (cur[B] != P) {

                for (int i = 0; i < B; i++) {
                    if (status[i][1] != 0) {
                        status[i][1]--;
                        continue;
                    }
                    cur[i + 1] += status[i][0];
                    status[i][0] = 0;
                    int p = Math.min(cur[i], bridges[i][0]);
                    if (p == 0) {
                        continue;
                    }
                    cur[i] -= p;
                    status[i][0] = p;
                    status[i][1] = bridges[i][1] - 1;
                }
                time++;
            }
            sb.append(time - 1).append("\n");
        }
    }
}
