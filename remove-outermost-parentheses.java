// https://leetcode.com/problems/remove-outermost-parentheses/
class Solution {
    // tc -> n, sc-> n
    public String removeOuterParentheses(String S) {
        int open = 0;
        
        StringBuilder result = new StringBuilder();
        
        for(int i=0; i<S.length(); i++){
                       
            if(S.charAt(i)=='(' && open++ > 0){
                result.append("(");
            }else if(S.charAt(i)==')' && open-- > 1){
                result.append(")");            
            }
            
        }
        
        return result.toString();
    }
}
