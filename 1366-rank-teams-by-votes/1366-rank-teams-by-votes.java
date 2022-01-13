class Solution {
    public String rankTeams(String[] votes) {
        int numberOfTeams = votes[0].length();
        Map<Character, int[]> map = new HashMap<>();
        
        for(int i=0;i<votes.length;i++)
        {
            String ranking = votes[i];
            for(int j=0;j<numberOfTeams;j++)
            {
                char team = ranking.charAt(j);
                map.putIfAbsent(team, new int[numberOfTeams]);
                map.get(team)[j]++;
            }
        }
        
        List<Character> list = new ArrayList<>(map.keySet());
        
        list.sort((a,b)->{
           for(int i=0;i<numberOfTeams;i++) 
           {
               if(map.get(a)[i]!=map.get(b)[i])
                   return (map.get(b)[i]-map.get(a)[i]);
                   
                 
           }
              return a-b;
        });
        
        
        char[] ans = new char[numberOfTeams];
        
        for(int i=0;i<numberOfTeams;i++)
        {
            ans[i] = list.get(i);
        }
        return new String(ans);
        
    }
}