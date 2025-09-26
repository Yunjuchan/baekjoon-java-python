import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int Y = 2024;
        int M = 1;

        int N = Integer.parseInt(br.readLine());
        M += N * 7;
        Y += M / 12;
        M %= 12;
        if (M == 0) {
            Y -= 1;
            M = 12;
        }
        System.out.println(Y + " " + M);
    }
}