import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int s = 0;
        int e = 0;
        double lb = (double) N * 3 / 20;
        if (lb % 1 >= 0.5) {
            s = (int) lb + 1;
            e = N - s;
        } else {
            s = (int) lb;
            e = N - s;
        }
        int[] opinion = new int[N];
        for (int i = 0; i < N; i++) {
            opinion[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(opinion);
        double level = 0;
        for (int i = s; i < e; i++) {
            level += opinion[i];
        }

        level /= e - s;

        if (level % 1 >= 0.5) {
            System.out.println((int) level + 1);
        } else {
            System.out.println((int) level);
        }
    }
}