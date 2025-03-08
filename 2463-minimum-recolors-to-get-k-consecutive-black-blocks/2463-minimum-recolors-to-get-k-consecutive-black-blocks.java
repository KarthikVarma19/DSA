class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int left = 0, numWhites = 0;
        int mini = k;
        for(int right = 0; right < n; right++){
            if(blocks.charAt(right) == 'W'){
                numWhites++;
            }
            if((right - left + 1) == k){
                mini = Math.min(numWhites, mini);
                if(blocks.charAt(left) == 'W'){
                    numWhites--;
                }
                left++;
            }
        }
        return mini;
    }
}