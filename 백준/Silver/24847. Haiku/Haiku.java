import java.io.*;
import java.util.*;

public class Main {
    private static Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int result = 0;
        int[] phonetic = new int[N];

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            boolean flag = false;
            int cnt = 0;

            for (char c : word.toCharArray()) {
                if (vowels.contains(c)) {
                    flag = true;
                } else {
                    if (flag) {
                        cnt++;
                        flag = false;
                    }
                }
            }

            if (flag) {
                cnt++;
            }

            phonetic[i] = cnt;
        }

        int start = 0;
        int end = 0;
        int cnt = 0;

        while (end < N) {
            if (cnt > 17) {
                cnt -= phonetic[start];
                start++;
            } else if (cnt < 17) {
                cnt += phonetic[end];
                end++;
            } else {
                int f = 0;
                int s = 0;
                int idx = start;
                for (int i = idx; f < 5 && i < end; i++) {
                    f += phonetic[i];
                    idx++;
                }

                if (f != 5) {
                    cnt -= phonetic[start];
                    start++;
                    continue;
                }

                for (int i = idx; s < 7 && i < end; i++) {
                    s += phonetic[i];
                    idx++;
                }

                if (s != 7) {
                    cnt -= phonetic[start];
                    start++;
                    continue;
                }

                result++;
                cnt -= phonetic[start];
                start++;
            }
        }
        
        while (cnt > 17) {
            cnt -= phonetic[start];
            start++;
        }
        
        if (cnt == 17) {
            int f = 0;
            int s = 0;
            int idx = start;
            for (int i = idx; f < 5 && i < end; i++) {
                f += phonetic[i];
                idx++;
            }

            if (f == 5) {
                for (int i = idx; s < 7 && i < end; i++) {
                    s += phonetic[i];
                    idx++;
                }
                if (s == 7) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}