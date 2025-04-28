package datastructures;

public class MyArray {
    private int[] arr;
    private int size;

    // 생성자
    public MyArray(int capacity) {
        arr = new int[capacity];
        size = 0;
    }

    // 삽입
    public void add(int data) {
        if (size >= arr.length) {
            throw new RuntimeException("배열이 가득 찼습니다.");
        }
        arr[size] = data;
        size++;
    }

    // 특정 인덱스의 값 확인
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("유효하지 않은 인덱스 입니다.");
        }
        return arr[index];
    }

    // 특정 인덱스의 값 삭제
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("유효하지 않은 인덱스 입니다.");
        }

        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
    }

    // 현재 배열의 크기
    public int size() {
        return size;
    }
}
