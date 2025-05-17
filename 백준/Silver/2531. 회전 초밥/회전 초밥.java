import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int result = 0;
        int[] cnt = new int[d + 1];
        Set<Integer> set = new HashSet<>();
        int[] sushi = new int[N];
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < k; i++) {
            cnt[sushi[i]]++;
            set.add(sushi[i]);
        }

        result = set.size();
        if (!set.contains(c)) {
            result++;
        }

        for (int i = 0; i < N; i++) {
            int l = i;

            if (--cnt[sushi[l]] == 0) {
                set.remove(sushi[l]);
            }

            int r = (i + k) % N;
            cnt[sushi[r]]++;
            set.add(sushi[r]);

            int count = set.size() + (set.contains(c) ? 0 : 1);
            result = Math.max(result, count);
        }

        System.out.println(result);
    }
}