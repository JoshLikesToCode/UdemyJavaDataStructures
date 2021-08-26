package Trees;

import java.sql.SQLOutput;

public class TreeApp {
    public static void main(String[] args) {
        /* Traversals:
                - Level : visit nodes on each level
                - Pre-Order: visit the root of every subtree first
                - Post-Order: visit the root of every subtree last
                - In-order: visit left child, then root, then right child
         */
        Tree intTree = new Tree();
        intTree.insert(25);
        intTree.insert(20);
        intTree.insert(15);
        intTree.insert(27);
        intTree.insert(30);
        intTree.insert(29);
        intTree.insert(26);
        intTree.insert(22);
        intTree.insert(32);
        /* this will traverse the tree in a sorted order */
        intTree.traverseInOrder();
        /* lets look for nodes now */
        System.out.println();
        System.out.println(intTree.get(27));
        System.out.println(intTree.get(15));
        System.out.println(intTree.get(888));
        System.out.println("Max Tree Value: " + intTree.max());
        System.out.println("Min Tree Value: " + intTree.min());
    }
}
