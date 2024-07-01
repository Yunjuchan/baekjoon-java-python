import java.io.*;
import java.util.*;

public class Main {
    static class Person implements Comparable<Person> {
        char alpha;
        int n;

        public Person(char alpha, int n) {
            this.alpha = alpha;
            this.n = n;
        }

        @Override
        public int compareTo(Person other) {
            if (this.alpha != other.alpha) {
                return Character.compare(this.alpha, other.alpha);
            } else {
                return Integer.compare(this.n, other.n);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return alpha == person.alpha && n == person.n;
        }

        @Override
        public int hashCode() {
            return Objects.hash(alpha, n);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        List<Person> A = new ArrayList<>();
        List<Person> B = new ArrayList<>();
        Stack<Person> C = new Stack<>();

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<5; j++) {
                String[] ticket = st.nextToken().split("-");
                char alpha = ticket[0].charAt(0);
                int n = Integer.parseInt(ticket[1]);
                A.add(new Person(alpha, n));
                B.add(new Person(alpha, n));
            }
        }
        A.sort(Person::compareTo);
        int order = 0;
        int i = 0;
        while (order < N*5) {
            if (i < N * 5 && B.get(i).equals(A.get(order))) {
                i++;
                order++;
                continue;
            } else if (!C.isEmpty() && C.peek().equals(A.get(order))) {
                C.pop();
                order++;
                continue;
            } else if (i < 5*N) {
                C.push(B.get(i));
                i++;
            } else {
                break;
            }
        }
        
        if (order == N * 5) {
            System.out.println("GOOD");
        } else {
            System.out.println("BAD");
        }
    }
}