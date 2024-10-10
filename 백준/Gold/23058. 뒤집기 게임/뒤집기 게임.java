import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int result = Integer.MAX_VALUE;
    static int[][] A;

    static int[][] changeR(int r, int[][] arr) {
        for (int i = 0; i < N; i++) {
            arr[r][i] = (arr[r][i] + 1) % 2;
        }
        return arr;
    }

    static int[][] changeC(int c, int[][] arr) {
        for (int i = 0; i < N; i++) {
            arr[i][c] = (arr[i][c] + 1) % 2;
        }
        return arr;
    }

    static void dfs(int nowR, int nowC, Stack<Integer> R, Stack<Integer> C) {
        if (nowC == N) {
            int[][] now = new int[N][N];
            for (int i=0; i<N; i++) {
                now[i] = A[i].clone();
            }
            int cnt = 0;

            for (int r : R) {
                now = changeR(r, now);
                cnt++;
            }

            for (int c : C) {
                now = changeC(c, now);
                cnt++;
            }

            result = Math.min(result, cnt + changeCount(now));
            return;
        }

        if (nowR == N) {
            C.add(nowC);
            dfs(nowR, nowC+1, R, C);
            C.pop();

            dfs(nowR, nowC+1, R, C);

            return;
        }

        R.push(nowR);
        dfs(nowR+1, nowC, R, C);
        R.pop();

        dfs(nowR+1, nowC, R, C);
    }

    static int changeCount(int[][] arr) {
        int countZero = 0, countOne = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (arr[i][j] == 0) {
                    countZero++;
                } else {
                    countOne++;
                }
            }
        }
        return Math.min(countZero, countOne);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0, new Stack<>(), new Stack<>());
        System.out.println(result);
    }
}