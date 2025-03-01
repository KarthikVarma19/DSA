class Solution {
    public int[] applyOperations(int[] nums) {
        //Applying the Given Operation
        int n = nums.length;
        for(int i = 0; i < n-1; i++){
            if(nums[i] == nums[i+1]){
                nums[i] *= 2;
                nums[i+1] = 0;
            }
        }
        //Move Zero's to the end
        int zp = 0, np = 0;
        while(zp < n && np < n){
            //find the first zero 
            while(zp < n && nums[zp] != 0){
                zp++;
            }
            //find the next non - zero number
            np = zp + 1;
            while(np < n && nums[np] == 0){
                np++;
            }
            //swap them
            if(zp < n && np < n){
                nums[zp] = nums[np];
                nums[np] = 0;
            }
            zp++;
        }
        return nums;
    }
}