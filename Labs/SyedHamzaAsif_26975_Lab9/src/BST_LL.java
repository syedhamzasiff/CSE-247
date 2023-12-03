public class BST_LL <T extends Comparable<T>> {
    Node<T> root;

    //insert key in a tree
    public void insert(T key){
        if (root == null){
            root = new Node<>(key);
            return;
        }
        Node<T> temp = root;
        Node<T> prev = root;
        while(temp != null){
            prev = temp;
            if (key.compareTo(temp.data) > 0){
                temp = temp.right;
            } else {

                temp = temp.left;
            }
        }

        if (key.compareTo(prev.data) > 0){
            prev.right = new Node<>(key);
            return;
        }
        if (key.compareTo(prev.data) < 0){
            prev.left = new Node<>(key);
        }

    }

    //in-order traversal (lnr)
    public void traverseLNR(Node root) {
        if (root != null) {
            traverseLNR(root.left);
            System.out.print(root + " ");
            traverseLNR(root.right);
        }
    }

    //find key in a tree
    public Node<T> find(T key) {
        if (root.data == key)
            return root;

        Node<T> temp = root;
        while (temp != null) {
            if (key.compareTo(temp.data) > 0)
                temp = temp.right;
            else if (key.compareTo(temp.data) < 0)
                temp = temp.left;

            else return temp;
        }
        return null;
    }

    //print tree using Breadth first traversal
    public void traverse(Node<T> currNode) {
        Queue<Node<T>> queue = new Queue<>();
        queue.enqueue(currNode);

        while (!queue.isEmpty()) {
            Node<T> temp = queue.dequeue();
            System.out.print(temp.data + " ");

            if (temp.left != null) {
                queue.enqueue(temp.left);
            }
            if (temp.right != null) {
                queue.enqueue(temp.right);
            }
        }
    }
    public void delete(T key) {
        Node<T>[] ref = findParentCurrent(key);
        Node<T> parent = ref[0];
        Node<T> temp = ref[1];

        if (temp.left == null && temp.right == null) {
            delNoChild(parent, temp);
        } else if ((temp.left != null && temp.right == null) || (temp.left == null && temp.right != null)) {
            delOneChild(parent, temp);
        } else {
            delTwoChildren(temp);
        }
    }

    private void delNoChild(Node<T> parent, Node<T> temp) {
        if (parent == null) {
            root = null;
        } else if (parent.left == temp) {
            parent.left = null;
        } else {
            parent.right = null;
        }
    }
    private void delOneChild(Node<T> parent, Node<T> temp) {
        Node<T> child;
        if (temp.left != null) {
            child = temp.left;
        } else {
            child = temp.right;
        }

        if (parent == null) {
            root = child;
        } else if (parent.left == temp) {
            parent.left = child;
        } else {
            parent.right = child;
        }
    }
    private Node<T> findSuccessor(Node<T> temp) {
        Node<T> current = temp.right;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
    private void delTwoChildren(Node<T> temp) {
        Node<T> successor = findSuccessor(temp);
        temp.data = successor.data;
        if (temp.right == successor) {
            temp.right = successor.right;
        } else {
            delNoChild(successor, successor.right);
        }
    }
    private Node<T>[] findParentCurrent(T key) {
        Node<T> parent = null;
        Node<T> current = root;

        while (current != null && !key.equals(current.data)) {
            parent = current;

            if (key.compareTo(current.data) < 0)
                current = current.left;
            else
                current = current.right;
        }
        Node<T>[] result = new Node[2];
        result[0] = parent;
        result[1] = current;

        return result;
    }

}
