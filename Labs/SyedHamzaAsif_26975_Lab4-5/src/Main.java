public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);

        System.out.println(list);

        System.out.println(list.find(2));
        System.out.println(list.find(10));

        list.delete(2);
        System.out.println(list);


        list.insertBefore(list.find(4), 10);
        System.out.println(list);

        list.clear();
        System.out.println(list);



    }
}