import java.io.*;
import java.util.*;

public class Main {

    static int N, K, result;
    static Set<Character> set;
    static String[] words;

    public static void dfs(int level, int idx) {
        if (idx > 26) {
            return;
        }
        if (level == K) {
            int cnt = 0;
            for (String word : words) {
                boolean flag = true;
                for (char c : word.toCharArray()) {
                    if (!set.contains(c)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    cnt++;
                }
            }
            result = Math.max(result, cnt);
            return;
        }

        if (idx != 'a' - 'a' && idx != 'c' - 'a' && idx != 'i' - 'a' && idx != 'n' - 'a' && idx != 't' - 'a') {
            set.add((char) ('a' + idx));
            dfs(level + 1, idx + 1);
            set.remove((char) ('a' + idx));
        }
        dfs(level, idx + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        result = 0;
        if (K < 5) {
            System.out.println(0);
            return;
        }

        words = new String[N];
        set = new HashSet<>();
        for (char c : "antatica".toCharArray()) {
            set.add(c);
        }

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            int length = word.length();
            word = word.substring(4, length - 4);
            words[i] = word;
        }

        dfs(5, 0);

        System.out.println(result);
    }
}
