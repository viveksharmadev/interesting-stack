// https://leetcode.com/problems/next-greater-element-i/
class next-greater-element-i {
    // tc -> n, sc-> n
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums2){
            while(!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            stack.push(num);
        }
        
        int[] res = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            res[i] = map.getOrDefault(nums1[i],-1); 
        }
        
        return res;
    }
}

// Without taking result array
class Solution {
    // tc -> n, sc-> 1
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<nums2.length; i++){
            
            while(!stack.isEmpty() && stack.peek() < nums2[i]){
                map.put(stack.pop(), nums2[i]);
            }
            
            stack.push(nums2[i]);
        }
        
        for(int i=0; i<nums1.length; i++){
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        
        return nums1;
    }
}
