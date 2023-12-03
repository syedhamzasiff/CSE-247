class Node <T>{
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
    }
}


public class LinkedList <T>{
    Node<T>head;

    public LinkedList() {
        this.head = null;
    }

    // insert new node at the end of list.
    public void insert(T d){
        if (head == null)
            head = new Node<>(d);
        else {
            Node<T>temp = head;

            while (temp.next != null)
                temp = temp.next;

            temp.next = new Node<>(d);
        }
    }

    // find a node with value d
    public Boolean find(T d){
        if (head == null){
            return null;
        }
        Node<T>temp = head.next;

        while(temp != null) {
            if (temp.data.equals(d))
                return true;
            temp = temp.next;
        }
        return false;
    }


    // make list empty
    public void clear(){
        head = null;
    }

    public void delete(T d) {
        if (head == null) {
            return;
        }

        if (head.data.equals(d)) {
            head = head.next;
            return;
        }

        Node<T> temp = head.next;
        Node<T> prev = head;

        while (temp != null) {
            if (temp.data.equals(d)) {
                prev.next = temp.next;
                return;
            }
            temp = temp.next;
            prev = prev.next;
        }
    }


    // returns a string with comma node values.
    public String toString(){
        String str = "";
        Node<T>temp = head;

        while(temp != null){
            str+= temp.data + ",";
            temp = temp.next;
        }
        return str;
    }

    //insert the node with value d, before the provided node
    public void insertBefore(Node<T>n, T d){

        if (head == n){
            Node<T> newHead= new Node<>(d);
            newHead.next = head;

        }
        Node<T>prev = head;
        Node<T>temp = head.next;

        while(temp != null){
            if (temp == n) {
                Node<T> newNode = new Node(10);
                newNode.next = temp;
                prev.next = newNode;
                return;
            }
            temp = temp.next;
            prev = prev.next;
        }
        System.out.println("the node does not exist");

    }


}
