class Solution {
    private boolean isValidTriangle(int a, int b, int c){
        if(((a+b)>c) && ((b+c)>a) && (c+a)>b){
            return true;
        } 
        return false;
    }
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int len = nums.length;
        for(int i = 0; i < len-2; i++){
            for(int j = i + 1; j < len-1; j++){
                for(int k = j + 1; k < len; k++){
                    if(isValidTriangle(nums[i],nums[j],nums[k]) == true){
                        count++;
                    }
                    else{
                        break;
                    }
                }
            }
        }
        return count;
    }
}