import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N % 400 == 0) {
            System.out.println(30);
        } else if (N % 100 == 0) {
            System.out.println(29);
        } else if (N % 4 == 0) {
            System.out.println(30);
        } else {
            System.out.println(29);
        }
    }
}
