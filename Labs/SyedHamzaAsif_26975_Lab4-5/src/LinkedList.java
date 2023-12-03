public class LinkedList <T>{
    Node head;

    public LinkedList() {
        this.head = null;
    }

    // insert new node at the end of list.
    public void insert(T d){
        if (head == null)
            head = new Node<>(d);
        else {
            Node temp = head;

            while (temp.next != null)
                temp = temp.next;

            temp.next = new Node<>(d);
        }
    }

    // find a node with value d
    public Node find(T d){
        Node temp = head.next;

        while(temp != null) {
            if (temp.data.equals(d))
                return temp;
            temp = temp.next;
        }
        return null;
    }


    // make list empty
    public void clear(){
        head = null;
    }

    // delete a node with value d (first occurrence)
    public void delete(T d){
        Node temp = head.next;
        Node prev = head;

        if (head.data.equals(d))
            head.next = head;

        while(temp != null) {
            if (temp.data.equals(d)){
                prev.next = prev.next.next;
                return;
            }
            temp = temp.next;
            prev = prev.next;
        }
    }

    // returns a string with comma node values.
    public String toString(){
        String str = "";
        Node temp = head;

        while(temp != null){
            str+= temp.data + ",";
            temp = temp.next;
        }
        return str;
    }

    //insert the node with value d, before the provided node
    public void insertBefore(Node n, T d){

        if (head == n){
            Node<T> newHead = new Node<>(d);
            newHead.next = head;

        }
        Node prev = head;
        Node temp = head.next;

        while(temp != null){
            if (temp == n) {
                Node newNode = new Node(10);
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
