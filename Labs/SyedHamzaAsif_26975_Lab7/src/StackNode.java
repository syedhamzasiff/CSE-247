public class StackNode <T> {
    T info;
    StackNode<T> next;

    public StackNode(T data) {
        this.info = data;
    }

    @Override
    public String toString() {
        return "StackNode{" +
                "info=" + info +
                '}';
    }
}

