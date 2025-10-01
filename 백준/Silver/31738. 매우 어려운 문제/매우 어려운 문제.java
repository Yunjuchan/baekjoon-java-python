import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        long answer = 1;
        if (N >= M) {
            System.out.println(0);
        } else {
            for (int i = 2; i <= N; i++) {
                answer *= i;
                answer %= M;
            }

            System.out.println(answer);
        }
    }
}