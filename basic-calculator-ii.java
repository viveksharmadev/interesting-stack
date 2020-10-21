// https://leetcode.com/problems/basic-calculator-ii/
class Solution {
    // tc -> n, sc-> n
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        
        char sign = '+';
        int num = 0;
        
        for(int i=0; i<s.length(); i++){
            
            char c = s.charAt(i);
            
            if(Character.isDigit(c))
               num = num*10 + c-'0';
            
            if((!Character.isDigit(c) && c != ' ')
               || i==s.length()-1){
                
                if(sign == '+'){
                    stack.push(num);
                }
                
                else if(sign == '-'){
                    stack.push(-num);
                }
                
                else if(sign == '*'){
                    stack.push(stack.pop()*num);
                }
                
                else if(sign == '/'){
                    stack.push(stack.pop()/num);
                }
                
                sign = s.charAt(i);
                num = 0;
            }
        }
        
        int result = 0;
        
        for(int val : stack)
            result += val;
        
        return result;
    }
}

// Without Stack (Need to handle edge case properly)

class Solution {
    // tc -> n, sc-> 1
    public int calculate(String s) {
        char sign = '+';
        
        int sum = 0;
        int tempSum = 0;
        int num = 0;
        
        for(int i=0; i<s.length(); i++){      
            
            char c = s.charAt(i);
            
            if(Character.isDigit(c))
                num = num*10 + c-'0';
            
            if(!Character.isDigit(c) && c!=' ' || i==s.length()-1){
                if(sign == '+'){
                    sum += tempSum;
                    tempSum = num;
                }
                
                else if(sign == '-'){
                    sum += tempSum; // to handle "1-1"
                    tempSum = -num;
                }
                
                else if(sign == '*'){
                    tempSum *= num;
                }
                
                else if(sign == '/'){
                    tempSum /= num;
                }
                
                num = 0;
                sign = s.charAt(i);
            }
        }
        
        return tempSum + sum;
    }
}
