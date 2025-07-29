import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String N = br.readLine();
            int num = Integer.parseInt(N);
            int width = N.length() + 1;
            if (num == 0) {
                System.out.println(sb);
                return;
            }

            while (num != 0) {
                int res = num % 10;
                num /= 10;
                if (res == 0) {
                    width += 4;
                } else if (res == 1) {
                    width += 2;
                } else {
                    width += 3;
                }
            }

            sb.append(width).append("\n");
        }
    }
}