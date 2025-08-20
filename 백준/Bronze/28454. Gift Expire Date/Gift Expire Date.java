import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;
        String[] today = br.readLine().split("-");
        int year = Integer.parseInt(today[0]);
        int month = Integer.parseInt(today[1]);
        int day = Integer.parseInt(today[2]);


        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] date = br.readLine().split("-");
            int y = Integer.parseInt(date[0]);
            int m = Integer.parseInt(date[1]);
            int d = Integer.parseInt(date[2]);

            if (y > year) {
                answer++;
            } else if (y == year && m > month) {
                answer++;
            } else if (y == year && m == month && d >= day) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}