import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[] words;
    static final int alphabet = (1 << 26) - 1;
    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        words = new int[n];

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            for (char c : word.toCharArray()) {
                words[i] |= 1 << (c - 'a');
            }
        }

        dfs(0, 0);

        System.out.println(result);
    }

    private static void dfs(int index, int mask) {
        if (mask == alphabet) {
            // 남은 단어들에 대해 가능한 모든 조합을 계산하여 결과에 더함
            result += 1 << (n - index);
            return;
        }

        if (index == n) return;

        dfs(index + 1, mask | words[index]); // 현재 단어를 포함하는 경우
        dfs(index + 1, mask); // 현재 단어를 포함하지 않는 경우
    }
}