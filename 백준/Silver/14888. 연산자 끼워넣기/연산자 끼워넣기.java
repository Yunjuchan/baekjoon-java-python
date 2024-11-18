import java.io.*;
import java.util.*;

public class Main {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    static int[] operators;

    public static long calc(int k, long a, long b) {
        if (k == 0) {
            return a + b;
        } else if (k == 1) {
            return a - b;
        } else if (k == 2) {
            return a * b;
        } else {
            if (a < 0) {
                return -((-a) / b);
            } else {
                return a / b;
            }
        }
    }

    public static void dfs(int level, long temp, int N, int[] numbers) {
        if (level == N - 1) {
            max = Math.max(max, (int) temp);
            min = Math.min(min, (int) temp);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;
                dfs(level + 1, calc(i, temp, numbers[level + 1]), N, numbers);
                operators[i]++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] numbers = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        operators = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, numbers[0], N, numbers);
        System.out.println(max);
        System.out.println(min);

    }
}