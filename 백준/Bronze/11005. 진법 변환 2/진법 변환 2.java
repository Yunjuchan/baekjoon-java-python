import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String number = "";
        char[] bit = new char[36];
        for (int i = 0; i < 10; i++) {
            bit[i] = (char) (48 + i);
        }

        for (int i = 10; i < 36; i++) {
            bit[i] = (char) (55 + i);
        }

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        while (N != 0) {
            number = bit[N % B] + number;
            N /= B;
        }

        System.out.println(number);
    }
}
