public class Main {
    public static void main(String[] args) {
        MyArrayList myList = new MyArrayList();

        myList.InsertInOrder(10);
        myList.InsertInOrder(4);
        myList.InsertInOrder(12);
        myList.PrintList();

        myList.Update(2, 16);
        myList.PrintList();

        System.out.println(myList.Find(16));

        myList.Remove(10);
        myList.PrintList();

        System.out.println("Length: " + myList.Length());
    }
}