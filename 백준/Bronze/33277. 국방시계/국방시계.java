import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double N = Integer.parseInt(st.nextToken());
        double M = Integer.parseInt(st.nextToken());

        int time = (int) (M / N * 1440);

        int hour = time / 60;
        int minute = time % 60;

        System.out.printf("%02d:%02d", hour, minute);
    }
}