import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long cnt = 0;
        long x = 1;
        long ten = 10;
        while (true) {
            if (N >= ten) {
                cnt += (ten - ten / 10) * x;
            } else {
                cnt += (N - ten / 10 + 1) * x;
                break;
            }
            ten *= 10;
            x++;
        }

        System.out.println(cnt);
    }
}