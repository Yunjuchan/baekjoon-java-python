import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int cnt = 0;
            int[] arr = new int[10];
            while (N != 6174) {
                for (int i = 0; i < 4; i++) {
                    arr[N % 10]++;
                    N /= 10;
                }
                int min = 0;
                int max = 0;
                int x = 0;
                for (int i = 0; i < 10; i++) {
                    while (arr[i] != 0) {
                        min += i * (int) (Math.pow(10, 3 - x));
                        max += i * (int) (Math.pow(10, x));
                        arr[i]--;
                        x++;
                    }
                }

                N = max - min;
                cnt++;
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}