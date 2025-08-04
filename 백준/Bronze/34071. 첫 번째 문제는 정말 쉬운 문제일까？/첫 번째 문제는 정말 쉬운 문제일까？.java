import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int ezCnt = 0;
        int hdCnt = 0;

        int first = Integer.parseInt(br.readLine());

        for (int i = 1; i < N; i++) {
            int level = Integer.parseInt(br.readLine());
            if (first > level) {
                hdCnt++;
            } else if (first < level) {
                ezCnt++;
            }
        }

        if (hdCnt == 0) {
            System.out.println("ez");
        } else if (ezCnt == 0) {
            System.out.println("hard");
        } else {
            System.out.println("?");
        }

    }
}