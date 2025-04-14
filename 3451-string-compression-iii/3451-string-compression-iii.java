class Solution {
    public String compressedString(String word) {
        int n = word.length();
        int i = 0;
        StringBuilder comp = new StringBuilder();
        while(i < n){
            int j = i;
            char cur = word.charAt(i);
            while(j < n && (j-i+1) < 10 && word.charAt(j) == cur){
                j++;
            }
            int count = j - i;
            comp.append((char)(count+'0'));
            comp.append(cur);
            i = j;
        }
        return comp.toString();
    }
}