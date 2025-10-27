import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
//        int[] answer = new int[101];
//        boolean[] locked = new boolean[101];
//        for (int i = 1; i <= 100; i++) {
//            for (int j = i; j <= 100; j += i) {
//                locked[j] = !locked[j];
//            }
//            for (int j = 1; j <= i; j++) {
//                if (locked[j]) {
//                    answer[i]++;
//                }
//            }
//        }

        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
//            sb.append(answer[N]).append("\n");
            sb.append((int) Math.sqrt(N)).append("\n");
        }

        System.out.println(sb);
    }
}
