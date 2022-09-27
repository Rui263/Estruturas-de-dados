package aulas.praticas;


public class ANode<T> {
    private T data;
    private ANode next;
    public ANode() {}
    public ANode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ANode<T> getNext() {
        return next;
    }

    public void setNext(ANode<T> next) {
        this.next = next;
    }
}
