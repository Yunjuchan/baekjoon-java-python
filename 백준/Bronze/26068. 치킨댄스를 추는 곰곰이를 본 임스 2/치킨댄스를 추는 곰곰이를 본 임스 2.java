import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = 0;

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int day = Integer.parseInt(br.readLine().split("-")[1]);
            if (day <= 90) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}