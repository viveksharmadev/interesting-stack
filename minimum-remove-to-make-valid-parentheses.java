//https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/

class Solution {
    // tc -> n, sc-> n
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        
        boolean[] visited = new boolean[s.length()];
        
        for(int i=0; i<s.length(); i++){
            
            if(s.charAt(i)=='('){
                stack.push(i);
            }
            
            else if(s.charAt(i)==')'){
                if(!stack.isEmpty()){
                    
                    visited[i] = true;
                    
                    visited[stack.pop()] = true;
                }
            }
            
            else{
                visited[i] = true;
            }
        }
        
        
        StringBuilder result = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            
            if(visited[i]) 
            result.append(s.charAt(i));
            
        }
        
        return result.toString();
    }
}
