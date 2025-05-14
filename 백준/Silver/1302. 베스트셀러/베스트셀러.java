import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String bestSeller = "";
        int count = 0;

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> books = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String book = br.readLine();
            books.putIfAbsent(book, 0);
            int cnt = books.get(book) + 1;
            books.replace(book, cnt);
            if (count < cnt) {
                count = cnt;
                bestSeller = book;
            } else if (count == cnt && bestSeller.compareTo(book) > 0) {
                bestSeller = book;
            }
        }
        System.out.println(bestSeller);
    }
}