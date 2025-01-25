class Solution {
    //Time Complexity:- O(n)for cloning+ O(nlogn)for sorting + O(n)dividing into groups + O(n)filling the array  => O(nlogn)
    //Space Complexity:- O(n)temp array for sorting + O(n)groups + O(n)hashmap + O(n) answer array => O(n)
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        //Create a New Array
        int temp[] = nums.clone();
        //Sort the Array 
        Arrays.sort(temp);
        //List of Groups 
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        //Hashing value to a group
        HashMap<Integer,ArrayList<Integer>> hm = new HashMap<>();
        //Iterating Over Sorted Array and Seggregating to a groups
        for(int i = 0; i < n; i++){
            if(al.size() == 0 || Math.abs(al.get(al.size()-1).get(al.get(al.size()-1).size()-1) - temp[i]) > limit){
                al.add(new ArrayList<Integer>());
            }
            ArrayList<Integer> gp1 = al.get(al.size()-1);
            gp1.add(temp[i]);
            hm.putIfAbsent(temp[i], gp1);
        }
        //Filling in a new Array 
        int ans[] = new int[n];
        for(int i = 0; i < n; i++){
            ArrayList<Integer> group = hm.get(nums[i]);
            int peak = group.remove(0);
            ans[i] = peak;
        }
        return ans;
    }
}