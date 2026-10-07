package BinaryTreeImplementation;


public class Main {
    public static void main(String[] args) {

        Tree t = new Tree();

        t.add(10);
        t.add(20);
        t.add(30);
        t.add(40);
        t.add(50);

        System.out.print("Preorder: ");
        t.preorder(t.root);

        System.out.print("\nInorder: ");
        t.inorder(t.root);

        System.out.print("\nPostorder: ");
        t.postorder(t.root);

        System.out.print("\nLevelorder: ");
        t.levelOrder();
    }
}
