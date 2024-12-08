import java.io.*;
import java.util.*;

public class Main {

    static int cnt = 0;
    static boolean flag = false;

    public static void dfs(int N, int level, int[] arr, int K) {
        if (N == 0) {
            cnt++;
            if (cnt == K) {
                flag = true;
                for (int i=0; i<level; i++) {
                    System.out.print(arr[i]);
                    if (i != level-1) {
                        System.out.print("+");
                    }
                }
            }
            return;
        }

        for (int i=1; i<=Math.min(3, N); i++) {
            arr[level] = i;
            dfs(N-i, level+1, arr, K);
            arr[level] = 0;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dfs(N, 0, new int[11], K);
        if (!flag) {
            System.out.println(-1);
        }
    }
}