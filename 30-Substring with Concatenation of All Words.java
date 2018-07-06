Leetcode 30 

Tag: HashMap

Solutions:
用一个HashMap把words里面的每一个字符串作为key存起来，并附上相应的个数作为value值。
从字符串s的第一个char开始遍历，长度是0到s.length()-n*m，把所有满足条件的index加到结果里。

Use HashMap to store every string of the array words as the key, and set correspoding number of this string as its value.
Define two integer variables m and n. m represents the the length of the words, n represents the length of every string element of the arrary words.
Traverse the target string s from index 0 to s.length()-n*m, if index satisfy the requirement, add the index into the result list.


Source Code:

public List<Integer> findSubstring(String s, String[] words) {
        if(s==null||s.length()==0||words.length==0||words[0].length()==0) return new ArrayList<Integer>();
        int n = words.length;
        int m = words[0].length();
        List<Integer> res = new ArrayList<Integer>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(String str:words)
        {
            map.put(str, map.getOrDefault(str, 0)+1);
        }
        for(int i=0;i<=s.length()-n*m;i++)
        {
            HashMap<String, Integer> wordmap = new HashMap<String, Integer>(map);
            int k = n;
            int j = i;
            while(k>0)
            {
                String temp = s.substring(j, j+m);
                if(!wordmap.containsKey(temp)||wordmap.get(temp)==0)
                {
                    break;
                }
                wordmap.put(temp, wordmap.get(temp)-1);
                k -= 1;
                j += m;
            }
            if(k==0) res.add(i);
        }  
        return res;
  }
