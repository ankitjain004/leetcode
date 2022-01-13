class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
                stk.push(currentChar);
            } else {
                if (stk.isEmpty()) return false;
                char peekStack = stk.peek();
                if (currentChar == ')' && peekStack == '(' ||
                        currentChar == '}' && peekStack == '{' ||
                        currentChar == ']' && peekStack == '['
                )
                    stk.pop();
                else {
                    return false;
                }
            }

        }

        return stk.isEmpty();

    }
}