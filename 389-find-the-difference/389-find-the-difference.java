class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] charArr = s.toCharArray();
        for(Character ch: charArr)
        {
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        
        charArr = t.toCharArray();
        for(Character ch: charArr)
        {
            if(!map.containsKey(ch))
                return ch;
            int count = map.get(ch);
            if(count==0) return ch;
            map.put(ch, count-1);
        }
        
        return 'a';
    }
}