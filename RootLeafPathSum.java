public class RootLeafPathSum {
    Node root;

    public boolean haspathSum(Node root, int sum) {
        if(root == null)
            return false;

        sum -= root.data;
        if(sum == 0)
            return true;

        return haspathSum(root.left, sum) || haspathSum(root.right, sum);
    }

    public static void main(String args[])
    {
        int sum = 21;

        /* Constructed binary tree is
	             10
	            /  \
	           8     2
	          / \   /
	         3   5 2
        */
        RootLeafPathSum tree = new RootLeafPathSum();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(2);

        if (tree.haspathSum(tree.root, sum))
            System.out.println("There is a root to leaf path with sum " + sum);
        else
            System.out.println("There is no root to leaf path with sum " + sum);
    }
}
