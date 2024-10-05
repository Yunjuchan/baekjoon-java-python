import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int size = 4 * N - 3;
        char[][] pattern = new char[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                pattern[i][j] = ' ';
            }
        }

        drawPattern(pattern, N, 0, size);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(pattern[i][j]);
            }
            sb.append('\n');
        }

        System.out.print(sb.toString());
    }

    static void drawPattern(char[][] pattern, int n, int offset, int size) {
        if (n == 0) return;

        for (int i = offset; i < size; i++) {
            pattern[offset][i] = '*';
            pattern[size - 1][i] = '*';
            pattern[i][offset] = '*';
            pattern[i][size - 1] = '*';
        }

        drawPattern(pattern, n - 1, offset + 2, size - 2);
    }
}