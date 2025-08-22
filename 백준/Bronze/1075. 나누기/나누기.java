import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Integer.parseInt(br.readLine());
        long F = Integer.parseInt(br.readLine());

        N /= 100;
        N *= 100;
        N += (F - N % F) % F;
        System.out.printf("%02d\n", N % 100);
    }
}