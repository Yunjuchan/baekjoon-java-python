import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long prev = 0;
        long now = 1;
        for (int i = 1; i < N; i++) {
            long tmp = now;
            now += prev;
            prev = tmp;
        }
        System.out.println(now);
    }
}
