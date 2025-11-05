import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;
        String MBTI = br.readLine();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String other = br.readLine();
            if (MBTI.equals(other)) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
