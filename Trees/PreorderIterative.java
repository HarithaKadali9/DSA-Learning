class PreorderIterative {
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;
        Stack<TreeNode> st=new Stack<TreeNode>();
        st.push(root);
        while(!st.isEmpty()){
            root=st.pop();
            res.add(root.val);
            if(root.right!=null) st.push(root.right);
            if(root.left!=null) st.push(root.left);
            
        }
        return res;
    }
}
