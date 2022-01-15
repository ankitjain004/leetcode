class Solution {
    private static final int  MOD = 1000000007;
    public int countVowelPermutation(int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        if(n==0) return 0;
        if(n==1) return 5;
        map.put('a',1);
        map.put('e',1);
        map.put('i',1);
        map.put('o',1);
        map.put('u',1);
        int a[] = new int[5];
        for(int i=2;i<=n;i++)
        {
            a[0] = ((map.get('e') + map.get('i'))%MOD + map.get('u'))%MOD;
            a[1] = (map.get('a') + map.get('i'))%MOD;
            a[2] = (map.get('e') + map.get('o'))%MOD;
            a[3] = (map.get('i') )%MOD;
            a[4] = (map.get('o') + map.get('i') )%MOD;
            
            map.put('a',a[0]);
            map.put('e',a[1]);
            map.put('i',a[2]);
            map.put('o',a[3]);
            map.put('u',a[4]);
        
        }
        
        int sum =0;
        for(int i=0;i<5;i++)
        {
            sum = (sum+a[i])%MOD;
        }
        return sum;
        
    }
}