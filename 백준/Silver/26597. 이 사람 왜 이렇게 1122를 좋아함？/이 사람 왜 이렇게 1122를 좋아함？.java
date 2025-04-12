import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        long upper = (long) Math.pow(10, 18);
        long lower = - (long) Math.pow(10, 18);
        int answer = -1;
        int Q = Integer.parseInt(br.readLine());
        for (int q = 1; q <= Q; q++) {
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            char c = st.nextToken().charAt(0);
            if (c == '^') {
                if (upper <= x) {
                    System.out.println("Paradox!");
                    System.out.println(q);
                    return;
                } else {
                    lower = Math.max(lower, x + 1);
                }
            } else {
                if (lower >= x) {
                    System.out.println("Paradox!");
                    System.out.println(q);
                    return;
                } else {
                    upper = Math.min(upper, x - 1);
                }
            }
            if (answer == -1 && lower == upper) {
                answer = q;
            }
        }

        if (answer != -1) {
            System.out.println("I got it!");
            System.out.println(answer);
        } else {
            System.out.println("Hmm...");
        }
    }
}