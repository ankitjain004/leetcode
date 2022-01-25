class Solution {
    public boolean validMountainArray(int[] a) {
        
        int n = a.length;
        if(n<3) return false;
        int i=1;
        boolean isIncreased = false;
        while(i<n)
        {
            if(a[i-1]<a[i]) 
            {
                isIncreased = true;
                i++;
                continue;
            }
            else
            {
                break;
            }
        }
        
        if(i==n) return false; // 0 1 2 3 4 5 6 7 8 9
        if(!isIncreased) return false; //9 8 7 6 5 4 3 2 1 0
        
        while(i<n)
        {
            if(a[i-1]>a[i])
            {
                i++;
                continue;
            }
            else
            {
                return false;
            }
        }
        
        return true;
    }
}