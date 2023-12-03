public class HashT <T>{
    LinkedList<T>[] table;

    public HashT(int s) {
        table = new LinkedList[s+(s/3)];

        for (int i = 0; i < table.length; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public int hash(T obj) {
        return obj.hashCode() % table.length;
    }

    public void insert(T obj){
        table[hash(obj)].insert(obj);
    }

    public Boolean find(T obj){
        int index = hash(obj);
        LinkedList<T> list = table[index];
        return list.find(obj);
    }

    public void delete(T obj) {
        int index = hash(obj);
        LinkedList<T> list = table[index];
        list.delete(obj);
    }
    public void displayTable() {
        for (int i = 0; i < table.length; i++) {
            System.out.print("Bucket " + i + ": ");
            LinkedList<T> list = table[i];
            System.out.println(list);
        }
    }




}