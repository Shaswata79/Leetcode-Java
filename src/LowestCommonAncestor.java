public class LowestCommonAncestor {

    private static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return containsDescendant(root, p, q);
    }

    private TreeNode containsDescendant(TreeNode root, TreeNode p, TreeNode q){

        if((root.left == p && root.right == q) || (root.left == q && root.right == p)){
            return root;
        }
        else if((root == p && root.right == q) || (root == p && root.left == q) || (root == q && root.right == p) || (root == q && root.left == p)){
            return root;
        }
        else if((root == p && containsSingleDescendant(root.left, q)) || (root == p && containsSingleDescendant(root.right, q)) || (root == q && containsSingleDescendant(root.left, p)) || (root == q && containsSingleDescendant(root.right, p))){
            return root;
        }else if(containsSingleDescendant(root.left, q) && containsSingleDescendant(root.right, p) || containsSingleDescendant(root.left, p) && containsSingleDescendant(root.right, q)){
            return root;
        }
        else {
            if(root.left != null){
                TreeNode left = containsDescendant(root.left, p, q);
                if(left != null){
                    return left;
                }
            }
            if(root.right != null){
                TreeNode right = containsDescendant(root.right, p, q);
                if(right != null){
                    return right;
                }
            }
            return null;
        }
    }

    private boolean containsSingleDescendant(TreeNode root, TreeNode x){
        if(root == null){
            return false;
        }
        if(root == x){
            return true;
        }
        if((root.left != null && root.left == x) || (root.right != null && root.right == x)){
            return true;
        }else{
            if(root.right != null){
                if(containsSingleDescendant(root.right, x)){
                    return true;
                }
            }
            if(root.left != null){
                if(containsSingleDescendant(root.left, x)){
                    return true;
                }
            }
            return false;
        }
    }
}
