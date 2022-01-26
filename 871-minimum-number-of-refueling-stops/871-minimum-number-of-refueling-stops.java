class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {

        PriorityQueue<Integer> fuel = new PriorityQueue<>(Collections.reverseOrder());
        if(startFuel>=target) return 0;
        if(stations.length==0 && startFuel<target) return -1;
        int stops =0;
        int currPos = 0;
        int i=0;
        while(i<stations.length && currPos<target)
        {
            int[] curr = stations[i];
            
            if(curr[0]-currPos<=startFuel)
            {
                startFuel = startFuel - (curr[0]-currPos);
                currPos = curr[0];
                fuel.add(curr[1]);
                i++;
            }
            else
            {
                if(fuel.isEmpty()) return -1;
               else
                {
                    startFuel = startFuel + fuel.poll();
                    stops = stops + 1;
                }
            }
            
        }
        
        if(startFuel>0)
        {
            currPos += startFuel;
        }
        
        while(currPos<target)
        {
            if(fuel.isEmpty()) return -1;
            currPos = currPos + fuel.poll();
            stops++;
        }
        
        
        
        
        return stops;
        
        
    }
}