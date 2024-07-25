import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int score = 0;
        for (int i=0; i<5; i++) {
            st = new StringTokenizer(br.readLine());
            score += Integer.parseInt(st.nextToken());
        }
        System.out.println(score);
    }
}