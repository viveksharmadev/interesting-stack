// https://leetcode.com/problems/valid-parenthesis-string/
class valid-parenthesis-string {
    // tc -> n, sc-> n
    public boolean checkValidString(String s) {
        Stack<Integer> starStack = new Stack<>();
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else if(s.charAt(i)=='*'){
                starStack.push(i);
            }else{
                if(stack.isEmpty() && starStack.isEmpty())
                    return false;
                if(!stack.isEmpty()) stack.pop();
                else starStack.pop();
            }
        }
        
        while(!stack.isEmpty() && !starStack.isEmpty()){
            if(stack.pop() > starStack.pop()) return false;            
        }
        
        return stack.isEmpty();
    }
    
    // tc -> n, sc-> 1
    public boolean checkValidString(String s) {
        int min = 0, max = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                min++;
                max++;
            }else if(s.charAt(i)==')'){
                min--;
                max--;
                min = Math.max(min, 0);
            }else{
                max++;
                min--;
                min = Math.max(min, 0);
            }
            if(max < 0) return false;
        }
        
        return min==0;
}
