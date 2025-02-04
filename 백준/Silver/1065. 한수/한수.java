import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = Math.min(N, 99);
        for (int i = 100; i <= N; i++) {
            String num = String.valueOf(i);
            if (num.charAt(1) - num.charAt(0) == num.charAt(2) - num.charAt(1)) {
                cnt++;
            } else if (i == 1000) {
                break;
            }
        }
        System.out.println(cnt);
    }
}