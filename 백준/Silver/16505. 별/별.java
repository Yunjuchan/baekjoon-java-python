import java.io.*;
import java.util.*;

public class Main {

    public static char[][] star(int N) {
        if (N == 0) {
            char[][] init = new char[1][1];

            init[0][0] = '*';
            return init;
        }

        int size = (int) Math.pow(2, N);
        int half = size / 2;
        char[][] cur = new char[size][size];
        char[][] prev = star(N - 1);

        for (int i = 0; i < size; i += half) {
            for (int j = 0; j < size; j += half) {
                if (i == half && j == half) {
                    continue;
                }
                for (int y = 0; y < half; y++) {
                    for (int x = 0; x < half; x++) {
                        cur[y + i][x + j] = prev[y][x];
                    }
                }
            }
        }

        return cur;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int size = (int) Math.pow(2, N);

        char[][] init = new char[1][1];

        init[0][0] = '*';

        char[][] answer = star(N);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i; j++) {
                if (answer[i][j] != '\0') {
                    sb.append(answer[i][j]);
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}