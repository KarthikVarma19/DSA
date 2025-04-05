class Solution {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        int ans = mergesort(nums, 0, n-1);
        return ans;
    }
    public int mergesort(int nums[], int low, int high){
        if(low >= high) return 0;
        int mid = (low + high) >>> 1;
        int ans = 0;
        ans += mergesort(nums, low, mid);
        ans += mergesort(nums, mid+1, high);
        ans += countpairs(nums, low, mid, high);
        merge(nums, low, mid, high);
        return ans;
    }
    public void merge(int nums[], int low, int mid, int high){
        int p1 = low;
        int p2 = mid + 1;
        int n = mid;
        int m = high;
        ArrayList<Integer> ans = new ArrayList<>();
        while(p1 <= n && p2 <= m){
            if(nums[p1] <= nums[p2]){
                ans.add(nums[p1++]);
            }else{
                ans.add(nums[p2++]);
            }
        }
        while(p1 <= n){
            ans.add(nums[p1++]);
        }
        while(p2 <= m){
            ans.add(nums[p2++]);
        }
        for(int i = 0; i < ans.size(); i++){
            nums[low+i] = ans.get(i);
        }
    }
    public int countpairs(int nums[], int low, int mid, int high){
        // you have two sorted array 
        int first = low;
        int n = mid;
        int second = mid + 1;
        int m = high;
        int count = 0;
        while(first <= n){
            if(second <= m && (nums[first] * 0.5) > (nums[second])){
                count += (n - first + 1);
                second++;
            }else{
                first++;
            }
        }
        return count;
    }
}