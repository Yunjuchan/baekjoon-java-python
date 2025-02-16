import java.io.*;
import java.util.*;

public class Main {

    public static class Person implements Comparable<Person>{
        int house;
        int office;

        public Person(int house, int office) {
            this.house = house;
            this.office = office;
        }

        @Override
        public int compareTo(Person other) {
            if (this.office == other.office) {
                return this.house - other.house;
            }
            return this.office - other.office;
        }
    }

    public static class Person2 implements Comparable<Person2>{
        int house;
        int office;

        public Person2(int house, int office) {
            this.house = house;
            this.office = office;
        }

        @Override
        public int compareTo(Person2 other) {
            return this.house - other.house;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        PriorityQueue<Person> que = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int house = Integer.parseInt(st.nextToken());
            int office = Integer.parseInt(st.nextToken());
            if (house > office) {
                int tmp = house;
                house = office;
                office = tmp;
            }

            que.add(new Person(house, office));
        }

        int d = Integer.parseInt(br.readLine());
        PriorityQueue<Person2> include = new PriorityQueue<>();
        while (!que.isEmpty()) {

            Person p = que.poll();
            include.offer(new Person2(p.house, p.office));
            int e = p.office;
            while (!include.isEmpty() && include.peek().house < e - d) {
                include.poll();
            }
            result = Math.max(result, include.size());
        }

        System.out.println(result);
    }
}