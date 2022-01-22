class Solution {
    Map<Character, Integer> map = new HashMap<>();
    public int romanToInt(String s) {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int n = s.length();
        int number = 0;
        for(int i=0;i<n;i++)
        {
            char curr = s.charAt(i);
            number = number + map.get(curr);
            if(i>0)
            {
                //check if last digit was smaller
                int lastValue = map.get(s.charAt(i-1));
                if(lastValue<map.get(curr))
                {
                    number = number - 2*lastValue;
                }
            }
            
        }
        
        
        return number;
    }
}