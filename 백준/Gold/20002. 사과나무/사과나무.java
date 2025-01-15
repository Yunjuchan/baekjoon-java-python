import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N+1][N+1];
        int[][] sum = new int[N+1][N+1];

        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                sum[i][j] = arr[i][j] + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
            }
        }

        int result = Integer.MIN_VALUE;

        for (int k=1; k<=N; k++) { // 정사각형 크기
            for (int i=k; i<=N; i++) { // y 좌표
                for (int j=k; j<=N; j++) { // x 좌표
                    int total = sum[i][j] - sum[i-k][j] - sum[i][j-k] + sum[i-k][j-k];
                    result = Math.max(result, total);
                }
            }
        }

        System.out.println(result);
    }
}