import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());

        int[] cnt = new int[2];

        String line = new StringTokenizer(br.readLine()).nextToken();

        int idx = 0;
        int idx2 = 1;
        while (idx < line.length()) {
            char now = line.charAt(idx);
            if (now == 'M' && Math.abs(cnt[0]+1 - cnt[1]) <= X) {
                cnt[0]++;
                idx = idx2;
                idx2++;
            } else if (now == 'W' && Math.abs(cnt[1]+1 - cnt[0]) <= X) {
                cnt[1]++;
                idx = idx2;
                idx2++;
            } else if (idx2 < line.length()) {
                char next = line.charAt(idx2);
                if (next == 'M' && Math.abs(cnt[0] + 1 - cnt[1]) <= X) {
                    cnt[0]++;
                    idx2++;
                } else if (next == 'W' && Math.abs(cnt[1] + 1 - cnt[0]) <= X) {
                    cnt[1]++;
                    idx2++;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        System.out.println((cnt[0]+cnt[1]));
    }
}