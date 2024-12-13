class Solution {
    class pair{
        int val;
        int ind;
        pair(int val, int ind){
            this.val = val;
            this.ind = ind;
        }
    }
    public long findScore(int[] nums) {
        int marked[] = new int[nums.length];
        PriorityQueue<pair> mh = new PriorityQueue<>(new Comparator<pair>(){
            @Override
            public int compare(pair a,pair b){
                if(a.val == b.val){
                    return a.ind - b.ind;
                }
                return a.val-b.val;
            }
        });
        for(int i=0;i<nums.length;i++){
            mh.add(new pair(nums[i],i));
        }
        long score = 0;
        while(!mh.isEmpty()){
            int minVal = mh.peek().val, minInd = mh.peek().ind;
            mh.remove();
            if(marked[minInd] == 1) continue;
            score += (long)minVal;
            markAdjs(marked,minInd);
        }
        return score;
    }
    public void markAdjs(int marked[], int index){
        if(index-1 >=0){
            marked[index-1] = 1;
        }
        if(index + 1 < marked.length){
            marked[index+1] = 1;
        }
        marked[index] = 1;
    }
}