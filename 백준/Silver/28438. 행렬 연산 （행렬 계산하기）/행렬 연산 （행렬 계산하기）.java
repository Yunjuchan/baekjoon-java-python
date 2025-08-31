import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] rows = new int[N];
        int[] cols = new int[M];

        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken());

            if (query == 1) {
                rows[target] += v;
            } else {
                cols[target] += v;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(rows[i] + cols[j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}