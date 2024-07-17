import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int e = Integer.parseInt(st.nextToken());
        int s = 1;

        while (e >= s) {
            System.out.print(e + " ");
            if (--e >= s) {
                System.out.print(s + " ");
            }
            s++;
        }
    }
}