class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        for(int i = 0; i < words.length; i++){
            for(int j = i + 1; j < words.length; j++){
                if(isPrefixAndSuffix(words[i], words[j]) == true){
                    count++;
                }
            }
        }
        return count;
    }
    private boolean isPrefixAndSuffix(String a, String b){
        int n = a.length();
        int m = b.length();
        if(b.length() < a.length()) return false;
        if(a == b) return true;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                return false;
            }
        }
        int i = n-1, j = m - 1;
        while(i>=0 && j>=0){
            if(a.charAt(i) != b.charAt(j)){
                return false;
            }
            i--;
            j--;
        } 
        return true;
    }
}