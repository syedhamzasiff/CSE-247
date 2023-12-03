package Lab6;

public class Game {
    Node tail;
    int size = 0;

    public Game() {
        tail = null;
    }
    public void insert(String player){
        Node newNode = new Node(player);
        if (tail == null){
            tail = newNode;
            tail.next = tail;
            size++;
            return;
        }
        newNode.next = tail.next;
        tail.next = newNode;
        tail = tail.next;
        size++;

    }
    public String playGame(){
        Node curr = tail.next;
        Node prev = tail;
        int R = (int) (Math.random()*100);
        while (curr != prev) {
            // traversing the list R times
            for (int i = 0; i < R; i++) {
                prev = curr;
                curr = curr.next;
            }
            if (curr == tail){
                prev.next = curr.next;
                curr = prev.next;
                tail = prev;
            }
            prev.next = curr.next;
            curr = prev.next;
        }
        return tail.name;
    }

    @Override
    public String toString() {
        String list = "{ ";
        Node temp = tail.next;
        while(temp != tail){
            list += (temp.name + ", ");
            temp = temp.next;
        }
        return list + tail.name + " }";
    }
}
