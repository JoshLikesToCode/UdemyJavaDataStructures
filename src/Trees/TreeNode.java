package Trees;

/* This class holds our tree nodes */
public class TreeNode {
    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(int data)
    {
        this.data = data;
    }

    /* insert for TreeNode class */
    public void insert(int value)
    {
        /* duplicate values are not allowed */
        if(value == data)
            return;         /* we kick out duplicate values */

        /* if we make it this far, the value is either less
            than or greater than all other nodes in the tree */
        if(value < data)
        {
            /* check to see if there is a left child */
            if(leftChild == null)
            {
                /* if the leftChild is null, we insert here */
                leftChild = new TreeNode(value);
            }
            else    /* we need to keep going until we find a null left child to insert into */
            {
                leftChild.insert(value);
            }
        }
        else /* check if value is greater than data */
        {
            if(rightChild == null)
                rightChild = new TreeNode(value);
            else
                rightChild.insert(value);
        }
    }

    /* visit left child, visit root, then visit right child */
    public void traverseInOrder()
    {
        /* visit left child */
        if(leftChild != null)
        {
            leftChild.traverseInOrder();
        }

        System.out.print(data + ", ");
        /* visit right child */
        if(rightChild != null)
        {
            rightChild.traverseInOrder();
        }
    }

    /* look for a specific node */
    public TreeNode get(int value)
    {
        if(value == data)   /* this is the node we're looking for */
        {
            return this;    /* return this tree node */
        }

        if(value < data)
        {
            if(leftChild != null)   /* traverse left if node is bigger than value */
            {
                return leftChild.get(value);
            }
        }
        else
        {
            if(rightChild != null)  /* traverse right if node is lower than value */
            {
                return rightChild.get(value);
            }
        }
        /* we couldn't find the value we were looking for */
        return null;
    }

    /* find min value, we want an int returned */
    public int min()
    {
        /* start at root and travel down left edges */
        /* if this node doesn't have a left child, then THIS node is min value */
        if(leftChild == null)
        {
            return data;
        }
        else    /* keep traveling down left */
        {
            return leftChild.min();
        }
    }

    public int max()
    {
        if(rightChild == null)
        {
            return data;
        }
        else
        {
            return rightChild.max();
        }
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                '}';
    }
}
