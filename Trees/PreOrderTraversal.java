/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class PreOrderTraversal {
    private static void printPreorder(TreeNode root, List<Integer> res){
        if(root==null) return;
        res.add(root.val);
        printPreorder(root.left, res);
        printPreorder(root.right, res);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        printPreorder(root, res);
        return res;
    }
}