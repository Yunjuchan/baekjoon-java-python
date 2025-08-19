import java.io.*;
import java.util.*;

public class Main {

    static int N, K, answer;
    static boolean[] used;
    static int[] workout;
    static void dfs(int level, int power) {
        if (power < 500) {
            return;
        }

        if (level == N) {
            answer++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            dfs(level + 1, power + workout[i] - K);
            used[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        workout = new int[N];
        used = new boolean[N];
        answer = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            workout[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 500);
        
        System.out.println(answer);
    }
}