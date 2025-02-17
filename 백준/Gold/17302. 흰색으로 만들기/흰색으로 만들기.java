import java.io.*;
import java.util.*;

public class Main {
    static int[] directY = {1,0,-1,0};
    static int[] directX = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] arr = new char[N][M];
        int[][] answer = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                answer[i][j] = 2;
                arr[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < 4; k++) {
                    int dy = i + directY[k];
                    int dx = j + directX[k];
                    if (dy < 0 || dx < 0 || dy >= N || dx >= M) {
                        continue;
                    }
                    if (arr[dy][dx] == 'W') {
                        arr[dy][dx] = 'B';
                    } else {
                        arr[dy][dx] = 'W';
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 'B') {
                    arr[i][j] = 'W';
                    answer[i][j] = 3;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(1).append("\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(answer[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}