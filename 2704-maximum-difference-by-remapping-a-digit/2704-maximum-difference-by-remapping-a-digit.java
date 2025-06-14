class Solution {
    public int minMaxDifference(int num) {
        char arr[] = String.valueOf(num).toCharArray();
        
        char changeNum = '!';
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != '9' && changeNum == '!'){
                changeNum = arr[i];
                arr[i] = '9';
            }else if(arr[i] == changeNum){
                arr[i] = '9';
            }
        }
        
        char arr1[] = String.valueOf(num).toCharArray();
        char changeNum1 = '!';
        for(int i = 0; i < arr.length; i++){
            if(arr1[i] != '0' && changeNum1 == '!'){
                changeNum1 = arr1[i];
                arr1[i] = '0';
            }else if(arr1[i] == changeNum1){
                arr1[i] = '0';
            }
        }
        int maxVal = Integer.parseInt(new String(arr));
        int minVal = Integer.parseInt(new String(arr1));
        return maxVal-minVal;
    }
}
