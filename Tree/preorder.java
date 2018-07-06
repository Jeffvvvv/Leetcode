public class Solution
{
     //recursion
    public List<Integer> recursionPreorder(TreeNode root)
    {
        List<Integer> list = new ArrayList<Integer>();
        helper(list, root);
        return list;
    }
    
    public void helper(List<Integer> list, TreeNode root)
    {
        if(root == null)
            return;
        
        list.add(root.val);
        helper(list, root.left);
        helper(list, root.right);
    }
  
    //iteration
    public List<Integer> iterationPreorder(TreeNode root)
    {
        if(root == null)
            return new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(root);
        
        while(!stack.isEmpty())
        {
            TreeNode p = stack.pop();
            list.add(p.val);
          
            if(p.right != null)
                stack.push(p.right);
            
            if(p.left != null)
                stack.push(p.left);
        }
        return list;
    }
}
