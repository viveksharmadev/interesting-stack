// https://leetcode.com/problems/make-the-string-great/
class Solution {
    // tc -> n, sc-> n
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(!stack.isEmpty() && Math.abs(c-stack.peek())==32)
                stack.pop();         
            else
                stack.push(s.charAt(i));
        }
        
        StringBuilder sb = new StringBuilder();
        for(char c : stack)
            sb.append(c+"");
        
        return sb.toString();
    }
}
