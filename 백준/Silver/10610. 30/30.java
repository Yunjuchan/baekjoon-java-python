import java.io.*;
import java.util.*;

public class Main {

    public static void print(int[] cnt) {
        StringBuilder sb = new StringBuilder();
        int x = 9;
        int total = 0;
        while (x >= 0) {
            if (cnt[x] == 0) {
                x--;
            } else {
                cnt[x]--;
                total += x;
                sb.append(x);
            }
        }

        if (total != 0) {
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String s = br.readLine();
        int N = s.length();
        int[] cnt = new int[10];
        int[] resCnt = new int[3];
        int total = 0;
        for (int i = 0; i < N; i++) {
            int idx = s.charAt(i) - '0';
            total += idx;
            cnt[idx]++;
            resCnt[idx % 3]++;
        }

        if (cnt[0] == 0) {
            System.out.println(-1);
            return;
        }

        if (total % 3 == 0) {
            print(cnt);
        } else if (total % 3 == 1) {
            System.out.println(-1);
        } else {
            System.out.println(-1);
        }
    }
}
