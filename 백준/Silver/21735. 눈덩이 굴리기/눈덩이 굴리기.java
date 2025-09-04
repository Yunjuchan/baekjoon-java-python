import java.io.*;
import java.util.*;

public class Main {
    static int N, M, answer;
    static int[] A;

    public static void dfs(int level, int cur, int snow) {
        if (level == M || cur == N ) {
            answer = Math.max(answer, snow);
            return;
        }
        dfs(level + 1, cur + 1, snow + A[cur + 1]);

        if (cur + 2 <= N) {
            dfs(level + 1, cur + 2, snow / 2 + A[cur + 2]);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = 0;

        A = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 1);

        System.out.println(answer);
    }
}