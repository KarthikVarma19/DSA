class Solution {
    int globalK;
    String ans;
    public String getHappyString(int n, int k) {
        ans = "";
        globalK = 0;
        char arr[] = new char[]{'a', 'b', 'c'}; 
        for(int i = 0; i < arr.length; i++){
            if(solve(""+arr[i], n, arr, k) == true){
                return ans;
            }
        }
        return ans;
    }
    public boolean solve(String cur, int n, char arr[], int k){
        
        if(cur.length() == n){
            globalK++;
            if(globalK == k){
                ans = cur;
                return true;
            }
            return false;
        }
        for(int i = 0; i < arr.length; i++){   
            if(cur.charAt(cur.length()-1) == arr[i]){
                continue;
            }
            if(solve(cur + arr[i], n, arr, k) == true){
                return true;
            }
        }
        return false;
    }
}