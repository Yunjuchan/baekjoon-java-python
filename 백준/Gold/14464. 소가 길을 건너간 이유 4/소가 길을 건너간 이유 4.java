import java.io.*;
import java.util.*;

public class Main {

    public static class Animal implements Comparable<Animal> {
        int A;
        int B;
        int type;

        public Animal(int A, int B, int type) {
            this.A = A;
            this.B = B;
            this.type = type;
        }

        @Override
        public int compareTo(Animal other) {
            if (this.A == other.A) {
                return other.type - this.type;
            }
            return this.A - other.A;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int result = 0;

        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Animal> que = new PriorityQueue<>();
        Queue<int[]> possible = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (int i = 0; i < C; i++) {
            int T = Integer.parseInt(br.readLine());
            que.offer(new Animal(T,T, 0));
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            que.offer(new Animal(A, B, 1));
        }

        while (!que.isEmpty()) {
            Animal animal = que.poll();
//            System.out.println(animal.A + " " + animal.B + " " + animal.type);
            if (animal.type == 0) {
                while (!possible.isEmpty() && possible.peek()[1] < animal.A) {
                    possible.poll();
                }
                if (!possible.isEmpty()) {
                    possible.poll();
                    result++;
                }
            } else {
                possible.offer(new int[]{animal.A, animal.B});
            }
        }
        System.out.println(result);
    }
}