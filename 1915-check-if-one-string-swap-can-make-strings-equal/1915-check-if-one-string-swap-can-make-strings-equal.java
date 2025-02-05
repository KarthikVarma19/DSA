class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        if(l1 != l2) return false;
        int flag = 0, swaps = 0;
        char c1 = '\0';
        char c2 = '\0';
        for(int i = 0; i < l1; i++){
            if(s1.charAt(i) != s2.charAt(i)){
                if(c1 == s2.charAt(i) && c2 == s1.charAt(i)){
                    flag--;
                    swaps++;
                }
                else if((c1 == '\0') && (c2 == '\0')){
                    flag++;
                    c1 = s1.charAt(i);
                    c2 = s2.charAt(i);
                }
                else if(s1.charAt(i) != s2.charAt(i)){
                    flag++;
                }
            }
        }
        return swaps <= 1 && flag == 0;
    }
}