class Solution {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        int tuples = 0;
        HashMap<Long,Integer> hm = new HashMap<>();
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                long prod = nums[i] * nums[j];
                hm.put(prod, hm.getOrDefault(prod, 0) + 1);
            }
        }
        for(long key: hm.keySet()){
            if(hm.get(key) >= 2){
                int count = hm.get(key);
                tuples += ((count) * (count-1))  * 4;
            }
        }
        return tuples;
    }
}