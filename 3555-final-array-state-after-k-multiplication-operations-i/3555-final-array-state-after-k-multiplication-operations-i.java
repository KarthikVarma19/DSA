class Solution {
    class pair{
        int value;
        int index;
        pair(int value,int index){
            this.value = value;
            this.index = index;
        }
    }
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<pair> pq = new PriorityQueue<>(new Comparator<pair>(){
            @Override 
            public int compare(pair a, pair b){
                if(a.value == b.value){
                    return a.index-b.index;
                }
                return a.value-b.value;
            }
        });
        for(int i=0;i<nums.length;i++){
            pq.add(new pair(nums[i],i));
        }
        while(k-- > 0){
            int topValue = pq.peek().value, topIndex = pq.peek().index;
            pq.remove();
            nums[topIndex] = topValue * multiplier;
            pq.add(new pair(nums[topIndex],topIndex));
        }
        return nums;
    }
}