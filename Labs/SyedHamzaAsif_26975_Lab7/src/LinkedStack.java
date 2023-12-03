public class LinkedStack<T> {
    StackNode<T> top;


    public void PUSH(T c){
        StackNode<T> newNode = new StackNode<T>(c);
        if (top == null) {
            top = newNode;
            return;
        }
        newNode.next = top;
        top = newNode;
    }

    public T POP(){
        if (isEmpty())
            throw new NullPointerException("The stack is empty");
        StackNode<T> returnNode = top;
        top = top.next;
        return returnNode.info;
    }

    public Boolean isEmpty(){
        return top == null;
    }
    public void peek(){
        System.out.println(top.info);
    }
}
