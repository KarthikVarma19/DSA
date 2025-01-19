class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);
        int len = 1;
        for(int i = 1; i < nums.length; i++) {
            int num = nums[i];

            if(num > temp.get(temp.size()-1)){
                temp.add(num);
                len++;
            }
            else{
                int pos = Collections.binarySearch(temp, num);
                if(pos < 0){
                    pos = -pos-1;
                }
                temp.set(pos, num);
            }
        }
        return temp.size();
    }
}