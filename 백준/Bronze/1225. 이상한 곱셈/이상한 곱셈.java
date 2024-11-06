import java.io.*;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();
        long a = 0;
        long b = 0;
        for (int c : A.toCharArray()) {
            a += c - '0';
        }

        for (int c : B.toCharArray()) {
            b += c - '0';
        }

        System.out.println(a*b);

    }
}