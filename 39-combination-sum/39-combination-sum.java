class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> temp = new ArrayList<>();
        combinationSumUtils(candidates, 0, target, temp);
        return answer;
    }
    
    public void combinationSumUtils(int[] candidates, int index, int target, List<Integer> temp)
    {
        
        if(index>=candidates.length)
            return;
        
        if(target<0)
            return;
        
        if(target==0)
        {
            answer.add(new ArrayList(temp));
            return;
        }
        
        // exclude
        combinationSumUtils(candidates, index+1 , target, temp);
        // include
        temp.add(candidates[index]);
        combinationSumUtils(candidates, index , target - candidates[index], temp);
        temp.remove(temp.size()-1);
        
        
        
    }
}