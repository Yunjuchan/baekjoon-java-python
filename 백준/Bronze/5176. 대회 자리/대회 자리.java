import java.io.*;
import java.util.*;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int answer = 0;

            boolean[] used = new boolean[M + 1];

            for (int i = 0; i < P; i++) {
                int seat = Integer.parseInt(br.readLine());
                if (used[seat]) {
                    answer++;
                } else {
                    used[seat] = true;
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}