class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int anspointer = 0;
        int i = 0;
        int ans = 0;
        while(i < n){
            char cur = chars[i];
            int j = i;
            while(j < n && cur == chars[j]){
                j++;
            }
            ans += 1; // for distinct character
            chars[anspointer] = cur;
            anspointer += 1;
            int count = j - i;
            int curLen = String.valueOf(count).length();
            if(count > 1){
                int backtofront = anspointer + curLen - 1;
                while(count > 0){
                    ans += 1;
                    int last = count%10;
                    chars[backtofront] = (char)(last + '0');
                    backtofront--;
                    count /= 10;
                }
                anspointer += curLen;
            }
            i = j;
        }
        return ans;
    }
}