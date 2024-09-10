import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long result = 1;
        for (int i=2; i<=N; i++) {
            result *= 2*i-1;
            result %= 1000000009;
        }
        System.out.println(result);

    }
}