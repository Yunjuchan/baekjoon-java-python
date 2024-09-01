import javax.print.attribute.IntegerSyntax;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Person implements Comparable<Person>{
        int t;
        int eat;
        int n;
        public Person (int t, int eat, int n) {
            this.t = t;
            this.eat = eat;
            this.n = n;
        }

        @Override
        public int compareTo(Person other) {
            if (this.t == other.t) {
                return this.n - other.n;
            }
            return this.t - other.t;
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int diff = n - s;
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue<Person> pq = new PriorityQueue<>();
        for (int i=1; i<=m; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Person(0, Integer.parseInt(st.nextToken()), i));
        }
        int cnt = 0;
        int result = 0;
        while (cnt < diff) {
            cnt++;
            Person p = pq.poll();
            result = p.n;
            pq.add(new Person(p.t + p.eat, p.eat, p.n));
        }
        System.out.println(result);
    }
}