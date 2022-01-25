class Solution {
    public int lengthOfLastWord(String s) {
        String[] word = s.trim().split(" ");
        int n = word.length;
        
        return word[n-1].length();
    }
}