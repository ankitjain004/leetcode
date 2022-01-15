class Job
{
    int start;
    int end;
    int profit;
}
    


class Solution {
    int[] memo = new int[50001];
    int maxProfit = 0;
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        Arrays.fill(memo, -1);

        int n = startTime.length;
        Job[] job = new Job[n];
        
        for(int i=0;i<n;i++)
        {
            job[i] = new Job();
            job[i].start = startTime[i];
            job[i].end = endTime[i];
            job[i].profit = profit[i];
        }
        
        Arrays.sort(job,(a, b) -> a.start - b.start);
                for(int i=0;i<n;i++)
        {
            startTime[i] = job[i].start;
        }
        return jobSchedulingUtil(0,job,startTime,0);
    }
    
    public int jobSchedulingUtil(int index, Job[] jobs,int[] start, int currProfit)
    {
        int n = jobs.length;
        if(index == -1 || index == n)
        {
            return 0;
        }
        
        if(memo[index]!=-1)
            return memo[index];
        
        
        int nextIndex = findNextJobIndex(index, jobs[index].end,start );
        
        int a = jobSchedulingUtil(index+1, jobs, start, currProfit);
        
        int b = jobSchedulingUtil(nextIndex, jobs,start, currProfit) +jobs[index].profit ;
        
        return memo[index]=Math.max(a,b);
    }
    
    
    public int findNextJobIndex(int index,int last, int[] start)
    {
        int n = start.length;
        int lo = index + 1;
        int hi = n-1;
        int ans = -1;
        while(lo<=hi)
        {
            int mid = lo + (hi-lo)/2;
            if(start[mid]>=last)
            {
                ans = mid;
                hi = mid-1;
            }
            
            else
            {
                lo = mid+1;
            }
        }
        
        return ans;
    }
}