public class BST_ARR <T extends Comparable<T>>{
    T[] tree;
    int size;

    BST_ARR(int size){
        tree = (T[]) new Comparable[size];
        this.size = 0;
    }
    public void insert(T data){
        int index = 0;
        while(index < tree.length && tree[index] != null){
            if (data.compareTo(tree[index]) < 0){
                index = 2 * index + 1;
            } else {
                index = 2 * index + 2;
            }
        }
        if (index < tree.length){
            tree[index] = data;
            size++;
        } else
            System.out.println("the tree is full");

    }

    //inorder traversal (lnr)
    public void traverse(){
        traverse(0);
    }
    private void traverse(int root){
        if (root < tree.length && tree[root] != null) {
            traverse(2 * root + 1);
            System.out.print(tree[root] + " ");
            traverse(2 * root + 2);
        }
    }
    public void traverseBFS(){
        System.out.println();
        System.out.print("bfs: ");
        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
    }

    public int find(T data){
        int index = 0;

        while(index < tree.length && data.compareTo(tree[index])!=0){
            if (data.compareTo(tree[index]) > 0)
                index = 2 * index + 2;
            else
                index = 2 * index + 1;
        }
        if (index < tree.length && data.compareTo(tree[index]) == 0){
            return index;
        }
        return -1;
    }

    public void delete(T data){
        int currIndex = find(data);

        if (currIndex >= tree.length || tree[currIndex] == null) {
            return;
        }

    if (2 * currIndex + 1 < tree.length && 2 * currIndex + 2 < tree.length) {
        if (tree[2 * currIndex + 1] == null && tree[2 * currIndex + 2] == null) {
            delNoChild(currIndex);
        } else if (tree[2 * currIndex + 1] == null || tree[2 * currIndex + 2] == null) {
            delOneChild(currIndex);
        }
    } else
            delTwoChildren(currIndex);
    }
    private int findInOrderSuccessor(int currentIndex) {
        currentIndex = 2 * currentIndex + 2;

        while (tree[currentIndex * 2 + 1] != null) {
            currentIndex = 2 * currentIndex + 1;
        }

        return currentIndex;
    }
    private void delNoChild(int currIndex){
        tree[currIndex] = null;
    }
    private void delOneChild(int currIndex){
        int childIndex;
        if (tree[2 * currIndex + 1] != null) {
            childIndex = 2 * currIndex + 1; // Left child
        } else {
            childIndex = 2 * currIndex + 2; // Right child
        }
        tree[currIndex] = tree[childIndex];
        tree[childIndex] = null;
    }
    private void delTwoChildren(int currIndex){
        int successorIndex = findInOrderSuccessor(currIndex);
        T successorValue = tree[successorIndex];
        delete(successorValue);
        tree[currIndex] = successorValue;
    }

}