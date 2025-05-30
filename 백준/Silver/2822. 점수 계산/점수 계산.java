import java.io.*;
import java.util.*;

public class Main {

    static int total = 0;
    static int[] problems;
    static int[] solved;

    public static void dfs(int level, int cur, int sum, int[] path) {

        if (level == 5) {
            if (total < sum) {
                total = sum;
                solved = path.clone();
            }
            return;
        }

        if (cur == 9) {
            return;
        }

        dfs(level, cur + 1, sum, path);
        path[level] = cur;
        dfs(level + 1, cur + 1, sum + problems[cur], path);
        path[level] = 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        problems = new int[9];
        solved = new int[5];
        for (int i = 1; i < 9; i++) {
            problems[i] = Integer.parseInt(br.readLine());
        }

        dfs(0, 1, 0, new int[5]);

        System.out.println(total);
        for (int p : solved) {
            System.out.print(p + " ");
        }
    }
}