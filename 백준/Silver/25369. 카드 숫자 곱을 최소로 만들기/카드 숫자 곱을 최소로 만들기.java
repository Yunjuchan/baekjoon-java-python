import java.io.*;
import java.util.*;

public class Main {

    static boolean found = false;
    static int N, A;
    static int[] B;

    public static void backtrack(int level, int[] path, int mul) {
        if (found) {
            return;
        }

        if (level == N) {
            if (mul > A) {
                B = path.clone();
                found = true;
            }
            return;
        }

        for (int i = 1; i < 10; i++) {
            path[level] = i;
            backtrack(level + 1, path, mul * i);
            path[level] = 0;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        A = 1;
        B = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A *= Integer.parseInt(st.nextToken());
        }

        backtrack(0, new int[N], 1);

        if (!found) {
            System.out.println(-1);
            return;
        }

        for (int x : B) {
            System.out.print(x + " ");
        }
    }
}
