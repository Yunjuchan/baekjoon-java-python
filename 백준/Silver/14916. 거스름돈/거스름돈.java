import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        if (N == 1 || N == 3) {
            System.out.println(-1);
            return;
        }
        int cnt = N / 5;
        int res = N % 5;
        if (res % 2 == 1) {
            cnt--;
            cnt += (res + 5) / 2;
        } else {
            cnt += res / 2;
        }
        System.out.println(cnt);
    }
}