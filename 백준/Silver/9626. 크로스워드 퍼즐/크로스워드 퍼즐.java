import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int U = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        char[][] puzzle = new char[N + U + D][M + L + R];
        for (int i = 0; i < N + U + D; i++) {
            for (int j = 0; j < M + L + R; j++) {
                if ((i + j) % 2 == 0) {
                    puzzle[i][j] = '#';
                } else {
                    puzzle[i][j] = '.';
                }
            }
        }

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            for (int j = 0; j < M; j++) {
                puzzle[i + U][j + L] = word.charAt(j);
            }
        }

        for (int i = 0; i < N + U + D; i++) {
            for (int j = 0; j < M + L + R; j++) {
                sb.append(puzzle[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
