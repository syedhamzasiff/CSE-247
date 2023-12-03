class MyArrayList{
    private int[] arr;
    private int currIndex;
    MyArrayList() { // default constructor to create an array
        arr = new int[10];
        currIndex=-1;
    }
    MyArrayList(int size) { // constructor to create an array
        arr = new int[size];
        currIndex=-1;
    }
    public void PrintList(){
        for(int i=0; i<currIndex+1;i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    public void InsertInOrder(int v) {
        if (arr.length - 1 == currIndex) {
            /*create new double size array
            copy data from old array to new array
            rename new array as old array name
            */
            int[] newArr = new int[arr.length * 2];
            for (int i = 0; i < arr.length; i++) {
                newArr[i] = arr[i];
            }
            new MyArrayList(newArr.length);
            arr = newArr;
        }
        if (currIndex == -1) {
            //increment in current index and store the data
            currIndex++;
            arr[currIndex] = v;
        } else {
            // store data in the list in ascending order
            int i = 0;
            while(i<=currIndex && v>arr[i]){
                i++;
            }
            for (int j = currIndex; j >= i; j--) {
                arr[j+1] = arr[j];
            }
            arr[i] =  v;
            currIndex++;
        }
    }
    public int Length() {
        // return length of occupied list
        return currIndex + 1;
    }
    public int get(int index) {
        // get element at given index location
        return arr[index];
    }
    public void Update (int index, int value) {
        // update element at given location
        arr[index] = value;
    }
    public int Find (int value) {
        // if the value found in array then return its index
        for (int j = 0; j <= currIndex; j++) {
            if (arr[j] == value)
                return j;
        }
        return -1;
    }
    public void Remove (int value) {
        // first find the value in an array then delete the value through
        // backward movement in an array.
        int index = Find(value);
        if (index!=-1) {
            for (int i = index; i < currIndex; i++) {
                arr[i] = arr[i + 1];
            }
            currIndex--;
        }
    }
}

