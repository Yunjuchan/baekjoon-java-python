import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int rm = 0;
            for (int j = 0; j < 3; j++) {
                rm += Integer.parseInt(st.nextToken());
            }
            if (rm >= 512) {
                answer = Math.min(answer, rm);
            }
        }

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }
}