import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String[] line = br.readLine().split(",");
            int A = Integer.parseInt(line[0]);
            int B = Integer.parseInt(line[1]);
            sb.append(A + B).append("\n");
        }
        System.out.println(sb);
    }
}