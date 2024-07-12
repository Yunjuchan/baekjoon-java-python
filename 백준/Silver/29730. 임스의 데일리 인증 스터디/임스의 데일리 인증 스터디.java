import java.io.*;
import java.util.*;

class Record implements Comparable<Record> {
    String content;

    Record (String content) {
        this.content = content;
    }

    @Override
    public int compareTo(Record other) {
        int result = Integer.compare(this.content.length(), other.content.length());
        if (result == 0) {
            return this.content.compareTo(other.content);
        }
        return result;
    }
}

class Baekjoon implements Comparable<Baekjoon> {
    String content;

    Baekjoon (String content) {
        this.content = content;
    }

    @Override
    public int compareTo(Baekjoon other) {

        int thisNumber = Integer.parseInt(this.content.substring(7));
        int otherNumber = Integer.parseInt(other.content.substring(7));
        int result = Integer.compare(thisNumber, otherNumber);
        return result;
    }
}

public class Main {
    static int N;
    static List<List<Integer>> adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Record> que1 = new PriorityQueue<>();
        PriorityQueue<Baekjoon> que2 = new PriorityQueue<>();

        for (int i=0; i<N; i++) {
            String r = br.readLine();
            if (r.startsWith("boj.kr/")) {
                que2.offer(new Baekjoon(r));
            } else {
                que1.offer(new Record(r));
            }
        }

        while (!que1.isEmpty()) {
            System.out.println(que1.poll().content);
        }

        while (!que2.isEmpty()) {
            System.out.println(que2.poll().content);
        }
    }
}