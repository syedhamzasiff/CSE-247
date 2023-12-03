public class DLinkedList <T extends Comparable<T>>{
    Node<T> head;

    public void insertInOrder(T value) {
        Node<T> newNode = new Node<>(value);

        if (isEmpty()) {
            head = newNode;

        } else if (value.compareTo(head.data) <= 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
            Node<T> temp = head;

            while (temp.next != null && temp.next.data.compareTo(value) < 0) {
                temp = temp.next;
            }

            if (temp.next == null) {
                temp.next = newNode;
                newNode.prev = temp;
            } else {
                newNode.next = temp.next;
                newNode.prev = temp;
                temp.next.prev = newNode;
                temp.next = newNode;
            }
        }
    }

    public Node find(T value){
        Node<T> temp = head;
        while(temp!= null){
            if (temp.data.equals(value))
                return temp;
            temp = temp.next;
        }
        return null;
    }
    public void delete(T value){
        Node<T> temp = head;

        if (head.data.equals(value)) {
            head.next.prev = null;
            head = head.next;
            return;
        }
        while(temp.next!= null) {
            if (temp.data.equals(value)){
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                return;
            }
            temp = temp.next;
        }
        temp.prev.next = null;

    }
    public String toString(){
        String str = "";
        Node<T> temp = head;

        while(temp != null){
            str+= temp.data + ",";
            temp = temp.next;
        }
        return str;
    }
    public void clearList(){
        head = null;
    }
    public boolean isEmpty(){
        return head == null;
    }
    public int length(){
        Node<T> temp = head;
        int length = 0;

        while(temp!= null){
            length++;
            temp = temp.next;
        }
        return length;
    }
    public void reverseList(){
        Node prev = null;
        Node curr = head;
        Node temp = null;

        while(curr!= null){
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        head=prev;
    }
}
