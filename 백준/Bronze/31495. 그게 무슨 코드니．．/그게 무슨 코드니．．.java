import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        StringBuilder sb = new StringBuilder();
        int N = word.length();
        if (word.charAt(0) != '"' || word.charAt(N-1) != '"' || N <= 2) {
            System.out.println("CE");
            return;
        }
        System.out.println(word.substring(1, N-1));
    }
}