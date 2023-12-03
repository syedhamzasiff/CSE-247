import java.io.*;

public class HashingOpenAdd {
    String[] table;

    public HashingOpenAdd(int s) {
        table = new String[s + (s / 3)];
    }

    private int strToInt(String v) {
        int intString = 0;
        for (int i = 0; i < v.length(); i++) {
            intString += v.charAt(i);
        }
        return intString;
    }

    private int hash(int sum) {
        return sum % table.length;
    }

    private int rehash(int sum, int i) {
        return (sum + i) % table.length;
    }

    public void insert(String v) {
        int sum = strToInt(v);
        int hashValue = hash(sum);
        int i = 0;
        while (table[hashValue] != null && !table[hashValue].equals("deleteDelete")) {
            hashValue = rehash(sum, i);
            i++;
        }
        table[hashValue] = v;
    }

    public boolean search(String v) {
        int sum = strToInt(v);
        int hashValue = hash(sum);
        int i = 0;
        while (table[hashValue] != null && !table[hashValue].equals(v) && !table[hashValue].equals("deleteDelete")) {
            hashValue = rehash(sum, i);
            i++;
        }
        return table[hashValue] != null && table[hashValue].equals(v);
    }

    public String displayTable() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                sb.append(i).append(": ").append(table[i]).append("\n");
            }
        }
        return sb.toString();
    }

    public void delete(String v) {
        int sum = strToInt(v);
        int hashValue = hash(sum);
        int i = 0;
        while (table[hashValue] != null && !table[hashValue].equals(v) && !table[hashValue].equals("deleteDelete")) {
            hashValue = rehash(sum, i);
            i++;
        }
        if (table[hashValue] != null && table[hashValue].equals(v))
            table[hashValue] = "deleteDelete";
    }

    public static void main(String[] args) {

        /*
        HashingOpenAdd hashingOpenAdd = new HashingOpenAdd(35000);

        try {
            FileInputStream fstream = new FileInputStream("Dictionary.csv");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                String[] word = strLine.split(",");
                hashingOpenAdd.insert(word[0]);
            }
            in.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        hashingOpenAdd.delete("Zoanthus");

        System.out.println(hashingOpenAdd.displayTable());

        System.out.println();

        System.out.println(hashingOpenAdd.search("Zoanthus"));


         */
        HashingOpenAdd hashingOpenAdd = new HashingOpenAdd(10);

        hashingOpenAdd.insert("hamza");
        hashingOpenAdd.insert("asif");
        hashingOpenAdd.insert("hdsdfda");
        hashingOpenAdd.insert("blabla");
        hashingOpenAdd.insert("mouse");
        hashingOpenAdd.insert("table");
        hashingOpenAdd.insert("hashisn");
        hashingOpenAdd.insert("hamzaasig");

        System.out.println(hashingOpenAdd.displayTable());


    }
}

