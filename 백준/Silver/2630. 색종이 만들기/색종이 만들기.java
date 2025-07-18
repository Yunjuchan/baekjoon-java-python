import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int blue, white;
    static int[][] arr;

    public static void dfs(int y, int x, int N) {
        if (N == 1) {
            if (arr[y][x] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        boolean isCut = false;
        for (int i = y; i < y + N; i++) {
            if (isCut) {
                break;
            }

            for (int j = x; j < x + N; j++) {
                if (arr[i][j] != arr[y][x]) {
                    isCut = true;
                    break;
                }
            }
        }

        if (!isCut) {
            if (arr[y][x] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        for (int i = 0; i < N; i += N / 2) {
            for (int j = 0; j < N; j += N / 2) {
                dfs(y + i, x + j, N / 2);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        blue = 0;
        white = 0;

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }
}