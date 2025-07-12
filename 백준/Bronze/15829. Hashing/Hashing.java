import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final long MOD = 1_234_567_891;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        long answer = 0;
        long mul = 1;
        for (int i = 0; i < N; i++) {
            long c = str.charAt(i) - 'a' + 1;
            long x = c * mul % MOD;
            answer += x;
            answer %= MOD;
            mul *= 31;
            mul %= MOD;
        }

        System.out.println(answer);
    }
}