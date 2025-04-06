class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        // i want n1 to be minimum length array 
        if(n1 > n2) return findMedianSortedArrays(nums2, nums1);
        
        int n = n1 + n2;
        int low = 0, high = n1;
        // handling both odd and even length in same condition 
        int left = (n1 + n2 + 1)/2;
        while(low <= high){
            int mid1 = (low + high) >>> 1;
            int mid2 = left - mid1;
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            if(mid1-1 >= 0) l1 = nums1[mid1-1];
            if(mid2-1 >= 0) l2 = nums2[mid2-1];
            if(mid1 < n1) r1 = nums1[mid1];
            if(mid2 < n2) r2 = nums2[mid2];
            // got our medians
            if(l1 <= r2 && l2 <= r1){
                // even length array
                if(n%2 == 1){
                    return Math.max(l1, l2);
                }
                return (double)((double)Math.max(l1, l2) + (double)Math.min(r1, r2))/2.0;
            }else if(l1 > r2){
                high = mid1-1;
            }else{
                low = mid1+1;
            }
        }
        return 0.0;
    }
}