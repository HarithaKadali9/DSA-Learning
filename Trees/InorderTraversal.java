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
class InorderTraversal {
    List<Integer> inorderPrint(TreeNode root, List<Integer> res){
        if(root==null) return res;
        inorderPrint(root.left, res);
        res.add(root.val);
        inorderPrint(root.right, res);
        return res;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        res=inorderPrint(root, res);
        return res;
    }
}