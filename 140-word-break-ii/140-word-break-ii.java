class Solution {
    Set<String> wordSet;
    Map<String, List<List<String>>> memo = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        wordSet = new HashSet<>(wordDict);
        
        wordbreak_topdown(s);
        
        List<String> answer = new ArrayList<>();
        
        for(List<String> solution : memo.get(s))
        {
            StringBuffer sb = new StringBuffer();
            for(String str : solution)
            {
                sb.insert(0, str);
                sb.insert(0, " ");
            }
            
            answer.add(sb.toString().strip());
            
        }
        
        return answer;
        
    }
    
    
    public List<List<String>> wordbreak_topdown(String s)
    {
        List<List<String>> list = new ArrayList<List<String>>();
        if(s.equals(""))
        {
            list.add(new ArrayList<>());
            return list;
        }
        
        if(memo.containsKey(s))
            return memo.get(s);

        for(int i=1;i<=s.length();i++)
        {
            String str = s.substring(0,i);
            //necessary else at the end of this method .get will return null whereas it should return empty
            memo.putIfAbsent(s, list);
            if(wordSet.contains(str))
            {
                List<List<String>> subList = wordbreak_topdown(s.substring(i));
                for(List<String> substr: subList)
                {
                    List<String> answer = new ArrayList<String>();
                    answer.addAll(substr);
                    answer.add(str);
                    memo.get(s).add(answer);
                }
                
            }
        }
        
        return memo.get(s);
    }
}