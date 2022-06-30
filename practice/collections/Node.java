package practice.collections;

public class Node<E> {
    
    E item;
    Node<E> next;
    Node<E> prev;

    public Node() {
    }

    public Node(Node<E> prev, E item, Node<E> next) {
        this.item = item;
        this.next = next;
        this.prev = prev;
    }

}
