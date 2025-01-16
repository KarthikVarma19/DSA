class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int ans = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;

        for (int i = 0; i < nums1.length; i++){
            if(len2%2 == 1){
                ans = ans ^ nums1[i];
            }
        }

        for( int i = 0; i < nums2.length; i++){
            if(len1%2 == 1){
                ans = ans ^ nums2[i];
            }
        }

        return ans;
    }
}