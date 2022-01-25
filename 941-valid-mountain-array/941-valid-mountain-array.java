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
        
        if(i==n) return false;
        if(!isIncreased) return false;
        
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