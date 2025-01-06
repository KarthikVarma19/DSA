class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int leftPrefix[] = new int[n];
        int leftCnt = 0;
        for(int i=0;i<n;i++){
            if(i>0){
                leftPrefix[i] = leftPrefix[i-1] + leftCnt;
            }
            if(boxes.charAt(i) == '1') leftCnt++;
        }
        int rightPrefix[] = new int[n];
        int rightCnt = 0;
        for(int i=n-1;i>=0;i--){
            if(i<n-1){
                rightPrefix[i] = rightPrefix[i+1] + rightCnt;
            }
            if(boxes.charAt(i) == '1') rightCnt++;
        }
        for(int i=0;i<n;i++){
            leftPrefix[i] += rightPrefix[i];
        }
        return leftPrefix;
    }
}