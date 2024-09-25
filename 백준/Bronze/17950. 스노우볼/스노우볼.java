import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        long mul = x;
        long result = 0;
        int mod = 1000000007;
        for (int i=0; i<H; i++) {
            st = new StringTokenizer(br.readLine());
            long c = Integer.parseInt(st.nextToken());
            result += (c * mul) % mod;
            result %= mod;
            mul *= x;
            mul %= mod;
        }
        System.out.println(result);
    }
}