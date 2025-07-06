import java.io.*;
import java.util.*;

public class Main {

    public static class Word implements Comparable<Word> {
        String word;
        int cnt;

        public Word(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Word other) {
            if (this.cnt == other.cnt) {
                if (this.word.length() == other.word.length()) {
                    return this.word.compareTo(other.word);
                }
                return other.word.length() - this.word.length();
            }
            return other.cnt - this.cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            map.putIfAbsent(word, 0);
            map.replace(word, map.get(word) + 1);
        }

        PriorityQueue<Word> que = new PriorityQueue<>();

        for (String key : map.keySet()) {
            if (key.length() < M) {
                continue;
            }
            que.offer(new Word(key, map.get(key)));
        }

        while (!que.isEmpty()) {
            Word cur = que.poll();
            sb.append(cur.word).append("\n");
        }
        
        System.out.println(sb);
    }
}