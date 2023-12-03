public class ArrayStack<T extends Comparable<T>> {
    T stackList[];
    int top;

    ArrayStack(int size) {
        stackList = (T[]) new Comparable[size];
        this.top = -1;
    }

    public void PUSH(T c) {
        if (top < stackList.length-1)
            stackList[++top] = c;
        else throw new NullPointerException("Stack is full");
    }

    public T POP() {
        if (isEmpty())
            throw new NullPointerException("The stack is empty");
        return stackList[top--];
    }

    public Boolean isEmpty() {
        return top == -1;

    }

    public Boolean isFull(){
        return top == stackList.length-1;

    }
    public T peek(){
        return stackList[top];
    }
}