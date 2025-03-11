import java.io.*;
import java.util.*;

public class Main {

    static int[] dy = new int[]{1,0};
    static int[] dx = new int[]{0,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        int[] count = new int[2];

        if ((N * M) % 2 == 1) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                count[arr[i][j]]++;
            }
        }

        for (int i = 0; i < 2; i++) {
            if (count[i] % 2 == 1) {
                System.out.println(-1);
                return;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == -1) {
                    continue;
                }
                for (int k = 0; k < 2; k++) {
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    if (ny >= N || nx >= M || arr[i][j] != arr[ny][nx]) {
                        continue;
                    }
                    System.out.println(1);
                    return;
                }
            }
        }

        System.out.println(-1);
    }
}