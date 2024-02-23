public class BalancedBinaryTree {

    private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    public static boolean isBalanced(TreeNode root) {
        int rightDepth = 0;
        int leftDepth = 0;

        if(root == null){
            return true;
        }

        if(root.left != null){
            int depth = depth(root.left);
            if(depth == -1){
                return false;
            }
            leftDepth = 1 + depth;
        }
        if(root.right != null){
            int depth = depth(root.right);
            if(depth == -1){
                return false;
            }
            rightDepth = 1 + depth;
        }

        if(Math.abs(rightDepth - leftDepth) <= 1){
            return true;
        }else {
            return false;
        }
    }

    private static int depth(TreeNode node){
        int rightDepth = 0;
        int leftDepth = 0;

        if(node.left != null){
            int depth = depth(node.left);
            if(depth == -1){
                return -1;
            }
            leftDepth = 1 + depth;
        }
        if(node.right != null){
            int depth = depth(node.right);
            if(depth == -1){
                return -1;
            }
            rightDepth = 1 + depth;
        }

        if(Math.abs(rightDepth - leftDepth) <= 1){
            if(rightDepth > leftDepth){
                return rightDepth;
            }else {
                return leftDepth;
            }
        }else {
            return -1;
        }
    }

}
