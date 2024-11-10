import java.io.*;

import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            int score = 0;
            int now = 0;
            String line = st.nextToken();
            for (char c : line.toCharArray()) {
                if (c == 'O') {
                    now++;
                    score += now;
                } else {
                    now = 0;
                }
            }
            System.out.println(score);
        }
    }
}