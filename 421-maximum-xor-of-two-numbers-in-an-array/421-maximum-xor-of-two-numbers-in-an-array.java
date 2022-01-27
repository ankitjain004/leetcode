class TrieNode{
    HashMap<Character, TrieNode> children = new HashMap<>();
    public TrieNode(){}
}

class Solution {
    public int findMaximumXOR(int[] nums) {
        int maxNum = nums[0];
        for(int i=1;i<nums.length;i++)
        {
            maxNum = Math.max(maxNum, nums[i]);
        }
        
        int L = Integer.toBinaryString(maxNum).length();
        // zero left-padding to ensure L bits for each number
        // if L =5 111 will be converted to 00111
        int n = nums.length, bitmask = 1<<L;
        String[] strNums = new String[n];
        for(int i=0;i<n;i++){
            strNums[i] = Integer.toBinaryString(nums[i] | bitmask).substring(1);
        }
        
        TrieNode trie = new TrieNode();
        int maxXor = 0;
        
        for(String num :strNums){
            TrieNode node = trie, xorNode = trie;
            int currXor = 0;
            for(Character bit : num.toCharArray())
            {
                //insert new number in trie
                if(node.children.containsKey(bit)){
                    node = node.children.get(bit);
                }
                else
                {
                    node.children.put(bit, new TrieNode());
                    node = node.children.get(bit);
                }
                //compute  maxXor of the new number
                Character toggledBit = bit=='1'?'0':'1';
                
                
                if(xorNode.children.containsKey(toggledBit))
                {
                    currXor = (currXor<<1) |1 ;
                    xorNode = xorNode.children.get(toggledBit);
                }
                else
                {
                    currXor = currXor << 1;
                    xorNode = xorNode.children.get(bit);
                }
                
            }
            
            maxXor = Math.max(maxXor, currXor);
            
        }
        
        return maxXor;
        
        
    }
}