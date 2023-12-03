class MyArrayList<T extends Comparable<T>> {
    T[] arr;
    int currIndex;

    // default constructor to create an array
    MyArrayList() {
        arr = (T[]) new Comparable[10];
        currIndex = -1;
    }

    // constructor to create an array
    MyArrayList(int size) {
        arr = (T[]) new Comparable[size];
        currIndex = -1;
    }

    /* method to add value in an array
    Assume the insertion is going to perform in the end,
    next to the last inserted location. If no available space
    then increase the arr size to insert new value */
    public void add(T data){
        if (arr.length-1 == currIndex) {
            T[] newArr = (T[]) new Comparable[arr.length * 2];
            for (int i = 0; i < arr.length; i++) {
                newArr[i] = arr[i];
            }
            new MyArrayList(newArr.length);
            arr = newArr;
        }
            arr[++currIndex] = data;

    }

    // return length of occupied list
    public int length() {
        return currIndex + 1;
    }

    // get element at given index location
    public T get(int index) {
        return arr[index];
    }

    // update element at given location
    public void update (int index, T value) {
        arr[index] = value;
    }

    // if the value found in array then return its index
    public int find (T value) {
        for (int j = 0; j <= currIndex; j++) {
            if (arr[j].equals(value))
                return j;
        }
        return -1;
    }

    // make array empty (keep the size same).
    public void clear(){
        for (int i = 0; i <= currIndex; i++) {
            arr[i] = null;
        }
    }

    // first find the value in an array then delete the value through
    // backward movement in an array.
    public void remove (T value) {
        int index = find(value);
        if (index!=-1) {
            for (int i = index; i < currIndex; i++) {
                arr[i] = arr[i + 1];
            }
            arr[currIndex] = null;
            currIndex--;
        }
    }

    @Override
    public String toString() {
        String str="";
        for(int i=0; i<arr.length;i++)
            str = str + arr[i] + " ";
        return str;

    }

    public T findMax(){
        T temp = arr[0];
        for (int i = 0; i <= currIndex; i++) {
            int index = temp.compareTo(arr[i]);
            if (index < 0){
                temp = arr[i];
            }
        }
        return temp;
    }
}



