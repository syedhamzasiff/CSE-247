public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(1);

        System.out.println(list);

        list.remove(3);
        list.remove(2);
        list.remove(1);
        list.remove(3);
        list.remove(2);
        list.remove(1);
        list.remove(3);
        list.remove(2);
        list.remove(1);
        list.remove(3);
        list.remove(2);
        list.remove(1);
        list.remove(2);


        System.out.println(list);
    }

}