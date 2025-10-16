import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int Y = 0;
        int M = 0;
        for (int i = 0; i < N; i++) {
            int t = Integer.parseInt(st.nextToken());
            Y += (t / 30 + 1) * 10;
            M += (t / 60 + 1) * 15;
        }

        if (Y < M) {
            System.out.println("Y " + Y);
        } else if (Y > M){
            System.out.println("M " + M);
        } else {
            System.out.println("Y M " + M);
        }
    }
}