package Trees;

/*  if we come to insert a node, if the tree is empty the node becomes the root
    and we're done. If it isn't empty, then we're going to compare the value to the
    the root note and we're going to go left if it's less than and right if it's
    greater than. */

public class Tree {
    /* root node, think the HEAD of the linked list */
    private TreeNode root;

    /* tree class insert, this is what's actually being called by main */
    public void insert(int value)
    {
        /* we ALWAYS insert into first empty node found,
        if root is null then root is the first empty node found*/
        if(root == null)
        {
            root = new TreeNode(value);
        }
        else
        {
            /* we need to compare our TreeNode with the others using
               TreeNode's insert method. */
            root.insert(value);
        }

    }

    public void delete(int value)
    {
        /* recursive method */
        root = delete(root, value);
    }

    /* recursive delete method, private b/c only used within class */
    private TreeNode delete(TreeNode subtreeRoot, int value) {
        /* tree is empty */
        if (subtreeRoot == null)
            return subtreeRoot; /* returns null */
        /* we need to find the value we want to delete */
        if (value < subtreeRoot.getData()) {
            /* search left subtree */
            subtreeRoot.setLeftChild(delete(subtreeRoot.getLeftChild(), value));
        } else if (value > subtreeRoot.getData())
        {
            /* same as above but go right */
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), value));
        }
        else    /* the node we want to delete IS the subtree root */
        {
            // Cases where node to delete has 1 or 2 child(ren)
            if(subtreeRoot.getLeftChild() == null)
            {
                return subtreeRoot.getRightChild();
            }
            else if(subtreeRoot.getRightChild() == null)
            {
                return subtreeRoot.getRightChild();
            }

            // Case 3: node to delete has 2 children

            /* Replace the value in the subtreeRoot node with the smallest
                value from the right subtree */
            subtreeRoot.setData(subtreeRoot.getRightChild().min());
            /* Delete the node that has the smallest value in the right subtree */
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), subtreeRoot.getData()));
        }
        return subtreeRoot;
    }

    public void traverseInOrder()
    {
        if(root != null)
            root.traverseInOrder();
    }

    public TreeNode get(int value)
    {
        /* use TreeNode's get() method to find value */
        if(root != null)
        {
            return root.get(value);
        }
        /* value not found, return null */
        return null;
    }

    /* use TreeNode to check on root */
    public int min()
    {
        if (root == null)
        {
            /* if this is an empty tree, we show this by returning the absolute
                smallest value that is accepted by an int */
            return Integer.MIN_VALUE;
        }
        else
        {
            return root.min();
        }
    }

    public int max()
    {
        if(root == null)
        {
            return Integer.MAX_VALUE;
        }
        else
        {
            return root.max();
        }
    }
}
