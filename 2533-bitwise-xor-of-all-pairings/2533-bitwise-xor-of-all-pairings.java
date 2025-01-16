class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int x = 0;
        int y = 0;

        int len1 = nums1.length;
        int len2 = nums2.length;

        if((len1%2 == 0) && (len1 == len2)) return 0;

        for (int i = 0; i < nums1.length; i++){
            x ^= nums1[i];
        }

        for( int i = 0; i < nums2.length; i++){
            y ^= nums2[i];
        }

        return (len1%2 * y) ^ (len2%2 * x);
    }
}