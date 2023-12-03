public class Main {
    public static void main(String[] args) {

        System.out.println("INTEGER LIST DEMO");
        DLinkedList<Integer> dLinkedList = new DLinkedList<>();
        dLinkedList.insertInOrder(4);
        dLinkedList.insertInOrder(5);
        dLinkedList.insertInOrder(1);
        dLinkedList.insertInOrder(2);
        dLinkedList.insertInOrder(15);
        dLinkedList.insertInOrder(6);

        System.out.println("Print after inserting all the numbers: ");
        System.out.println(dLinkedList);

        System.out.println();

        System.out.println("finding 3; it does not exist in the list");
        System.out.println(dLinkedList.find(3));
        System.out.println("finding 5, it return the toString of the node || the address if we remove the toString");
        System.out.println(dLinkedList.find(5));

        System.out.println();

        System.out.println("the list after deleting the value 6");
        dLinkedList.delete(6);
        System.out.println(dLinkedList);

        System.out.println();

        System.out.println("the length of the list");
        System.out.println(dLinkedList.length());

        System.out.println();

        System.out.println("reversed list");
        dLinkedList.reverseList();
        System.out.println(dLinkedList);

        System.out.println();

        System.out.println("is the list empty?");
        System.out.println(dLinkedList.isEmpty());

        System.out.println();

        System.out.println("after clearing the list, is it empty now?");
        dLinkedList.clearList();
        System.out.println(dLinkedList.isEmpty());

        System.out.println();
        System.out.println("STRING LIST DEMO");

        DLinkedList<String> stringDLinkedList = new DLinkedList<>();
        stringDLinkedList.insertInOrder("hamza");
        stringDLinkedList.insertInOrder("asif");
        stringDLinkedList.insertInOrder("dsa");
        stringDLinkedList.insertInOrder("is");
        stringDLinkedList.insertInOrder("abc");

        System.out.println("Print after inserting all the strings: ");
        System.out.println(stringDLinkedList);

        System.out.println();

        System.out.println("finding xyz; it does not exist in the list");
        System.out.println(stringDLinkedList.find("xyz"));
        System.out.println("finding abc, it return the toString of the node || the address if we remove the toString");
        System.out.println(stringDLinkedList.find("abc"));

        System.out.println();

        System.out.println("the list after deleting the value hamza");
        stringDLinkedList.delete("hamza");
        System.out.println(stringDLinkedList);

        System.out.println();

        System.out.println("the length of the list");
        System.out.println(stringDLinkedList.length());

        System.out.println();

        System.out.println("reversed list");
        stringDLinkedList.reverseList();
        System.out.println(stringDLinkedList);

        System.out.println();

        System.out.println("is the list empty?");
        System.out.println(stringDLinkedList.isEmpty());

        System.out.println();

        System.out.println("after clearing the list, is it empty now?");
        stringDLinkedList.clearList();
        System.out.println(stringDLinkedList.isEmpty());

        System.out.println();

        System.out.println();
        System.out.println("STUDENT LIST DEMO");

        DLinkedList<Student> studentDLinkedList = new DLinkedList<Student>();

        Student student = new Student("hamza", 3);
        studentDLinkedList.insertInOrder(student);

        Student student2 = new Student("hamzaasif", 2);
        studentDLinkedList.insertInOrder(student2);

        Student student1 = new Student("asif", 6);
        studentDLinkedList.insertInOrder(student1);

        System.out.println("sorted student list based on id");
        System.out.println(studentDLinkedList);

        System.out.println("finding student 2");
        System.out.println(studentDLinkedList.find(student2));

        System.out.println("deleting student 2");
        studentDLinkedList.delete(student2);
        System.out.println(studentDLinkedList);

        System.out.println("reversing the list");
        studentDLinkedList.reverseList();
        System.out.println(studentDLinkedList);
    }
}