class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String temp[] = new String[n];
        for(int i = 0; i < n; i++){
            temp[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(temp, (a,b) -> ((b+a).compareTo(a+b)));
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(temp[i]);
            if(i == 0 && sb.charAt(0) == '0') return "0";
        }
        String ans = sb.toString();
        return ans;
    }
}