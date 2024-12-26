class Solution {
    public boolean checkIfExist(int[] arr) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            hm.put(arr[i],i);
        }
        for(int i=0;i<arr.length;i++){
            int num = arr[i];
            if(hm.containsKey(2 * num) && i != hm.get(2 * num)){
                return true;
            }
            if(num == 0 && hm.get(num) > 1){
                return true;
            }
        }
        return false;
    }
}