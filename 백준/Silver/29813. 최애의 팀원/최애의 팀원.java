import java.io.*;
import java.util.*;

public class Main {
    static class Person {
        String name;
        int x;


        Person (String name, int x) {
            this.name = name;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        Queue<Person> P = new LinkedList<>();

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            P.offer(new Person(st.nextToken(), Integer.parseInt(st.nextToken())-1));
        }

        while (P.size()>1) {
            Person A = P.poll();
//            System.out.println("현재 팀원 뽑기중인 사람 " + A.name);
//            System.out.println("현재 남아있는 인원" + P.size());
            A.x %= P.size();
            while (A.x > 0) {
                Person B = P.poll();
//                System.out.println(B.name + " " + B.x);
                P.offer(B);
                A.x--;
            }

            P.poll();
        }

        String result = P.poll().name;
        System.out.println(result);
    }
}