import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String word = br.readLine();
        int len = word.length();

        int[] cnt = new int[26];

        int s = 0;
        int e = 0;

        Set<Character> set = new HashSet<>();
        int i = word.charAt(0) - 'a';
        cnt[i] = 1;
        set.add(word.charAt(0));

        int result = 1;

        while (true) {
            if (set.size() <= N) {
                if (e == len - 1) {
                    result = Math.max(result, e - s + 1);
                    break;
                } else {
                    e++;
                    i = word.charAt(e) - 'a';
                    cnt[i]++;
                    set.add(word.charAt(e));
                }
            } else {
                i = word.charAt(s) - 'a';
                cnt[i]--;
                if (cnt[i] == 0) {
                    set.remove(word.charAt(s));
                }
                s++;
            }
            if (set.size() <= N) {
                result = Math.max(result, e - s + 1);
            }
        }
        System.out.println(result);
    }
}