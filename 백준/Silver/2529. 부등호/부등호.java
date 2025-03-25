import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static String min, max;
    static boolean[] used;
    static String[] signs;

    public static void dfs(int level, String now) {
        if (level == N) {
            if (min.compareTo(now) > 0) {
                min = now;
            }

            if (max.compareTo(now) < 0) {
                max = now;
            }
            return;
        }
        int norm = now.charAt(level) - '0';

        if (signs[level].equals(">")) {
            for (int i = 0; i < norm; i++) {
                if (used[i]) {
                    continue;
                }
                used[i] = true;
                dfs(level + 1, now + i);
                used[i] = false;
            }
        }

        if (signs[level].equals("<")) {
            for (int i = norm + 1; i < 10; i++) {
                if (used[i]) {
                    continue;
                }
                used[i] = true;
                dfs(level + 1, now + i);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        used = new boolean[10];

        N = Integer.parseInt(br.readLine());
        min = "9".repeat(N + 1);
        max = "0".repeat(N + 1);

        signs = br.readLine().split(" ");

        for (int i = 0; i < 10; i++) {
            used[i] = true;
            dfs(0, i+"");
            used[i] = false;
        }

        System.out.println(max);
        System.out.println(min);

    }
}
