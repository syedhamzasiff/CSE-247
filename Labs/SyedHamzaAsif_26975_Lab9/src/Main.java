public class Main {
    public static void main(String[] args) {

        System.out.println("BST LINKED LIST");
        BST_LL<Integer> tree = new BST_LL<>();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        System.out.print("in order: ");
        tree.traverseLNR(tree.root);
        System.out.println();
        System.out.print("bfs: ");
        tree.traverse(tree.root);
        System.out.println();

        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.print("find 30 & 25: ");
        System.out.print(tree.find(30));
        System.out.print(" & ");
        System.out.println(tree.find(25));
        System.out.println();

        System.out.println("inorder after adding more: ");
        System.out.print("lnr: ");
        tree.traverseLNR(tree.root);
        System.out.println();
        System.out.print("bfs: ");
        tree.traverse(tree.root);


        System.out.println();
        System.out.println();


        System.out.println("deleting 20, no child: ");
        tree.delete(20);
        System.out.print("lnr: ");
        tree.traverseLNR(tree.root);
        System.out.println();
        System.out.print("bfs: ");
        tree.traverse(tree.root);
        System.out.println();
        System.out.println();

        System.out.println("deleting 30, one chile: ");
        tree.delete(30);
        System.out.print("lnr: ");
        tree.traverseLNR(tree.root);
        System.out.println();
        System.out.print("bfs: ");
        tree.traverse(tree.root);
        System.out.println();
        System.out.println();



        System.out.println("deleting 70, two chile: ");
        tree.delete(70);
        System.out.print("lnr: ");
        tree.traverseLNR(tree.root);
        System.out.println();
        System.out.print("bfs: ");
        tree.traverse(tree.root);
        System.out.println();
        System.out.println();



        System.out.println("BST ARRAY");
        BST_ARR<Integer> bstArr = new BST_ARR<>(7);
        bstArr.insert(50);
        bstArr.insert(30);
        bstArr.insert(20);
        bstArr.insert(40);
        bstArr.insert(70);
        bstArr.insert(60);
        bstArr.insert(80);

        bstArr.traverse();
        bstArr.traverseBFS();
        System.out.println();

        System.out.println("find 40: " + bstArr.find(40));
        System.out.println("find 25: " + bstArr.find(25));

        /*

        System.out.println("delete 20: ");
        bstArr.delete(20);
        bstArr.traverse();

        System.out.println("delete 30: ");
        bstArr.delete(30);
        bstArr.traverse();

        System.out.println("delete 70: ");
        bstArr.delete(70);
        bstArr.traverse();

        */


    

    }

}