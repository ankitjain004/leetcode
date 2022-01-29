class Solution {
    public int[] asteroidCollision(int[] nums) {
        int n = nums.length;
        if(n<2) return nums;
        Stack<Integer>  stack = new Stack<>();
        stack.push(nums[0]);
        int i=1;
        while(i<n)
        {
            int curr = nums[i];
            //case when collision
            // 5 -3
            if(!stack.isEmpty() && stack.peek()>0 && curr<0)
            {
                int stackTopAbsoluteValue = Math.abs(stack.peek());
                int currElementAbsoluteValue = Math.abs(curr);
                if(stackTopAbsoluteValue == currElementAbsoluteValue)
                {
                    stack.pop();
                    i++;
                }
                else if(stackTopAbsoluteValue<currElementAbsoluteValue)
                {
                    stack.pop();
                }
                else
                {
                    i++;
                }
            }
            else
            {
                stack.push(curr);
                i++;
            }
        }
        if(stack.size()==0) return new int[0];
        int ans[] = new int[stack.size()];
        for(int j=stack.size();j>=1;j--)
        {
            ans[j-1] = stack.pop();
        }
        return ans;
    }
}