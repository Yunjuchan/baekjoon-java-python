import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 0;
        for (int i = 0; i < 4; i++) {
            t += Integer.parseInt(br.readLine());
        }

        System.out.println(t / 60);
        System.out.println(t % 60);
    }
}

