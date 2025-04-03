import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 1; i <= 500; i++) {
            for (int j = i; j <= 500; j++) {
                if (j * j - i * i == N) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
