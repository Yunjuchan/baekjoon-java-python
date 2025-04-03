import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int i = 0; i < 3; i++) {
            int x = Integer.parseInt(st.nextToken());
            min = Math.min(min, x);
            sum += x;
        }
        System.out.println(sum - min);


    }
}
