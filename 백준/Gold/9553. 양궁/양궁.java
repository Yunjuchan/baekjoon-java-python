import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][4];
            double sum = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 4; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }

                double rad1 = Math.atan2(arr[i][1], arr[i][0]);
                double rad2 = Math.atan2(arr[i][3], arr[i][2]);
                double tmp = Math.abs(rad1 - rad2);
                tmp = Math.min(tmp, 2 * Math.PI - tmp);
                sum += tmp;
            }
            sb.append(String.format("%.5f", sum / (2 * Math.PI))).append("\n");
        }

        System.out.println(sb);
    }
}