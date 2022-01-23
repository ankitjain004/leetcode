class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        int digitInLowerRange = String.valueOf(low).length();
        int digitInHigherRange = String.valueOf(high).length();
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int numDigits = digitInLowerRange; numDigits<=digitInHigherRange; numDigits++)
        {
            for(int i=1;i<=9-numDigits+1;i++)
            {
                int number = 0;
                for(int j=i; j<i+numDigits;j++)
                {
                    number = number * 10 + j;
 
                }
                if(number>=low && number<=high)
                {
                    ans.add(number);
                }                   
            }
        }
        
        
        return ans;
        
                
        
    }
}