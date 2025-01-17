import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static double result = 0;
    static int[][] arr;
    static void dfs(int start, int level, int[] idx) {
        if (level == 3) {
            int a = arr[idx[0]][0] * arr[idx[1]][1] + arr[idx[1]][0] * arr[idx[2]][1] + arr[idx[2]][0] * arr[idx[0]][1];

            int b = arr[idx[0]][1] * arr[idx[1]][0] + arr[idx[1]][1] * arr[idx[2]][0] + arr[idx[2]][1] * arr[idx[0]][0];
            double extent = Math.abs(1 / 2.0 * (a - b));
            result = Math.max(result, extent);
            return;
        }

        for (int i=start; i<N; i++) {
            idx[level] = i;
            dfs(i+1, level+1, idx);
            idx[level] = 0;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, new int[3]);
        System.out.println(result);
    }
}