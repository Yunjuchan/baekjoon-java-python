import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int answer = 0;

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] arr = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int y = 0; y <= N - R; y++) {
            for (int x = 0; x <= M - C; x++) {
                boolean possible = true;

                for (int i = 0; i < R; i++) {
                    if (!possible) {
                        continue;
                    }
                    for (int j = 0; j < C; j++) {
                        int norm = map[y][x] - arr[0][0];
                        if (map[y + i][x + j] - arr[i][j] !=  norm) {
                            possible = false;
                            break;
                        }
                    }
                }

                if (possible) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}