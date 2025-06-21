class Solution {
    public int minimumDeletions(String word, int k) {
        int freq[] = new int[26];
        for(char ch: word.toCharArray()){
            freq[ch-'a']++;
        }
        // for every frequency consider it as lowest allowed value(x) and (x+k) as highest value
        // if it has not been there make it deleted 
        int min = word.length();
        for(int i = 0; i < 26; i++){
            int del = 0;
            for(int j = 0; j < 26; j++){
                if(freq[j] < freq[i]){
                    del += freq[j];
                }else if(freq[j] > freq[i] + k){
                    del += (freq[j]-freq[i]-k);
                }
            }
            min = Math.min(min, del);
        }
        return min;
    }
}