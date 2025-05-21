import java.io.*;
import java.util.*;

public class Main {

    static int result;
    static int N;
    static int[] A, P, DP;

    public static void backtrack(int HP, int damage, int survive, int visited) {
        result = Math.max(result, survive);

        for (int i = 1; i <= N; i++) {
            int bit = (1 << (i - 1));
            if ((visited & bit) > 0) {
                continue;
            }

            int nextDamage = damage + A[i];
            if (HP - nextDamage < 0 || DP[visited | bit] >= HP - nextDamage) {
                continue;
            }

            DP[visited | bit] = HP - nextDamage;
            backtrack(HP - nextDamage, nextDamage, survive + P[i], visited | bit);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        A = new int[N + 1];
        P = new int[N + 1];
        DP = new int[1 << N];
        Arrays.fill(DP, -1);

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        result = 0;
        backtrack(K, 0, 0, 0);
        System.out.println(result);
    }
}
