import java.io.*;
import java.util.*;

public class Main {

    static int N, T, K, result;
    public static void dfs(int level, int W, boolean putWood, int alive, int[] status) {
        int[] nextStatus = status.clone();

        for (int i = 1; i <= N; i++) {
            if (i == W && putWood) {
                continue;
            }

            if (status[i - 1] > 0 && status[i + 1] > 0) {
                nextStatus[i] -= 1;
            } else if (status[i - 1] <= 0 && status[i + 1] <= 0) {
                nextStatus[i] -= 3;
            } else {
                nextStatus[i] -= 2;
            }

            if (status[i] > 0 && nextStatus[i] <= 0) {
                alive--;
            }
        }

        if (alive < K) {
            return;
        }

        if (level == T) {
            result++;
            return;
        }

        if (W > 1) {
            dfs(level + 1, W - 1, true, alive, nextStatus);
        }
        dfs(level + 1, W, true, alive, nextStatus);
        if (W < N) {
            dfs(level + 1, W + 1, true, alive, nextStatus);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken()) + 1;
        T = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int alive = 0;
        result = 0;

        int[] fire = new int[N + 2];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            fire[i] = Integer.parseInt(st.nextToken());
            if (fire[i] != 0) {
                alive++;
            }
        }

        dfs(1, W, false, alive, fire);

        System.out.println(result);
    }
}