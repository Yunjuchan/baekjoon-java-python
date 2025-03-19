import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr;
        for (int t = 0; t < T; t++) {
            boolean isTrue = true;
            arr = new int[26];
            String word = br.readLine();
            for (int i = 0; i < N; i++) {
                int idx = word.charAt(i) - 'a';
                arr[idx]++;
            }

            for (int i = 1; i < N; i++) {
                int p = word.charAt(i - 1) - 'a';
                int n = word.charAt(i) - 'a';
                boolean prev = arr[p] == 1;
                boolean now = arr[n] == 1;
                if (prev == now) {
                    isTrue = false;
                    break;
                }
            }
            if (isTrue) {
                sb.append("T").append("\n");
            } else {
                sb.append("F").append("\n");
            }
        }
        System.out.println(sb);
    }
}