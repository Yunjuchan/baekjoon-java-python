import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        int idx = 0;
        char[] ucpc = new char[] {'U', 'C', 'P', 'C'};

        for (char c : line.toCharArray()) {
            if (idx == 4) {
                break;
            }
            if (c == ucpc[idx]) {
                idx++;
            }
        }

        if (idx == 4) {
            System.out.println("I love UCPC");
        } else {
            System.out.println("I hate UCPC");
        }
    }
}