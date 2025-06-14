import java.io.*;

public class boj2231 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int generator = 1;
        while (generator < N) {
            int now = generator;
            int sum = generator;
            while (now != 0) {
                sum += now % 10;
                now /= 10;
            }
            if (sum == N) {
                System.out.println(generator);
                return;
            }
            generator++;
        }
        System.out.println(0);
    }
}