package Lab6_more;

public class LinkedList {
    Node head;

    public void insert(int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node node= new Node(data);
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }
    public Node findMiddle(){

        if (head == null){
            return null;
        }
        if (head.next == null){
            return head;
        }
        Node fastRunner = head;
        Node slowRunner = head;

        while(fastRunner != null && fastRunner.next != null){
            fastRunner = fastRunner.next.next;
            slowRunner = slowRunner.next;
        }
        return slowRunner;
    }
    public String toString() {
        Node temp = head;
        String str = "";
        while (temp != null) {
            str += temp.data + ", ";
            temp = temp.next;
        }
        return str;
    }

    public void sortedMerge(LinkedList l1, LinkedList l2) {
        Node head1 = l1.head;
        Node head2 = l2.head;

        if (head1 == null) {
            return;
        }
        if (head2 == null) {
            return;
        }

        Node mergedHead;
        if (head1.data < head2.data) {
            mergedHead = head1;
            head1 = head1.next;
        } else {
            mergedHead = head2;
            head2 = head2.next;
        }

        Node current = mergedHead;

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                current.next = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }

        if (head1 != null) {
            current.next = head1;
        } else {
            current.next = head2;
        }
    }

}
