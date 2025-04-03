import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            String line = br.readLine();
            if (line.equals("END")) {
                break;
            }
            for (int i = line.length() - 1; i >= 0; i--) {
                sb.append(line.charAt(i));
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
