import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        if ((k - a) % d != 0) {
            System.out.println("X");
            return;
        } else if (d > 0 && k < a) {
            System.out.println("X");
            return;
        } else if (d < 0 && k > a) {
            System.out.println("X");
            return;
        }

        int answer = 1 + (k - a) / d;
        System.out.println(answer);
    }
}