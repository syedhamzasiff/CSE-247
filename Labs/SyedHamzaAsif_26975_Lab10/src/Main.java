public class Main {
    public static void main(String[] args) {

        HashT<Integer> hashTable = new HashT<>(10);

        hashTable.insert(5);
        hashTable.insert(15);
        hashTable.insert(25);
        hashTable.insert(6);
        hashTable.insert(16);

        hashTable.displayTable();

        System.out.println("Find 15: " + hashTable.find(15));
        System.out.println("Find 8: " + hashTable.find(8));

        System.out.println("after deleting 15");
        hashTable.delete(15);
        hashTable.displayTable();


    }

}