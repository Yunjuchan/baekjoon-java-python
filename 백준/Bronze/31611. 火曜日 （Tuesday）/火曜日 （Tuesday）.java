import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        if (N % 7 == 2) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
