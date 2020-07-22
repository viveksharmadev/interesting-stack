// https://leetcode.com/problems/next-greater-element-ii/
class next-greater-element-ii {
    // tc -> n, sc-> n
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n*2; i++){
            int num = nums[i%n];
            while(!stack.isEmpty() && nums[stack.peek()] < num)
                res[stack.pop()] = num;
            if(i<n) stack.push(i);
        }
        return res;
    }
}
