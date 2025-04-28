package datastructures;

import java.util.NoSuchElementException;

public class SinglyLinkedList {

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // 가장 끝에 삽입
    public void add(int data) {
        Node newNode = new Node(data);

        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // 가장 앞에 삽입
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    // 중간에 삽입
    public void addAtIndex(int index, int data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("유효하지 않은 인덱스입니다.");
        }

        if (index == 0) {
            addFirst(data);
        } else if (index == size) {
            add(data);
        } else {
            Node newNode = new Node(data);
            Node cur = head;

            for (int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }
            newNode.next = cur.next;
            cur.next = newNode;
            size++;
        }
    }

    // 특정 인덱스의 값 확인
    public int get(int idx) {
        Node cur = head;
        for (int i = 0; i < idx; i++) {
            cur = cur.next;
        }
        return cur.data;
    }

    // 가장 끝 값 삭제
    public void remove() {
        if (size == 0) {
            throw new NoSuchElementException("삭제 할 값이 없습니다.");
        }

        if (head == tail) { // 크기가 1일 때
            head = null;
            tail = null;
        } else {
            Node cur = head;
            while (cur.next != tail) {
                cur = cur.next;
            }

            cur.next = null;
            tail = cur;
        }
        size--;
    }

    // 가장 처음 삭제
    public void removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException("삭제 할 값이 없습니다.");
        }

        head = head.next;

        if (head == null) {
            tail = null;
        }

        size--;
    }

    // 특정 인덱스 값 삭제
    public void removeAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("유효하지 않은 인덱스입니다.");
        }

        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            remove();
        } else {
            Node cur = head;
            for (int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }

            cur.next = cur.next.next;
            size--;
        }
    }
}
