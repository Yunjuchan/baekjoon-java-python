import java.io.*;
import java.util.*;

public class Main {

    static int T, N, D, MOD = 1_000_000_007;
    static List<int[][]> matrixList, maps;

    public static List<int[][]> makeMatrixList(int T, int[][] init) {
        List<int[][]> matrixList = new ArrayList<>();
        matrixList.add(new int[N + 1][N + 1]);
        for (int i = 0; i <= N; i++) {
            matrixList.get(0)[i] = init[i].clone();
        }

        for (int t = 0; t < T; t++) {
            int[][] now = new int[N + 1][N + 1];
            int[][] prev = matrixList.get(t);
            int[][] map = maps.get(t + 1);

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    for (int k = 1; k <= N; k++) {
                        now[i][k] += (int) ((long) prev[i][j] * map[j][k] % MOD);
                        now[i][k] %= MOD;
                    }
                }
            }

            matrixList.add(new int[N + 1][N + 1]);
            for (int i = 0; i <= N; i++) {
                matrixList.get(t + 1)[i] = now[i].clone();
            }
        }
        return matrixList;
    }

    public static int[][] multiply(int[][] A, int[][] B) {
        int[][] result = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                long sum = 0;
                for (int k = 1; k <= N; k++) {
                    sum += (long) A[i][k] * B[k][j];
                    sum %= MOD;
                }
                result[i][j] = (int) sum;
            }
        }
        return result;
    }


    public static int[][] pow(int[][] init, int exp) {
        if (exp == 0) {
            int[][] identity = new int[N + 1][N + 1];
            for (int i = 1; i <= N; i++) {
                identity[i][i] = 1;
            }
            return identity;
        }
        if (exp == 1) return init;

        int[][] half = pow(init, exp / 2);
        int[][] full = multiply(half, half);

        if (exp % 2 == 1) {
            full = multiply(full, init);
        }
        return full;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        int[][] route = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            route[i][i] = 1;
        }

        maps = new ArrayList<>();
        maps.add(route);

        for (int t = 1; t <= T; t++) {
            int M = Integer.parseInt(br.readLine());
            int[][] arr = new int[N + 1][N + 1];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                arr[a][b] = c;
            }
            maps.add(arr);
        }

        matrixList = makeMatrixList(T, route);

        int exp = D / T;
        int res = D % T;
        int[][] init = new int[N + 1][N + 1];
        int[][] resultMatrix = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            init[i] = matrixList.get(T)[i].clone();
            resultMatrix[i] = matrixList.get(res)[i].clone();
        }
        resultMatrix = multiply(pow(init, exp), resultMatrix);

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sb.append(resultMatrix[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}