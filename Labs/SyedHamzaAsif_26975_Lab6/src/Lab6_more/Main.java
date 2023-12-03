package Lab6_more;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.insert(1);
        linkedList.insert(3);
        linkedList.insert(5);
        linkedList.insert(7);
        linkedList.insert(9);
        linkedList.insert(11);

        System.out.println(linkedList.findMiddle());

        LinkedList linkedList1 = new LinkedList();
        linkedList1.insert(0);
        linkedList1.insert(2);
        linkedList1.insert(4);
        linkedList1.insert(6);

        linkedList.sortedMerge(linkedList, linkedList1);
        System.out.println(linkedList);
    }


}
