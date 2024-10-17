import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr;
    static int[] row, col;

    static void changeRow(int N, int target) {
        for (int i=0; i<N; i++) {
            if (row[i] * 2 / N == target) {
                row[i] = target * N;
                for (int j=0; j<N; j++) {
                    if (arr[i][j] != target) {
                        col[j] += target * 2 - 1;
                        arr[i][j] = target;
                    }
                }
            }
        }
    }

    static void changeCol(int N, int target) {
        for (int i=0; i<N; i++) {
            if (col[i] * 2 / N == target) {
                col[i] = target * N;
                for (int j=0; j<N; j++) {
                    if (arr[j][i] != target) {
                        row[j] += target * 2 - 1;
                        arr[j][i] = target;
                    }
                }
            }

        }
    }

    static int count(int N) {
        int cnt = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (arr[i][j] == 1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        row = new int[N];
        col = new int[N];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                int x = Integer.parseInt(st.nextToken());
                arr[i][j] = x;
                if (x == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }

        for (int i=0; i<N; i++) {
            changeCol(N, target);
            changeRow(N, target);
        }

        if (target == 1) {
            if (count(N) == N*N) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        } else {
            if (count(N) == 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}