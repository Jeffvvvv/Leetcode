//Time complexity: O(nlog(k))
//recommend to use 优先队列（array同理）
//也可用分治，但不推荐，这里两个方法都写
//MergeSort有一个简便写法和一个常规写法
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        //test boundary cases
        if(lists==null||lists.length==0) return null;
        return sort(lists, 0, lists.length-1);
    }
    
    public ListNode sort(ListNode[] lists, int low, int high)
    {
        //Important here: boundary case, otherwise will show stackoverflowerror
        if(low==high) return lists[low];
        if(low>high) return null;
        int middle = low + (high-low)/2;
        ListNode l1 = sort(lists, low, middle);
        ListNode l2 = sort(lists, middle+1, high);
        return merge(l1, l2);
    }
    
    simple way for merge: recursion
    public ListNode merge(ListNode l1, ListNode l2)
    {
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<l2.val)
        {
            l1.next = merge(l1.next,l2);
            return l1;
        }
        l2.next = merge(l1, l2.next);
        return l2;
    }
    
    general way
    public ListNode merge(ListNode l1, ListNode l2)
    {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode p = (l1.val<l2.val)?new ListNode(l1.val):new ListNode(l2.val);
        ListNode node = p;
        if(l1.val<l2.val)
        {
            l1 = l1.next;
        }
        else
        {
            l2 = l2.next;
        }
        
        while(l1!=null&&l2!=null)
        {
            if(l1.val<l2.val)
            {
                node.next = l1;
                l1 = l1.next;
            }
            else
            {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        
        while(l1!=null)
        {
            node.next = l1;
            node = node.next;
            l1 = l1.next;
        }
        
        while(l2!=null)
        {
            node.next = l2;
            node = node.next;
            l2 = l2.next;
        }
        
        return p;
    }
    
    //priority queue
    public ListNode mergeKLists(ListNode[] lists) {
        //test boundary cases
        if(lists==null||lists.length==0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, (a,b) -> a.val-b.val);
        ListNode res = new ListNode(0);
        ListNode cur = res;
        for(ListNode list:lists)
        {
            if(list!=null)
            {
                queue.add(list);
            }
        }
        
        while(!queue.isEmpty())
        {
            cur.next = queue.poll();
            cur = cur.next;
            if(cur.next!=null)
            {
                queue.add(cur.next);
            }
        }
        
        return res.next;
    }
    
}
