import java.io.*;
import java.util.*;

public class Main {

    static int N, ans = 0;
    static int[] cows, adj;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        cows = new int[N];
        adj = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cows[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cows);

        int[] left = new int[N];
        int[] right = new int[N];
        left[0] = Integer.MAX_VALUE;
        right[N - 1] = Integer.MAX_VALUE;

        for (int i = 0; i < N - 1; i++) {
            left[i + 1] = cows[i + 1] - cows[i];
            right[i] = cows[i + 1] - cows[i];
        }

        for (int i = 0; i < N; i++) {
            if (left[i] > right[i]) {
                adj[i] = 1;
            } else {
                adj[i] = -1;
            }
        }

        for (int i = 1; i < N; i++) {
            if (adj[i - 1] == 1 && adj[i] == -1) {
                int rCnt = 0;
                int lCnt = 0;
                int r = i - 1;
                int l = i;
                while (r >= 0) {
                    if (adj[r] == -1) {
                        break;
                    }
                    rCnt++;
                    r--;
                }

                while (l < N) {
                    if (adj[l] != -1) {
                        break;
                    }
                    lCnt++;
                    l++;
                }

                if (rCnt > 1 && lCnt > 1) {
                    ans += 2;
                } else {
                    ans += 1;
                }
            }
        }
        System.out.println(ans);
    }
}