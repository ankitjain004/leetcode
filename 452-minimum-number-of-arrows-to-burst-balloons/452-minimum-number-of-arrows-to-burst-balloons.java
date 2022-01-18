class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length==0) return 0;
        Arrays.sort(points, (a,b)-> {
            return a[0]-b[0];
        });
        
        Stack<Pair<Integer, Integer>> stk = new Stack<>();
        
        stk.push(new Pair<Integer, Integer>(points[0][0],points[0][1]));
        for(int i=1;i<points.length;i++)
        {
            if(stk.isEmpty()) break;
            Pair<Integer, Integer> pair = stk.peek();
            if(isOverLapping(pair, points[i]))
            {
                stk.pop();
                int start = Math.min(pair.getKey(), points[i][0]);
                int end = Math.min(pair.getValue(), points[i][1]);
                stk.push(new Pair<Integer, Integer>(start, end));
                
            }
            else
            {
                stk.push(new Pair<Integer, Integer>(points[i][0],points[i][1]));
            }
        }
        
        return stk.size();
    }
    
    public boolean isOverLapping(Pair<Integer,Integer> pair, int[] a)
    {
        if(pair.getKey()<=a[0] && a[0]<=pair.getValue())
            return true;
        return false;
    }
}