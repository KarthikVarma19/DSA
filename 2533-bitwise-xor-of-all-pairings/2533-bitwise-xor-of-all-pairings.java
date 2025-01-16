class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int ans = 0;

        int len1 = nums1.length;
        int len2 = nums2.length;

        if(len2%2 == 1){
            for (int i = 0; i < nums1.length; i++){
                ans ^= nums1[i];
            }            
        }
        if(len1%2 == 1){
            for( int i = 0; i < nums2.length; i++){
                ans ^= nums2[i];
            }
        }
        return ans;
    }
}