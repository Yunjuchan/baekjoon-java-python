import java.io.*;
import java.util.*;

public class Main {
    static int[] table = new int[] {3, 2, 1, 2, 4, 3, 1, 3, 1, 1, 3, 1, 3, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Math.max(N, M);
        int answer = 0;

        int[] cur = new int[N + M];

        st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();
        int idx = 0;
        for (int i = 0; i < L; i++) {
            if (i < N) {
                int c = A.charAt(i) - 'A';
                cur[idx++] = table[c];
            }

            if (i < M) {
                int c = B.charAt(i) - 'A';
                cur[idx++] = table[c];
            }
        }

        for (int i = 0; i < N + M - 2; i++) {
            int[] next = new int[N + M];
            for (int j = 0; j < N + M - i - 1; j++) {
                next[j] = (cur[j] + cur[j + 1]) % 10;
            }
            cur = next.clone();
        }

        for (int i = 0; i < 2; i++) {
            answer *= 10;
            answer += cur[i];
        }

        System.out.println(answer + "%");
    }
}