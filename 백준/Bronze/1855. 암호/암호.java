import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int L = str.length();
        int N = L / K;
        char[][] arr = new char[N][K];

        int idx = 0;
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < K; j++) {
                    arr[i][j] = str.charAt(idx++);
                }
            } else {
                for (int j = K - 1; j >= 0; j--) {
                    arr[i][j] = str.charAt(idx++);
                }
            }
        }

        for (int j = 0; j < K; j++) {
            for (int i = 0; i < N; i++) {
                sb.append(arr[i][j]);
            }
        }

        System.out.println(sb);
    }
}