import java.io.*;
import java.util.*;

public class Main {

    public static class Student {
        String name;
        int k;
        int e;
        int m;

        public Student(String name, int k, int e, int m) {
            this.name = name;
            this.k = k;
            this.e = e;
            this.m = m;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Student[] arr = new Student[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int k = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Student student = new Student(name, k, e, m);
            arr[i] = student;
        }

        Arrays.sort(arr, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.k == o2.k) {
                    if (o1.e == o2.e) {
                        if (o1.m == o2.m) {
                            return o1.name.compareTo(o2.name);
                        }
                        return o2.m - o1.m;
                    }
                    return o1.e - o2.e;
                }
                return o2.k - o1.k;
            }
        });

        for (Student student : arr) {
            sb.append(student.name).append("\n");
        }

        System.out.println(sb);
    }
}