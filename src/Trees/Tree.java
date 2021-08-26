package Trees;

public class Tree {
    /* root node, think the HEAD of the linked list */
    private TreeNode root;

    /*  if we come to insert a node, if the tree is empty the node becomes the root
        and we're done. If it isn't empty, then we're going to compare the value to the
        the root note and we're going to go left if it's less than and right if it's
        greater than. */


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
