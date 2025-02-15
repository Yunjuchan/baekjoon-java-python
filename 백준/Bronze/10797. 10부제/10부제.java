import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int day = Integer.parseInt(br.readLine());
        int result = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            int car = Integer.parseInt(st.nextToken());
            if (car == day) {
                result++;
            }
        }

        System.out.println(result);
    }
}