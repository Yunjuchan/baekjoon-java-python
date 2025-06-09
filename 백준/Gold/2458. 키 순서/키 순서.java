import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = -1;
            arr[b][a] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                if (k == i) {
                    continue;
                }
                for (int j = 1; j <= N; j++) {
                    if (k == j || i == j) {
                        continue;
                    }
                    if (arr[i][k] == arr[k][j] && arr[i][k] != 0) {
                        arr[i][j] = arr[i][k];
                    }
                }
            }
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            boolean isPossible = true;
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    continue;
                }
                if (arr[i][j] == 0) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}