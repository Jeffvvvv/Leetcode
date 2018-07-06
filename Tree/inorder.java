public class Solution
{
    //recursion 
    public List<Integer> inorder(TreeNode root) 
    {
        List<Integer> list = new ArrayList<Integer>();
        helper(list, root);
        return list;
    }
  
    public List<Integer> helper(List<Integer> list, TreeNode root)
    {        
        if(root == null)
            return;
        helper(list, root.left);
        list.add(root.val);
        helper(list, root.right);
    }
  
    
    //iteration
    public List<Integer> inorder(TreeNode root)
    {
        if(root == null)
            return new ArrayList<Integer>();
      
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
      
        TreeNode p = root;
        while(p != null || !stack.isEmpty())
        {
            if(p != null)
            {
                stack.push(p);
                p = p.left;
            }
            else
            {
                p = stack.pop();
                list.add(p.val);
                p = p.right;
            }
        }
        return list;
    }
}
